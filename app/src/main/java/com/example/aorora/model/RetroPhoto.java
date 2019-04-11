package com.example.aorora.model;

import com.google.gson.annotations.SerializedName;

public class RetroPhoto {

    @SerializedName("butterfly_id")
    private Integer butterfly_id;
    @SerializedName("butterfly_type_id")
    private Integer butterfly_type_id;
    @SerializedName("butterfly_create_at")
    private String butterfly_create_at;

    public RetroPhoto(Integer butterfly_id, Integer butterfly_type_id, String butterfly_create_at) {
        this.butterfly_id = butterfly_id;
        this.butterfly_type_id = butterfly_type_id;
        this.butterfly_create_at = butterfly_create_at;
    }

    public Integer getButterflyId() {
        return butterfly_id;
    }

    public void setButterflyId(Integer butterfly_id) {
        this.butterfly_id = butterfly_id;
    }

    public Integer getButterflyTypeId() {
        return butterfly_type_id;
    }

    public void setButterflyTypeId(Integer butterfly_type_id) {
        this.butterfly_type_id = butterfly_type_id;
    }

    public Integer getButterflyCreatedAt() {
        return butterfly_create_at;
    }

    public void getButterflyCreatedAt(Integer butterfly_create_at) {
        this.butterfly_create_at = butterfly_create_at;
    }
}
