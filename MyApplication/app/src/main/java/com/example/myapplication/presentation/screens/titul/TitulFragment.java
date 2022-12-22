package com.example.myapplication.presentation.screens.titul;

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
import com.example.myapplication.databinding.FragmentScrollTitulBinding;
import com.example.myapplication.model.Titul;
import com.example.myapplication.presentation.screens.BaseFragment;
import com.example.myapplication.repository.Status;


public class TitulFragment extends BaseFragment {

    private TitulViewModel mViewModel;
    private FragmentScrollTitulBinding binding;
    public static TitulFragment newInstance() {
        return new TitulFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(requireActivity(), viewModelFactory).get(TitulViewModel.class);
        binding = FragmentScrollTitulBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.scrollTitul.setLayoutManager(new LinearLayoutManager(getContext()));
        mViewModel.getTituls().observe(getViewLifecycleOwner(), tituls -> {
            if (tituls.getStatus()!= Status.LOADING) {
                binding.scrollTitul.setAdapter(new TitulAdapter(tituls.getData()));

            }
        });


        binding.addTitul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(TitulFragment.this)
                        .navigate(R.id.action_titulFragment_to_titulAddFragment);
            }
        });
    }
}
