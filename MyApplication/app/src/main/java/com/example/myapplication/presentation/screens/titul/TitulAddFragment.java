package com.example.myapplication.presentation.screens.titul;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentAddTitulBinding;
import com.example.myapplication.model.Titul;
import com.example.myapplication.presentation.screens.BaseFragment;
import com.example.myapplication.repository.Status;


public class TitulAddFragment extends BaseFragment {

    private TitulViewModel mViewModel;
    private FragmentAddTitulBinding binding;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(requireActivity(), viewModelFactory).get(TitulViewModel.class);
        binding = FragmentAddTitulBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewModel.getTituls().observe(getViewLifecycleOwner(), tituls -> {
            if (tituls.getStatus()!= Status.LOADING) {


                for (Titul titul : tituls.getData()
                ) {
                    Toast.makeText(getContext(), titul.nameTitul, Toast.LENGTH_LONG).show();
                }
            }
        });

        binding.addTitul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = binding.nameTitul.getText().toString();
                if ("".equals(text)) {
                    Toast.makeText(getContext(), getText(R.string.check_titul), Toast.LENGTH_LONG).show();
                } else {
                    mViewModel.add(text);
                    NavHostFragment.findNavController(TitulAddFragment.this).popBackStack();
                }
            }
        });
    }

}


