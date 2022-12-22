package com.example.myapplication.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.myapplication.model.Teacher;
import com.example.myapplication.model.TeacherWithTitul;
import com.example.myapplication.model.Titul;

import java.util.List;

@Dao
public interface TeacherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Teacher teacher);

    @Query("SELECT * FROM teacher WHERE idteacher = :id")
    LiveData<Teacher> findbyId(Integer id);

    @Query("SELECT * from teacher")
    LiveData<List<TeacherWithTitul>> findAll();
}
