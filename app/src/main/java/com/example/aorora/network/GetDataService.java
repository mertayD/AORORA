package com.example.aorora.network;

import com.example.aorora.model.Butterfly;
import com.example.aorora.model.RetroPhoto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface GetDataService {

    @GET("/photos")
    Call<List<RetroPhoto>> getAllPhotos();

    @GET("/butterfly/?format=json")
    Call<List<Butterfly>> getButterflyInfo();


}
