package com.example.myapplication.repository;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;

import com.example.myapplication.api.ApiResponse;
import com.example.myapplication.api.BookService;
import com.example.myapplication.db.TitulDao;
import com.example.myapplication.model.Titul;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TitulRepository {
    private final TitulDao mTitulDao;
    private final BookService mBookService;
    private Executor mExecutor = Executors.newSingleThreadExecutor();

    private final RateLimiter limiter = new RateLimiter(2, TimeUnit.MINUTES);

    @Inject
    TitulRepository(TitulDao titulDao, BookService bookService) {
        this.mBookService = bookService;
        this.mTitulDao = titulDao;
    }

    public void insertTitul(Titul titul) {
        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mTitulDao.insert(titul);
            }
        });

    }

    public LiveData<Resource<Titul>> getTitul(Integer titulId) {
        return new NetworkBoundResource<Titul, Titul>() {
            @Override
            protected void saveCallResult(@NonNull Titul item) {
                if (item != null)
                    mTitulDao.insert(item);
            }

            @Override
            protected boolean shouldFetch(@Nullable Titul data) {
                return data == null || limiter.shouldFetch();
            }

            @NonNull
            @Override
            protected LiveData<Titul> loadFromDb() {
                return mTitulDao.findbyId(titulId);
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<Titul>> createCall() {
                return mBookService.getTitul(titulId);
            }
        }.asLiveData();
    }

    public LiveData<Resource<List<Titul>>> getTituls() {
        return new NetworkBoundResource<List<Titul>, List<Titul>>() {
            @Override
            protected void saveCallResult(@NonNull List<Titul> list) {
                if (list != null)
                    for (Titul item : list) {
                        mTitulDao.insert(item);
                    }
            }

            @Override
            protected boolean shouldFetch(@Nullable List<Titul> data) {
               // return data == null || limiter.shouldFetch();
                return false;
            }

            @NonNull
            @Override
            protected LiveData<List<Titul>> loadFromDb() {
                return mTitulDao.findAll();
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<List<Titul>>> createCall() {
                return mBookService.getTituls();
            }
        }.asLiveData();
    }
}


