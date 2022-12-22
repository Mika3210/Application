package com.example.myapplication.db.converters;

import androidx.room.TypeConverter;

import com.example.myapplication.model.BookType;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class BookTypeConverter {
    @TypeConverter
    public static String fromBookType(BookType value) {
        if (value == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<BookType>() {
        }.getType();
        return gson.toJson(value, type);
    }

    @TypeConverter
    public static BookType fromString(String value) {
        if (value == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<BookType>() {
        }.getType();
        return gson.fromJson(value, type);
    }
}
