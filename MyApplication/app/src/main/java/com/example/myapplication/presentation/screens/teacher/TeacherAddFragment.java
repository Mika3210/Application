package com.example.myapplication.presentation.screens.teacher;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentAddTeacherBinding;
import com.example.myapplication.model.Teacher;
import com.example.myapplication.model.Titul;
import com.example.myapplication.presentation.screens.BaseFragment;
import com.example.myapplication.presentation.screens.titul.TitulViewModel;
import com.example.myapplication.repository.Status;

public class TeacherAddFragment extends BaseFragment {

    private TeacherViewModel mViewModel;
    private TitulViewModel mTitulViewModel;
    private FragmentAddTeacherBinding binding;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(requireActivity(), viewModelFactory).get(TeacherViewModel.class);
        mTitulViewModel = new ViewModelProvider(requireActivity(), viewModelFactory).get(TitulViewModel.class);
        binding = FragmentAddTeacherBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




        mTitulViewModel.getTituls().observe(getViewLifecycleOwner(), tituls -> {
            if (tituls.getStatus() != Status.LOADING) {


                // Create an ArrayAdapter using the string array and a default spinner layout
                TitulSpinnerAdapter adapter = new TitulSpinnerAdapter(getContext(), R.layout.titul_spinner_list, tituls.getData());

                //     ArrayAdapter.createFromResource(this, ,android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
                binding.grade.setAdapter(adapter);
            }

        });


        binding.addTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fam = binding.familiya.getText().toString();
                String imya = binding.imya.getText().toString();
                String otchestvo = binding.otchestvo.getText().toString();
                String vyz = binding.vyz.getText().toString();
                Integer titul = Math.toIntExact(binding.grade.getSelectedItemId());

                //Добавить проверку имени на пустоту и подсвечивать пустые поля
                if ("".equals(fam)) {
                    // Добавить тему на ошибочное значение
                    Toast.makeText(getContext(), getText(R.string.check_titul), Toast.LENGTH_LONG).show();
                    binding.familiya.setBackgroundResource(R.drawable.err_field);
                } else if ("".equals(imya)) {
                    Toast.makeText(getContext(), getText(R.string.check_titul), Toast.LENGTH_LONG).show();
                    binding.imya.setBackgroundResource(R.drawable.err_field);
                } else {
                    mViewModel.add(fam, imya, otchestvo,vyz,titul);
                    NavHostFragment.findNavController(TeacherAddFragment.this).popBackStack();
                }
            }

        });
    }
}
