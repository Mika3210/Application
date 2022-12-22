package com.example.myapplication.db.converters;

import androidx.room.TypeConverter;

import com.example.myapplication.model.Teacher;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class TeacherConverter {
    @TypeConverter
    public static String fromTeacher(Teacher value) {
        if (value == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Teacher>() {
        }.getType();
        return gson.toJson(value, type);
    }

    @TypeConverter
    public static Teacher fromString(String value) {
        if (value == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Teacher>() {
        }.getType();
        return gson.fromJson(value, type);
    }
}
