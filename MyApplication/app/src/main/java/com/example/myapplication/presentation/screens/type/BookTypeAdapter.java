package com.example.myapplication.presentation.screens.type;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.BookType;
import com.example.myapplication.model.Titul;
import com.example.myapplication.presentation.screens.titul.TitulAdapter;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class BookTypeAdapter extends RecyclerView.Adapter<BookTypeAdapter.ViewHolder> {

    private final List<BookType> localDataSet;

    public BookTypeAdapter(List<BookType> dataSet) {
        localDataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.type_spinner_list, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        BookType bookType = localDataSet.get(position);
        viewHolder.getTitleView().setText(bookType.typeName);
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final MaterialTextView titleView;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            titleView = view.findViewById(R.id.title_type);

        }

        public TextView getTitleView() {
            return titleView;
        }
    }
}

