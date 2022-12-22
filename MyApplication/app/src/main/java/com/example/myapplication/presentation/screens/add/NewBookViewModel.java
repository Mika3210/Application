package com.example.myapplication.presentation.screens.add;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.model.Book;
import com.example.myapplication.model.BookWithType;
import com.example.myapplication.model.TeacherWithTitul;
import com.example.myapplication.repository.BookRepository;
import com.example.myapplication.repository.Resource;
import com.example.myapplication.repository.TeacherRepository;

import java.util.List;

import javax.inject.Inject;

public class NewBookViewModel extends ViewModel {
    private final BookRepository mBookRepository;
    private final TeacherRepository mTeacherRepository;

    @Inject
    public NewBookViewModel(BookRepository bookRepository, TeacherRepository teacherRepository) {
        mBookRepository = bookRepository;
        mTeacherRepository = teacherRepository;
    }



    public void add(String value, String value2, String value3,Integer value4,String value5, Integer value6, Integer value7) {
        Book book = new Book(value,value2,value3, value4,value5, value6, value7);
        mBookRepository.insertBook(book);
    }

    public LiveData<Resource<List<BookWithType>>> getBooks() {
        return mBookRepository.getBooks();
    }
    public LiveData<Resource<List<TeacherWithTitul>>> getTeachers() {
        return mTeacherRepository.getTeachers();
    }

}