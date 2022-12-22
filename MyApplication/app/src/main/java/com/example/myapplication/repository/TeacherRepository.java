package com.example.myapplication.repository;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;

import com.example.myapplication.api.ApiResponse;
import com.example.myapplication.api.BookService;
import com.example.myapplication.db.TeacherDao;
import com.example.myapplication.model.Teacher;
import com.example.myapplication.model.TeacherWithTitul;


import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

public class TeacherRepository {
    private final TeacherDao mTeacherDao;
    private final BookService mBookService;
    private Executor mExecutor = Executors.newSingleThreadExecutor();

    private final RateLimiter limiter = new RateLimiter(2, TimeUnit.MINUTES);

    @Inject
    TeacherRepository(TeacherDao teacherDao, BookService bookService) {
        this.mBookService = bookService;
        this.mTeacherDao = teacherDao;
    }

    public void insertTeacher(Teacher teacher) {
        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mTeacherDao.insert(teacher);
            }
        });

    }

    public LiveData<Resource<Teacher>> getTeacher(Integer teacherId) {
        return new NetworkBoundResource<Teacher, Teacher>() {
            @Override
            protected void saveCallResult(@NonNull Teacher item) {
                if (item != null)
                    mTeacherDao.insert(item);
            }

            @Override
            protected boolean shouldFetch(@Nullable Teacher data) {
                return data == null || limiter.shouldFetch();
            }

            @NonNull
            @Override
            protected LiveData<Teacher> loadFromDb() {
                return mTeacherDao.findbyId(teacherId);
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<Teacher>> createCall() {
                return mBookService.getTeacher(teacherId);
            }
        }.asLiveData();
    }

    public LiveData<Resource<List<TeacherWithTitul>>> getTeachers() {
        return new NetworkBoundResource<List<TeacherWithTitul>, List<Teacher>>() {
            @Override
            protected void saveCallResult(@NonNull List<Teacher> list) {
                if (list != null)
                    for (Teacher item : list) {
                        mTeacherDao.insert(item);
                    }
            }

            @Override
            protected boolean shouldFetch(@Nullable List<TeacherWithTitul> data) {
                // return data == null || limiter.shouldFetch();
                return false;
            }

            @NonNull
            @Override
            protected LiveData<List<TeacherWithTitul>> loadFromDb() {
                return mTeacherDao.findAll();
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<List<Teacher>>> createCall() {
                return mBookService.getTeachers();
            }
        }.asLiveData();
    }
}
