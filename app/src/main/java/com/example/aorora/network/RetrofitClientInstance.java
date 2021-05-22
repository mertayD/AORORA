package com.example.aorora.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {

    private static Retrofit retrofit;
    //"https://jsonplaceholder.typicode.com";
    //"https://aroraserver.com" ip adress :8000
    //"http://104.248.178.78:8000"
    public static final String IP = "104.248.178.78";
    public static final Integer PORT = 8080;
    private static final String BASE_URL = "http://" + IP + ":" + PORT;


    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
