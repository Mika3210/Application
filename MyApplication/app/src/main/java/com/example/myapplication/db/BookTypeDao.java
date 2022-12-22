package com.example.myapplication.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.myapplication.model.BookType;
import com.example.myapplication.model.Titul;

import java.util.List;

@Dao
public interface BookTypeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(BookType bookType);

    @Query("SELECT * FROM bookType WHERE id_book_type = :id")
    LiveData<BookType> findbyId(Integer id);


    @Query("SELECT * from bookType")
    LiveData<List<BookType>> findAll();


}
