package com.example.aorora.network;

import com.example.aorora.model.Butterfly;
import com.example.aorora.model.RetroPhoto;
import com.example.aorora.model.UserInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface GetDataService {

    @GET("/photos")
    Call<List<RetroPhoto>> getAllPhotos();

    @GET("/butterflies?format=json")
    Call<List<Butterfly>> getButterflyInfo();

    @GET("/userinfo/{user_id}?format=json")
    Call<List<UserInfo>> getUserInfo(@Path("user_id") Long user_id);

    @POST("/butterflies")
    Call<Butterfly> createButterfly(@Body Butterfly user);
}
