package com.example.myapplication.presentation.screens.titul;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.model.Titul;
import com.example.myapplication.repository.Resource;
import com.example.myapplication.repository.TitulRepository;

import java.util.List;

import javax.inject.Inject;

public class TitulViewModel extends ViewModel {
    private final TitulRepository mTitulRepository;

    @Inject
    public TitulViewModel(TitulRepository titulRepository) {
        mTitulRepository = titulRepository;
    }

    public void add(String value) {
        Titul titul = new Titul(value);
        mTitulRepository.insertTitul(titul);
    }

    public LiveData<Resource<List<Titul>>> getTituls() {
        return mTitulRepository.getTituls();
    }
}
