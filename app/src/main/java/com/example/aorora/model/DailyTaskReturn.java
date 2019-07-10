package com.example.aorora.model;

import com.google.gson.annotations.SerializedName;

public class DailyTaskReturn {

    @SerializedName("daily_task_id")
    private Integer daily_task_id;

    public DailyTaskReturn(Integer daily_task_id) {
        this.daily_task_id = daily_task_id;
    }

    public Integer getDaily_task_id() {
        return daily_task_id;
    }

    public void setDaily_task_id(Integer daily_task_id) {
        this.daily_task_id = daily_task_id;
    }
}
