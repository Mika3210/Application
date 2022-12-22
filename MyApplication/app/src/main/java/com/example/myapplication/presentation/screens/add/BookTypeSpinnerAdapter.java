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

import java.util.List;

public class BookTypeSpinnerAdapter extends ArrayAdapter<BookType> {
    private final Context context;
    private final int textViewResourceId;
    private final List<BookType> objects;

    public BookTypeSpinnerAdapter(Context context, int textViewResourceId, List<BookType> objects) {
        super(context, textViewResourceId, objects);
        this.context = context;
        this.textViewResourceId = textViewResourceId;
        this.objects = objects;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) convertView = View.inflate(context, textViewResourceId, null);

        TextView tv = convertView.findViewById(R.id.title_type);
        tv.setText(objects.get(position).typeName);

        return convertView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) convertView = View.inflate(context, textViewResourceId, null);

        TextView tv = convertView.findViewById(R.id.title_type);
        tv.setText(objects.get(position).typeName);

        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return this.getItem(position).idBookType;
    }
}
