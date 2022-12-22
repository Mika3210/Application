package com.example.myapplication.presentation.screens.type;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.model.BookType;
import com.example.myapplication.model.Titul;
import com.example.myapplication.repository.BookTypeRepository;
import com.example.myapplication.repository.Resource;
import com.example.myapplication.repository.TitulRepository;

import java.util.List;

import javax.inject.Inject;

public class BookTypeViewModel extends ViewModel {
    private final BookTypeRepository mBookTypeRepository;

    @Inject
    public BookTypeViewModel(BookTypeRepository typeRepository) {
        mBookTypeRepository = typeRepository;
    }

    public void add(String value) {
        BookType type = new BookType(value);
        mBookTypeRepository.insertBookType(type);
    }

    public LiveData<Resource<List<BookType>>> getBookTypes() {
        return mBookTypeRepository.getBookTypes();
    }
}
