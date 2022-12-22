package com.example.myapplication.model;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class BookWithType {
    @Embedded
    public Book book;
    @Relation(parentColumn = "bookTypeId", entityColumn = "id_book_type", entity = BookType.class)
    public BookType bookType;
    @Relation(parentColumn = "authorId", entityColumn = "idteacher", entity = Teacher.class)
    public Teacher author;
}
