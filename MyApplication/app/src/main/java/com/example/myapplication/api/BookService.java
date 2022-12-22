package com.example.myapplication.api;

import androidx.lifecycle.LiveData;

import com.example.myapplication.model.Book;
import com.example.myapplication.model.BookType;
import com.example.myapplication.model.Teacher;
import com.example.myapplication.model.Titul;
import com.example.myapplication.model.User;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface BookService {
    @GET("users/{id}")
    LiveData<ApiResponse<User>> getUser(@Path("login") Integer id);

    @GET("users")
    LiveData<ApiResponse<List<User>>> getUsers();

    @POST("users")
    LiveData<ApiResponse<User>> postUsers(@Body User user);

    @GET("books/{id}")
    LiveData<ApiResponse<Book>> getBook(@Path("id") Integer id);

    @GET("books")
    LiveData<ApiResponse<List<Book>>> getBooks();

    @POST("books")
    LiveData<ApiResponse<Book>> postBooks(@Body Book book);

    @GET("booktypes/{id}")
    LiveData<ApiResponse<BookType>> getBookType(@Path("id") Integer id);

    @GET("booktypes")
    LiveData<ApiResponse<List<BookType>>> getBookTypes();

    @POST("booktypes")
    LiveData<ApiResponse<BookType>> postBookTypes(@Body BookType bookType);

    @GET("teachers/{id}")
    LiveData<ApiResponse<Teacher>> getTeacher(@Path("id") Integer id);

    @GET("teachers")
    LiveData<ApiResponse<List<Teacher>>> getTeachers();

    @POST("teachers")
    LiveData<ApiResponse<Teacher>> postTeachers(@Body Teacher teacher);

    @GET("tituls/{id}")
    LiveData<ApiResponse<Titul>> getTitul(@Path("id") Integer id);

    @GET("tituls")
    LiveData<ApiResponse<List<Titul>>> getTituls();

    @POST("tituls")
    LiveData<ApiResponse<Titul>> postTituls(@Body Titul titul);

}
