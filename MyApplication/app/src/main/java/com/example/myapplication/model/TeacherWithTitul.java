package com.example.myapplication.model;

import androidx.room.Embedded;
import androidx.room.Relation;

public class TeacherWithTitul {
    @Embedded
    public Teacher teacher;
    @Relation(parentColumn = "titulId", entityColumn = "idTitul", entity = Titul.class)
    public Titul titul;
}
