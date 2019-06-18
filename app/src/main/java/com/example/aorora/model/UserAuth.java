package com.example.aorora.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserAuth {

    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("user_id")
    @Expose
    private Integer user_id;

    public UserAuth(String token, Integer user_id) {
        this.token = token;
        this.user_id = user_id;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
    public String getToken() {
        return token;
    }
    public int getUser_id() {
        return user_id;
    }
}
