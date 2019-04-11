package com.example.aorora.network;

import com.example.aorora.model.RetroPhoto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("/butterfly/?format=json")
    Call<List<RetroPhoto>> getAllButterflies();
}
