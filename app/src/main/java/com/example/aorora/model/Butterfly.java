package com.example.aorora.model;
import com.google.gson.annotations.SerializedName;

public class Butterfly {
    @SerializedName("butterfly_id")
    private int butterfly_id;
    @SerializedName("butterfly_type_id")
    private int butterfly_type_id;
    @SerializedName("butterfly_create_at")
    private String butterfly_create_at;

    public Butterfly(Integer butterfly_id, Integer butterfly_type_id, String butterfly_create_at) {
        this.butterfly_id = butterfly_id;
        this.butterfly_type_id = butterfly_type_id;
        this.butterfly_create_at = butterfly_create_at;
    }

    public int getButterflyId() {
        return butterfly_id;
    }

    public void setButterflyId(Integer butterfly_id) {
        this.butterfly_id = butterfly_id;
    }

    public int getButterflyTypeId() {
        return butterfly_type_id;
    }

    public void setButterflyTypeId(int butterfly_type_id) {
        this.butterfly_type_id = butterfly_type_id;
    }

    public String getButterflyCreatedAt() {
        return butterfly_create_at;
    }

    public void getButterflyCreatedAt(String butterfly_create_at) {
        this.butterfly_create_at = butterfly_create_at;
    }
}
