package com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.remote;

import com.beknumonov.android_mvvm_rxandroid_retrofit_hilt_dao.model.User;

import io.reactivex.rxjava3.core.Single;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface MainApi {

    @POST("/v1/login/")
    Single<User> login(@Body User user);


    @POST("/v1/login/")
    Call<User> login1(@Body User user);

    @POST("/v1/user/")
    Single<User> createUser(@Body User user);

    @PUT("/v1/user/{id}/")
    Single<User> updateUser(@Path("id") int id, @Body User user);
}
