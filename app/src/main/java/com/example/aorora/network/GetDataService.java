package com.example.aorora.network;

import com.example.aorora.model.Butterfly;
import com.example.aorora.model.RetroPhoto;
import com.example.aorora.model.UserAuth;
import com.example.aorora.model.UserInfo;
import com.example.aorora.model.UserInteraction;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
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
    Call<Butterfly> createButterfly(@Field("butterfly_id") Integer butterfly_id,
                                    @Field("user_id") Integer user_id);

    @POST("/userbutterfly")
    Call<Butterfly> createButterfly(@Body Butterfly user);

    @POST("/api-token-auth")
    @FormUrlEncoded
    Call<UserAuth> login(@Field("username") String username, @Field("password") String password);

    @POST("/userinteraction")
    @FormUrlEncoded
    Call<UserInteraction> userInteract(@Field("initiator_user_id") Integer sender,
                                       @Field("receiver_user_id") Integer receiver,
                                       @Field("user_interaction_type_id") Integer interaction_type_id,
                                       @Field("user_interaction_content") String content);
}