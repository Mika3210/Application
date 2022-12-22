package com.example.myapplication.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class User {
    @PrimaryKey
    public Integer iduser;

    public String login;
    public String password;
}
