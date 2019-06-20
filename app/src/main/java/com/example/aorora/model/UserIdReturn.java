package com.example.aorora.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserIdReturn {
    @SerializedName("user_id")
    @Expose
    private Integer user_id;

    public UserIdReturn(String token, Integer user_id) {
        this.user_id = user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public int getUser_id() {
        return user_id;
    }
}
