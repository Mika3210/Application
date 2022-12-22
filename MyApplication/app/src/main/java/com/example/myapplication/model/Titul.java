package com.example.myapplication.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Titul {
    @PrimaryKey
    public Integer idTitul;

    public String nameTitul;

    public Titul(){}

    public Titul(String value) {
        nameTitul = value;
    }
}
