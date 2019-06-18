package com.example.aorora.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserInteraction {

    @SerializedName("user_interaction_id")
    @Expose
    private Integer user_interaction_id;

    public UserInteraction(Integer user_interaction_id) {
        this.user_interaction_id = user_interaction_id;
    }

    public Integer getUser_interaction_id() {
        return user_interaction_id;
    }

    public void setUser_interaction_id(Integer user_interaction_id) {
        this.user_interaction_id = user_interaction_id;
    }
}
