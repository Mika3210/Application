package com.example.myapplication.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.myapplication.model.Book;
import com.example.myapplication.model.BookWithType;


import java.util.List;

@Dao
public interface BookDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Book book);

    @Transaction
    @Query("SELECT * FROM book WHERE id = :id")
    LiveData<List<BookWithType>> findById(Integer id);

    @Transaction
    @Query("SELECT * FROM book "
            + "WHERE authorId = :authorId "
            + "ORDER BY publishYear DESC")
    LiveData<List<BookWithType>> loadBooks(Integer authorId);


    @Query("SELECT * FROM book WHERE id = :id")
    LiveData<Book> findbyId(Integer id);

    @Query("SELECT * from book")
    LiveData<List<BookWithType>> findAll();

}
