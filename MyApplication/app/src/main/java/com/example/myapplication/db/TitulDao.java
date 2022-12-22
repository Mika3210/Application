package com.example.myapplication.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.myapplication.model.Titul;

import java.util.List;

@Dao
public interface TitulDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Titul ...titul);


    @Query("SELECT * from titul where idTitul=:id")
    LiveData<Titul> findbyId(Integer id);

    @Query("SELECT * from titul")
    LiveData<List<Titul>> findAll();
}
