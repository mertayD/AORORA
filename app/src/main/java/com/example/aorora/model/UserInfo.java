package com.example.aorora.model;

import com.google.gson.annotations.SerializedName;

public class UserInfo {
    @SerializedName("user_info_id")
    private Integer user_info_id;
    @SerializedName("user_name_of_strength")
    private String user_name_of_strength;
    @SerializedName("user_id")
    private Integer user_id;
    @SerializedName("user_created_at")
    private String user_created_at;
    @SerializedName("user_current_mood")
    private Integer user_current_mood;
    @SerializedName("user_current_mood_updated")
    private String user_current_mood_updated;
    @SerializedName("user_current_location_lat")
    private Integer user_current_location_lat;
    @SerializedName("user_current_location_long")
    private Integer user_current_location_long;
    @SerializedName("user_current_location_updated")
    private String user_current_location_updated;
    @SerializedName("user_current_butterfly")
    private Integer user_current_butterfly;
    @SerializedName("user_pollen")
    private Integer user_pollen;
    @SerializedName("user_points")
    private Integer user_points;
    @SerializedName("user_name")
    private String user_name;
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;

    public UserInfo(Integer user_info_id,
                    String user_name_of_strength,
                    Integer user_id,
                    String user_created_at,
                    Integer user_current_mood,
                    String user_current_mood_updated,
                    Integer user_current_location_lat,
                    Integer user_current_location_long,
                    String user_current_location_updated,
                    Integer user_current_butterfly,
                    Integer user_pollen,
                    Integer user_points,
                    String username,
                    String user_name, String email,
                    String password) {
        this.user_info_id = user_info_id;
        this.user_name_of_strength = user_name_of_strength;
        this.user_id = user_id;
        this.user_created_at = user_created_at;
        this.user_current_mood = user_current_mood;
        this.user_current_mood_updated = user_current_mood_updated;
        this.user_current_location_lat = user_current_location_lat;
        this.user_current_location_long = user_current_location_long;
        this.user_current_location_updated = user_current_location_updated;
        this.user_current_butterfly = user_current_butterfly;
        this.user_pollen = user_pollen;
        this.user_points = user_points;
        this.user_name = user_name;
        this.email = email;
        this.password = password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Integer getUser_info_id() {
        return user_info_id;
    }

    public void setUser_info_id(Integer user_info_id) {
        this.user_info_id = user_info_id;
    }

    public String getUser_name_of_strength() {
        return user_name_of_strength;
    }

    public void setUser_name_of_strength(String user_name_of_strength) {
        this.user_name_of_strength = user_name_of_strength;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_created_at() {
        return user_created_at;
    }

    public void setUser_created_at(String user_created_at) {
        this.user_created_at = user_created_at;
    }

    public Integer getUser_current_mood() {
        return user_current_mood;
    }

    public void setUser_current_mood(Integer user_current_mood) {
        this.user_current_mood = user_current_mood;
    }

    public String getUser_current_mood_updated() {
        return user_current_mood_updated;
    }

    public void setUser_current_mood_updated(String user_current_mood_updated) {
        this.user_current_mood_updated = user_current_mood_updated;
    }

    public Integer getUser_current_location_lat() {
        return user_current_location_lat;
    }

    public void setUser_current_location_lat(Integer user_current_location_lat) {
        this.user_current_location_lat = user_current_location_lat;
    }

    public Integer getUser_current_location_long() {
        return user_current_location_long;
    }

    public void setUser_current_location_long(Integer user_current_location_long) {
        this.user_current_location_long = user_current_location_long;
    }

    public String getUser_current_location_updated() {
        return user_current_location_updated;
    }

    public void setUser_current_location_updated(String user_current_location_updated) {
        this.user_current_location_updated = user_current_location_updated;
    }

    public Integer getUser_current_butterfly() {
        return user_current_butterfly;
    }

    public void setUser_current_butterfly(Integer user_current_butterfly) {
        this.user_current_butterfly = user_current_butterfly;
    }

    public Integer getUser_pollen() {
        return user_pollen;
    }

    public void setUser_pollen(Integer user_pollen) {
        this.user_pollen = user_pollen;
    }

    public Integer getUser_points() {
        return user_points;
    }

    public void setUser_points(Integer user_points) {
        this.user_points = user_points;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
