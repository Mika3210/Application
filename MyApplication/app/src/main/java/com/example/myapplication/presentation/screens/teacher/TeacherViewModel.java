package com.example.myapplication.presentation.screens.teacher;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.model.Teacher;
import com.example.myapplication.model.TeacherWithTitul;
import com.example.myapplication.repository.Resource;
import com.example.myapplication.repository.TeacherRepository;

import java.util.List;

import javax.inject.Inject;

public class TeacherViewModel extends ViewModel {
    private final TeacherRepository mTeacherRepository;

    @Inject
    public TeacherViewModel(TeacherRepository teacherRepository) {
        mTeacherRepository = teacherRepository;
    }

    public void add(String value, String value2, String value3,String value4,Integer value5) {
        Teacher teacher = new Teacher(value,value2,value3, value4,value5);
        mTeacherRepository.insertTeacher(teacher);
    }

    public LiveData<Resource<List<TeacherWithTitul>>> getTeachers() {
       return mTeacherRepository.getTeachers();
    }

}
