package com.example.aorora.model;

import com.google.gson.annotations.SerializedName;

public class DailyTask {
    /*
        "daily_task_id": 3,
    "daily_task_day": "2019-07-03",
    "daily_task_likes_required": 3,
    "daily_task_likes_achieved": 0,
    "daily_task_butterflies_required": 3,
    "daily_task_butterflies_achieved": 0,
    "daily_task_m1_required": 1,
    "daily_task_m1_achieved": 0,
    "daily_task_m2_required": 1,
    "daily_task_m2_achieved": 0,
    "daily_task_m3_required": 1,
    "daily_task_m3_achieved": 0,
    "daily_task_user_id": 3
     */
    @SerializedName("daily_task_id")
    private Integer daily_task_id;
    @SerializedName("daily_task_day")
    private String daily_task_day;
    @SerializedName("daily_task_likes_required")
    private Integer daily_task_likes_required;
    @SerializedName("daily_task_likes_achieved")
    private Integer daily_task_likes_achieved;
    @SerializedName("daily_task_butterflies_required")
    private Integer daily_task_butterflies_required;
    @SerializedName("daily_task_butterflies_achieved")
    private Integer daily_task_butterflies_achieved;
    @SerializedName("daily_task_m1_required")
    private Integer daily_task_m1_required;
    @SerializedName("daily_task_m1_achieved")
    private Integer daily_task_m1_achieved;
    @SerializedName("daily_task_m2_required")
    private Integer daily_task_m2_required;
    @SerializedName("daily_task_m2_achieved")
    private Integer daily_task_m2_achieved;
    @SerializedName("daily_task_m3_required")
    private Integer daily_task_m3_required;
    @SerializedName("daily_task_m3_achieved")
    private Integer daily_task_m3_achieved;
    @SerializedName("daily_task_user_id")
    private Integer daily_task_user_id;


    public DailyTask(Integer daily_task_id,
                     String daily_task_day,
                     Integer daily_task_likes_required,
                     Integer daily_task_likes_achieved,
                     Integer daily_task_butterflies_required,
                     Integer daily_task_butterflies_achieved,
                     Integer daily_task_m1_required,
                     Integer daily_task_m1_achieved,
                     Integer daily_task_m2_required,
                     Integer daily_task_m2_achieved,
                     Integer daily_task_m3_required,
                     Integer daily_task_m3_achieved,
                     Integer daily_task_user_id) {
        this.daily_task_id = daily_task_id;
        this.daily_task_day = daily_task_day;
        this.daily_task_likes_required = daily_task_likes_required;
        this.daily_task_likes_achieved = daily_task_likes_achieved;
        this.daily_task_butterflies_required = daily_task_butterflies_required;
        this.daily_task_butterflies_achieved = daily_task_butterflies_achieved;
        this.daily_task_m1_required = daily_task_m1_required;
        this.daily_task_m1_achieved = daily_task_m1_achieved;
        this.daily_task_m2_required = daily_task_m2_required;
        this.daily_task_m2_achieved = daily_task_m2_achieved;
        this.daily_task_m3_required = daily_task_m3_required;
        this.daily_task_m3_achieved = daily_task_m3_achieved;
        this.daily_task_user_id = daily_task_user_id;
    }

    public Integer getDaily_task_id() {
        return daily_task_id;
    }

    public void setDaily_task_id(Integer daily_task_id) {
        this.daily_task_id = daily_task_id;
    }

    public String getDaily_task_day() {
        return daily_task_day;
    }

    public void setDaily_task_day(String daily_task_day) {
        this.daily_task_day = daily_task_day;
    }

    public Integer getDaily_task_likes_required() {
        return daily_task_likes_required;
    }

    public void setDaily_task_likes_required(Integer daily_task_likes_required) {
        this.daily_task_likes_required = daily_task_likes_required;
    }

    public Integer getDaily_task_likes_achieved() {
        return daily_task_likes_achieved;
    }

    public void setDaily_task_likes_achieved(Integer daily_task_likes_achieved) {
        this.daily_task_likes_achieved = daily_task_likes_achieved;
    }

    public Integer getDaily_task_butterflies_required() {
        return daily_task_butterflies_required;
    }

    public void setDaily_task_butterflies_required(Integer daily_task_butterflies_required) {
        this.daily_task_butterflies_required = daily_task_butterflies_required;
    }

    public Integer getDaily_task_butterflies_achieved() {
        return daily_task_butterflies_achieved;
    }

    public void setDaily_task_butterflies_achieved(Integer daily_task_butterflies_achieved) {
        this.daily_task_butterflies_achieved = daily_task_butterflies_achieved;
    }

    public Integer getDaily_task_m1_required() {
        return daily_task_m1_required;
    }

    public void setDaily_task_m1_required(Integer daily_task_m1_required) {
        this.daily_task_m1_required = daily_task_m1_required;
    }

    public Integer getDaily_task_m1_achieved() {
        return daily_task_m1_achieved;
    }

    public void setDaily_task_m1_achieved(Integer daily_task_m1_achieved) {
        this.daily_task_m1_achieved = daily_task_m1_achieved;
    }

    public Integer getDaily_task_m2_required() {
        return daily_task_m2_required;
    }

    public void setDaily_task_m2_required(Integer daily_task_m2_required) {
        this.daily_task_m2_required = daily_task_m2_required;
    }

    public Integer getDaily_task_m2_achieved() {
        return daily_task_m2_achieved;
    }

    public void setDaily_task_m2_achieved(Integer daily_task_m2_achieved) {
        this.daily_task_m2_achieved = daily_task_m2_achieved;
    }

    public Integer getDaily_task_m3_required() {
        return daily_task_m3_required;
    }

    public void setDaily_task_m3_required(Integer daily_task_m3_required) {
        this.daily_task_m3_required = daily_task_m3_required;
    }

    public Integer getDaily_task_m3_achieved() {
        return daily_task_m3_achieved;
    }

    public void setDaily_task_m3_achieved(Integer daily_task_m3_achieved) {
        this.daily_task_m3_achieved = daily_task_m3_achieved;
    }

    public Integer getDaily_task_user_id() {
        return daily_task_user_id;
    }

    public void setDaily_task_user_id(Integer daily_task_user_id) {
        this.daily_task_user_id = daily_task_user_id;
    }
}
