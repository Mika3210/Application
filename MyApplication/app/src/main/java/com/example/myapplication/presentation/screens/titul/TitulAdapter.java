package com.example.myapplication.presentation.screens.titul;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.Titul;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class TitulAdapter extends RecyclerView.Adapter<TitulAdapter.ViewHolder> {

    private final List<Titul> localDataSet;

    public TitulAdapter(List<Titul> dataSet) {
        localDataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_titul, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Titul titul = localDataSet.get(position);
        viewHolder.getTitleView().setText(titul.nameTitul);
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

            titleView = view.findViewById(R.id.title_titul);

        }

        public TextView getTitleView() {
            return titleView;
        }
    }
}
