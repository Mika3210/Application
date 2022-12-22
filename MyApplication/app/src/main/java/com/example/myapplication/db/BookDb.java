package com.example.myapplication.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.myapplication.db.converters.TeacherConverter;
import com.example.myapplication.db.converters.TitulConverter;
import com.example.myapplication.model.Book;
import com.example.myapplication.model.BookType;
import com.example.myapplication.model.Teacher;
import com.example.myapplication.model.Titul;
import com.example.myapplication.model.User;

@Database(entities = {User.class, BookType.class, Teacher.class, Book.class,
        Titul.class}, version = 4, exportSchema = true)
@TypeConverters({TitulConverter.class, TeacherConverter.class})

public abstract class BookDb extends RoomDatabase {

    abstract public UserDao userDao();

    abstract public BookDao bookDao();

    abstract public BookTypeDao bookTypeDao();

    abstract public TeacherDao teacherDao();

    abstract public TitulDao titulDao();
}
