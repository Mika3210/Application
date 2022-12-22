package com.example.myapplication.presentation.screens.teacher;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;
import com.example.myapplication.model.Titul;

import java.util.List;

public class TitulSpinnerAdapter extends ArrayAdapter<Titul> {
    private final Context context;
    private final int textViewResourceId;
    private final List<Titul> objects;

    public TitulSpinnerAdapter(Context context, int textViewResourceId, List<Titul> objects) {
        super(context, textViewResourceId, objects);
        this.context = context;
        this.textViewResourceId = textViewResourceId;
        this.objects = objects;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) convertView = View.inflate(context, textViewResourceId, null);

        TextView tv = convertView.findViewById(R.id.title_titul);
        tv.setText(objects.get(position).nameTitul);

        return convertView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) convertView = View.inflate(context, textViewResourceId, null);

            TextView tv = convertView.findViewById(R.id.title_titul);
            tv.setText(objects.get(position).nameTitul);

        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return this.getItem(position).idTitul;
    }
}
