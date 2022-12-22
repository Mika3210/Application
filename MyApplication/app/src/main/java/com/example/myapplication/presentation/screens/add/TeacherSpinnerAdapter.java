package com.example.myapplication.presentation.screens.add;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;
import com.example.myapplication.model.BookType;
import com.example.myapplication.model.Teacher;
import com.example.myapplication.model.TeacherWithTitul;

import java.util.List;

public class TeacherSpinnerAdapter extends ArrayAdapter<TeacherWithTitul> {
    private final Context context;
    private final int textViewResourceId;
    private final List<TeacherWithTitul> objects;

    public TeacherSpinnerAdapter(Context context, int textViewResourceId, List<TeacherWithTitul> objects) {
        super(context, textViewResourceId, objects);
        this.context = context;
        this.textViewResourceId = textViewResourceId;
        this.objects = objects;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) convertView = View.inflate(context, textViewResourceId, null);

        TextView tv = convertView.findViewById(R.id.title_teacher);
        TeacherWithTitul teacher = objects.get(position);
        tv.setText(String.format("s% s% s%", teacher.teacher.familiya,teacher.teacher.imya, teacher.teacher.otchestvo));

        return convertView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) convertView = View.inflate(context, textViewResourceId, null);

        TextView tv = convertView.findViewById(R.id.title_teacher);
        TeacherWithTitul teacher = objects.get(position);
        tv.setText(String.format("%s %s %s", teacher.teacher.familiya,teacher.teacher.imya, teacher.teacher.otchestvo));

        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return this.getItem(position).teacher.idteacher;
    }
}
