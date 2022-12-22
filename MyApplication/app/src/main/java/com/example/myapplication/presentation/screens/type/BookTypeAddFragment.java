package com.example.myapplication.presentation.screens.type;

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
import com.example.myapplication.databinding.FragmentAddBookTypeBinding;
import com.example.myapplication.model.BookType;
import com.example.myapplication.presentation.screens.BaseFragment;
import com.example.myapplication.repository.Status;

public class BookTypeAddFragment extends BaseFragment {

    private BookTypeViewModel mViewModel;
    private FragmentAddBookTypeBinding binding;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(requireActivity(), viewModelFactory).get(BookTypeViewModel.class);
        binding = FragmentAddBookTypeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewModel.getBookTypes().observe(getViewLifecycleOwner(), booktypes -> {
            if (booktypes.getStatus()!= Status.LOADING) {


                for (BookType bookType : booktypes.getData()
                ) {
                    Toast.makeText(getContext(), bookType.typeName, Toast.LENGTH_LONG).show();
                }
            }
        });

        binding.addType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = binding.nameType.getText().toString();
                if ("".equals(text)) {
                    Toast.makeText(getContext(), getText(R.string.check_titul), Toast.LENGTH_LONG).show();
                } else {
                    mViewModel.add(text);
                    NavHostFragment.findNavController(BookTypeAddFragment.this).popBackStack();
                }
            }
        });
    }

}
