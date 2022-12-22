package com.example.myapplication.repository;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;

import com.example.myapplication.api.ApiResponse;
import com.example.myapplication.api.BookService;
import com.example.myapplication.db.BookTypeDao;
import com.example.myapplication.db.TitulDao;
import com.example.myapplication.model.BookType;
import com.example.myapplication.model.Titul;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

public class BookTypeRepository {
    private final BookTypeDao mBookTypeDao;
    private final BookService mBookService;
    private Executor mExecutor = Executors.newSingleThreadExecutor();

    private final RateLimiter limiter = new RateLimiter(2, TimeUnit.MINUTES);

    @Inject
    BookTypeRepository(BookTypeDao typeDao, BookService bookService) {
        this.mBookService = bookService;
        this.mBookTypeDao = typeDao;
    }

    public void insertBookType(BookType bookType) {
        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mBookTypeDao.insert(bookType);
            }
        });

    }

    public LiveData<Resource<BookType>> getBookType(Integer id) {
        return new NetworkBoundResource<BookType, BookType>() {
            @Override
            protected void saveCallResult(@NonNull BookType item) {
                if (item != null)
                    mBookTypeDao.insert(item);
            }

            @Override
            protected boolean shouldFetch(@Nullable BookType data) {
                return data == null || limiter.shouldFetch();
            }

            @NonNull
            @Override
            protected LiveData<BookType> loadFromDb() {
                return mBookTypeDao.findbyId(id);
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<BookType>> createCall() {
                return mBookService.getBookType(id);
            }
        }.asLiveData();
    }

    public LiveData<Resource<List<BookType>>> getBookTypes() {
        return new NetworkBoundResource<List<BookType>, List<BookType>>() {
            @Override
            protected void saveCallResult(@NonNull List<BookType> list) {
                if (list != null)
                    for (BookType item : list) {
                        mBookTypeDao.insert(item);
                    }
            }

            @Override
            protected boolean shouldFetch(@Nullable List<BookType> data) {
                // return data == null || limiter.shouldFetch();
                return false;
            }

            @NonNull
            @Override
            protected LiveData<List<BookType>> loadFromDb() {
                return mBookTypeDao.findAll();
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<List<BookType>>> createCall() {
                return mBookService.getBookTypes();
            }
        }.asLiveData();
    }
}

