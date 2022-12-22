package com.example.myapplication.presentation.screens.add;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentNewBookBinding;
import com.example.myapplication.presentation.screens.BaseFragment;
import com.example.myapplication.presentation.screens.teacher.TeacherViewModel;
import com.example.myapplication.presentation.screens.type.BookTypeViewModel;
import com.example.myapplication.repository.Status;

public class NewBookFragment extends BaseFragment {

    private NewBookViewModel mViewModel;
    private BookTypeViewModel mBookTypeViewModel;
    private TeacherViewModel teacherViewModel;
    private FragmentNewBookBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(requireActivity(), viewModelFactory).get(NewBookViewModel.class);
        mBookTypeViewModel = new ViewModelProvider(requireActivity(), viewModelFactory).get(BookTypeViewModel.class);
        teacherViewModel = new  ViewModelProvider(requireActivity(), viewModelFactory).get(TeacherViewModel.class);
        binding = FragmentNewBookBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mBookTypeViewModel.getBookTypes().observe(getViewLifecycleOwner(), booktypes -> {
            if (booktypes.getStatus() != Status.LOADING) {

                BookTypeSpinnerAdapter adapter = new BookTypeSpinnerAdapter(getContext(), R.layout.type_spinner_list, booktypes.getData());

                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                binding.type.setAdapter(adapter);
            }

        });

        teacherViewModel.getTeachers().observe(getViewLifecycleOwner(), teachers -> {
                    if (teachers.getStatus() != Status.LOADING) {

                        TeacherSpinnerAdapter adapter = new TeacherSpinnerAdapter(getContext(), R.layout.item_teacher, teachers.getData());

                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                        binding.type.setAdapter(adapter);
                    }
                });


        binding.pluse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String book = binding.book.getText().toString();
                String name = binding.bookName.getText().toString();
                String city = binding.city.getText().toString();
                Integer year = Integer.parseInt((binding.year.getText().toString()));
                String publisher = binding.publisher.getText().toString();
                Integer teacher = Math.toIntExact(binding.author.getSelectedItemId());
                Integer type = Math.toIntExact(binding.type.getSelectedItemId());

                mViewModel.add(book, name, city,year,publisher,teacher,type);
                NavHostFragment.findNavController(NewBookFragment.this).popBackStack();
                }
            });
        }
    }