package com.example.myapplication.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.presentation.screens.add.NewBookViewModel;
import com.example.myapplication.presentation.screens.login.LoginViewModel;
import com.example.myapplication.presentation.screens.main.MainViewModel;
import com.example.myapplication.presentation.screens.teacher.TeacherViewModel;
import com.example.myapplication.presentation.screens.titul.TitulViewModel;
import com.example.myapplication.presentation.screens.type.BookTypeViewModel;
import com.example.myapplication.presentation.viewmodel.BookViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    abstract ViewModel bindsMainViewModel(MainViewModel mainViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel.class)
    abstract ViewModel bindsLoginViewModel(LoginViewModel loginViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(NewBookViewModel.class)
    abstract ViewModel bindsNewBookViewModel(NewBookViewModel newBookViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(TitulViewModel.class)
    abstract ViewModel bindsTitulViewmodel(TitulViewModel titulViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindsViewModelFactory(BookViewModelFactory bookViewModelFactory);

    @Binds
    @IntoMap
    @ViewModelKey(TeacherViewModel.class)
    abstract ViewModel bindsTeacherViewmodel(TeacherViewModel teacherViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(BookTypeViewModel.class)
    abstract ViewModel bindsBookTypeViewModel(BookTypeViewModel bookTypeViewModel);


}
