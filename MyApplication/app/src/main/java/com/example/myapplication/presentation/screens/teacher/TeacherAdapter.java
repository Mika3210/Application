package com.example.myapplication.presentation.screens.teacher;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import com.example.myapplication.model.TeacherWithTitul;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.ViewHolder> {

    private final List<TeacherWithTitul> localDataSet;

    public TeacherAdapter(List<TeacherWithTitul> dataSet) {
        localDataSet = dataSet;
    }

    @Override
    public TeacherAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_teacher, viewGroup, false);

        return new TeacherAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(TeacherAdapter.ViewHolder viewHolder, final int position) {
        TeacherWithTitul teacher = localDataSet.get(position);
        viewHolder.getTitleView().setText(String.format("%s %s %s",teacher.teacher.imya, teacher.teacher.familiya, teacher.teacher.otchestvo));
        viewHolder.getVyzView().setText(teacher.teacher.vyz);
        if (teacher.titul !=null){
            viewHolder.getTitulView().setText(teacher.titul.nameTitul);
        }

    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final MaterialTextView titleView;
        private final MaterialTextView vyzView;
        private final MaterialTextView titulView;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            titleView = view.findViewById(R.id.title_teacher);
            vyzView = view.findViewById(R.id.vyz_view);
            titulView = view.findViewById(R.id.title_view);
        }

        public TextView getTitleView() {
            return titleView;
        }

        public TextView getVyzView() {
            return vyzView;
        }

         public  TextView getTitulView () {return titulView;}
    }
}
