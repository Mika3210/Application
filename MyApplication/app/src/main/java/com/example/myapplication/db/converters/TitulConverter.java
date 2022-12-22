package com.example.myapplication.db.converters;


import androidx.room.TypeConverter;

import com.example.myapplication.model.Titul;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class TitulConverter {
    @TypeConverter
    public static String fromTitul(Titul value) {
        if (value == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Titul>() {
        }.getType();
        return gson.toJson(value, type);
    }

    @TypeConverter
    public static Titul fromString(String value) {
        if (value == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Titul>() {
        }.getType();
        return gson.fromJson(value, type);
    }
}
