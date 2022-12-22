package com.example.myapplication.di;

import android.app.Application;

import androidx.room.Room;

import com.example.myapplication.api.BookService;
import com.example.myapplication.db.BookDao;
import com.example.myapplication.db.BookDb;
import com.example.myapplication.db.BookTypeDao;
import com.example.myapplication.db.TeacherDao;
import com.example.myapplication.db.TitulDao;
import com.example.myapplication.db.UserDao;
import com.example.myapplication.repository.LiveDataCallAdapterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = ViewModelModule.class)
public class AppModule {
    @Singleton
    @Provides
    BookService provideGithubService() {
        return new Retrofit.Builder()
                 .baseUrl("https://api.github.com/")
                 .addConverterFactory(GsonConverterFactory.create())
                 .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                .build()
                .create(BookService.class);
    }

    @Singleton
    @Provides
    BookDb provideDb(Application app) {

        return Room.databaseBuilder(app, BookDb.class, "book.db").fallbackToDestructiveMigration().build();
    }

    @Singleton
    @Provides
    UserDao provideUserDao(BookDb db) {
        return db.userDao();
    }

    @Singleton
    @Provides
    BookDao provideBookDao(BookDb db) {
        return db.bookDao();
    }

    @Singleton
    @Provides
    BookTypeDao provideBookTypeDao(BookDb db) {
        return db.bookTypeDao();
    }

    @Singleton
    @Provides
    TeacherDao provideTeacherDao(BookDb db) {
        return db.teacherDao();
    }

    @Singleton
    @Provides
    TitulDao provideTitulDao(BookDb db) {
        return db.titulDao();
    }

}

