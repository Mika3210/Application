package com.example.myapplication.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Teacher {
    @PrimaryKey
    public Integer idteacher;

    public String familiya;
    public String imya;
    public String otchestvo;
    public String vyz;
    //public Titul titul;
    public Integer titulId;

    public Teacher(String familiya, String imya, String otchestvo, String vyz, Integer titulId){
        this.familiya=familiya;
        this.imya = imya;
        this.otchestvo = otchestvo;
        this.vyz = vyz;
        this.titulId = titulId;
    }

}
