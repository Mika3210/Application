package com.example.myapplication.presentation.screens.type;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentScrollTypeBinding;
import com.example.myapplication.presentation.screens.BaseFragment;
import com.example.myapplication.repository.Status;

public class BookTypeFragment extends BaseFragment {

    private BookTypeViewModel mViewModel;
    private FragmentScrollTypeBinding binding;
    public static BookTypeFragment newInstance() {
        return new BookTypeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(requireActivity(), viewModelFactory).get(BookTypeViewModel.class);
        binding = FragmentScrollTypeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.scrollType.setLayoutManager(new LinearLayoutManager(getContext()));

        mViewModel.getBookTypes().observe(getViewLifecycleOwner(), booktypes -> {
            if (booktypes.getStatus() != Status.LOADING) {

                binding.scrollType.setAdapter(new BookTypeAdapter(booktypes.getData()));

            }
        });
        binding.addType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(BookTypeFragment.this)
                        .navigate(R.id.action_typeFragment_to_bookTypeAddFragment);
            }
        });
    }
}
