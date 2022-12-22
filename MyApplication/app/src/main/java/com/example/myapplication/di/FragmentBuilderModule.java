package com.example.myapplication.di;

import com.example.myapplication.presentation.screens.add.NewBookFragment;
import com.example.myapplication.presentation.screens.login.LoginFragment;
import com.example.myapplication.presentation.screens.main.MainFragment;
import com.example.myapplication.presentation.screens.teacher.TeacherAddFragment;
import com.example.myapplication.presentation.screens.teacher.TeacherFragment;
import com.example.myapplication.presentation.screens.titul.TitulAddFragment;
import com.example.myapplication.presentation.screens.titul.TitulFragment;
import com.example.myapplication.presentation.screens.type.BookTypeAddFragment;
import com.example.myapplication.presentation.screens.type.BookTypeFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract NewBookFragment newBookFragment();

    @ContributesAndroidInjector
    abstract LoginFragment loginFragment();

    @ContributesAndroidInjector
    abstract MainFragment mainFragment();

    @ContributesAndroidInjector
    abstract TitulAddFragment titulAddFragment();

    @ContributesAndroidInjector
    abstract TitulFragment titulFragment();

    @ContributesAndroidInjector
    abstract TeacherFragment teacherFragment();

    @ContributesAndroidInjector
    abstract TeacherAddFragment teacherAddFragment();

    @ContributesAndroidInjector
    abstract BookTypeAddFragment bookTypeAddFragment();

    @ContributesAndroidInjector
    abstract BookTypeFragment bookTypeFragment();
}