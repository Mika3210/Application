package com.example.myapplication.presentation.screens.teacher;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentScrollTeacherBinding;
import com.example.myapplication.model.Teacher;
import com.example.myapplication.presentation.screens.BaseFragment;
import com.example.myapplication.repository.Status;

public class TeacherFragment extends BaseFragment {

    private TeacherViewModel mViewModel;
    private FragmentScrollTeacherBinding binding;
    public static TeacherFragment newInstance() {
        return new TeacherFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(requireActivity(), viewModelFactory).get(TeacherViewModel.class);
        binding = FragmentScrollTeacherBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.scrollTeacher.setLayoutManager(new LinearLayoutManager(getContext()));

        mViewModel.getTeachers().observe(getViewLifecycleOwner(), teachers -> {
            if (teachers.getStatus() != Status.LOADING) {

                binding.scrollTeacher.setAdapter(new TeacherAdapter(teachers.getData()));

            }
        });
        binding.addTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(TeacherFragment.this)
                        .navigate(R.id.action_teacherFragment_to_teacherAddFragment);
            }
        });
    }
}
