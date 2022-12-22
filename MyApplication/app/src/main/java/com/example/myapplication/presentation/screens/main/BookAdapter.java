package com.example.myapplication.presentation.screens.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.BookWithType;
import com.google.android.material.textview.MaterialTextView;


import java.util.List;


public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {

    private final List<BookWithType> localDataSet;

    public BookAdapter(List<BookWithType> dataSet) {
        localDataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_book, viewGroup, false);

        return new BookAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        BookWithType book = localDataSet.get(position);
        viewHolder.getTitleView().setText(book.book.sectionName);
        viewHolder.getBookNameView().setText(book.book.bookName);
        viewHolder.getYearView().setText(book.book.publishYear.toString());
        viewHolder.getCityView().setText(book.book.publishCity.toString());
        viewHolder.getPublisherView().setText(book.book.publisher.toString());
        viewHolder.getTeacherView().setText(String.format("%s %s %s", book.author.familiya, book.author.imya, book.author.otchestvo));
        viewHolder.getTypeView().setText(String.format(book.bookType.typeName));
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final MaterialTextView titleView;
        private final MaterialTextView bookNameView;
        private final MaterialTextView yearView;
        private final MaterialTextView cityView;
        private final  MaterialTextView publisherView;
        private final MaterialTextView teacherView;
        private final MaterialTextView typeView;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            titleView = view.findViewById(R.id.title_book);
            bookNameView = view.findViewById(R.id.book_view);
            yearView = view.findViewById(R.id.year_view);
            cityView = view.findViewById(R.id.city_view);
            publisherView = view.findViewById(R.id.publisher_view);
            teacherView = view.findViewById(R.id.teacher_view);
            typeView = view.findViewById(R.id.type_view);
        }

        public TextView getTitleView() {
            return titleView;
        }

        public TextView getBookNameView() {
            return bookNameView;
        }

        public TextView getYearView() {
            return yearView;
        }

        public TextView getCityView() {
            return  cityView;
        }

        public TextView getPublisherView() {
            return publisherView;
        }

        public TextView getTeacherView() {
            return teacherView;
        }

        public TextView getTypeView() {
            return typeView;
        }
    }
}