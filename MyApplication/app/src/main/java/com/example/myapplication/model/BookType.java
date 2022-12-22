package com.example.myapplication.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "bookType")
public class BookType {
    @PrimaryKey
    @ColumnInfo(name = "id_book_type")
    public Integer idBookType;

    public String typeName;

    public BookType() {
    }

    public BookType(String value) {
        this.typeName = value;
    }

    public Integer getIdBookType() {
        return idBookType;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
