package com.example.myapplication.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "book")
public class Book {
    @PrimaryKey
    public Integer id;
    public String bookName;
    public Integer bookTypeId;
    public String sectionName;
    public Integer authorId;
    public String publisher;
    public Integer publishYear;
    public String publishCity;

    public Book(){}

    public Book(String value, String value2, String value3, Integer value4, String value5, Integer value6,Integer value7) {
        this.sectionName = value;
        this.bookName = value2;
        this.publishCity = value3;
        this.publishYear = value4;
        this.publisher = value5;
        this.authorId = value6;
        this.bookTypeId = value7;
    }
}
