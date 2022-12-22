package com.example.myapplication.presentation.screens.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.myapplication.R;

import com.example.myapplication.databinding.FragmentAddBookTypeBinding;
import com.example.myapplication.databinding.FragmentMainBinding;
import com.example.myapplication.model.Book;
import com.example.myapplication.model.BookType;
import com.example.myapplication.model.BookWithType;
import com.example.myapplication.presentation.screens.BaseFragment;
import com.example.myapplication.presentation.screens.add.NewBookViewModel;
import com.example.myapplication.presentation.screens.type.BookTypeAdapter;
import com.example.myapplication.presentation.screens.type.BookTypeAddFragment;
import com.example.myapplication.presentation.screens.type.BookTypeFragment;
import com.example.myapplication.presentation.screens.type.BookTypeViewModel;
import com.example.myapplication.repository.Status;


import java.util.ArrayList;

public class MainFragment extends BaseFragment {

    private NewBookViewModel mViewModel;

    private FragmentMainBinding binding;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(requireActivity(), viewModelFactory).get(NewBookViewModel.class);
        binding =FragmentMainBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.scrollBook.setLayoutManager(new LinearLayoutManager(getContext()));

        mViewModel.getBooks().observe(getViewLifecycleOwner(), books -> {
            if (books.getStatus() != Status.LOADING) {

                binding.scrollBook.setAdapter(new BookAdapter(books.getData()));

            }
        });
        binding.addBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(MainFragment.this)
                        .navigate(R.id.action_MainFragment_to_NewBookFragment);
            }
        });
    }

}