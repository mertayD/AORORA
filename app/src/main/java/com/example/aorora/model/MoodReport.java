package com.example.aorora.model;

import com.google.gson.annotations.SerializedName;

public class MoodReport {

    /*
    |–> mood_report_id (integer)
|–> mood_report_created_at
|–> user_id* (integer)
|–> mood_type* (integer)
|–> user_text* (string)
    */

    @SerializedName("mood_report_id")
    private Integer mood_report_id;
    @SerializedName("mood_type")
    private Integer mood_type;
    @SerializedName("user_id")
    private Integer user_id;
    @SerializedName("user_text")
    private String user_text;
    @SerializedName("mood_report_created_at")
    private String mood_report_created_at;

    public MoodReport(Integer mood_report_id, Integer mood_type, Integer user_id, String user_text, String mood_report_created_at) {
        this.mood_report_id = mood_report_id;
        this.mood_type = mood_type;
        this.user_id = user_id;
        this.user_text = user_text;
        this.mood_report_created_at = mood_report_created_at;
    }

    public Integer getMood_report_id() {
        return mood_report_id;
    }

    public void setMood_report_id(Integer mood_report_id) {
        this.mood_report_id = mood_report_id;
    }

    public Integer getMood_type() {
        return mood_type;
    }

    public void setMood_type(Integer mood_type) {
        this.mood_type = mood_type;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_text() {
        return user_text;
    }

    public void setUser_text(String user_text) {
        this.user_text = user_text;
    }

    public String getMood_report_created_at() {
        return mood_report_created_at;
    }

    public void setMood_report_created_at(String mood_report_created_at) {
        this.mood_report_created_at = mood_report_created_at;
    }
}
