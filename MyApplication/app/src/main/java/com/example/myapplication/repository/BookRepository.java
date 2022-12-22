package com.example.myapplication.repository;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;

import com.example.myapplication.api.ApiResponse;
import com.example.myapplication.api.BookService;
import com.example.myapplication.db.BookDao;
import com.example.myapplication.db.TeacherDao;
import com.example.myapplication.db.TitulDao;
import com.example.myapplication.model.Book;
import com.example.myapplication.model.BookWithType;
import com.example.myapplication.model.Teacher;
import com.example.myapplication.model.TeacherWithTitul;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

public class BookRepository {
    private final BookDao mBookDao;
    private final BookService mBookService;
    private Executor mExecutor = Executors.newSingleThreadExecutor();

    private final RateLimiter limiter = new RateLimiter(2, TimeUnit.MINUTES);

    @Inject
    BookRepository(BookDao bookDao, BookService bookService) {
        this.mBookService = bookService;
        this.mBookDao = bookDao;
    }


    public void insertBook(Book book) {
        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mBookDao.insert(book);
            }
        });

    }

    public LiveData<Resource<Book>> getBook(Integer id) {
        return new NetworkBoundResource<Book, Book>() {
            @Override
            protected void saveCallResult(@NonNull Book item) {
                if (item != null)
                    mBookDao.insert(item);
            }

            @Override
            protected boolean shouldFetch(@Nullable Book data) {
                return data == null || limiter.shouldFetch();
            }

            @NonNull
            @Override
            protected LiveData<Book> loadFromDb() {
                return mBookDao.findbyId(id);
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<Book>> createCall() {
                return mBookService.getBook(id);
            }
        }.asLiveData();
    }

    public LiveData<Resource<List<BookWithType>>> getBooks() {
        return new NetworkBoundResource<List<BookWithType>, List<Book>>() {
            @Override
            protected void saveCallResult(@NonNull List<Book> list) {
                if (list != null)
                    for (Book item : list) {
                        mBookDao.insert(item);
                    }
            }

            @Override
            protected boolean shouldFetch(@Nullable List<BookWithType> data) {
                // return data == null || limiter.shouldFetch();
                return false;
            }

            @NonNull
            @Override
            protected LiveData<List<BookWithType>> loadFromDb() {
                return mBookDao.findAll();
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<List<Book>>> createCall() {
                return mBookService.getBooks();
            }
        }.asLiveData();
    }
}
