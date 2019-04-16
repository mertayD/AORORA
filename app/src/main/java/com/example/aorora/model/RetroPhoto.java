package com.example.aorora.model;

import com.google.gson.annotations.SerializedName;

public class RetroPhoto {
    @SerializedName("albumId")
    private Integer albumId;
    @SerializedName("id")
    private Integer id;
    @SerializedName("title")
    private String title;
    @SerializedName("url")
    private String url;
    @SerializedName("thumbnailUrl")
    private String thumbnailUrl;

    public RetroPhoto(Integer albumId, Integer id, String title, String url, String thumbnailUrl) {
        this.albumId = albumId;
        this.id = id;
        this.title = title;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}

/*
@SerializedName("butterfly_id")
    private int butterfly_id;
    @SerializedName("butterfly_type_id")
    private int butterfly_type_id;
    @SerializedName("butterfly_create_at")
    private String butterfly_create_at;

    public RetroPhoto(Integer butterfly_id, Integer butterfly_type_id, String butterfly_create_at) {
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
 */