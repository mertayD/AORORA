package com.example.aorora.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MoodReportIdReturn {

    @SerializedName("mood_report_id")
    @Expose
    private Integer mood_report_id;

    public MoodReportIdReturn(Integer mood_report_id) {
        this.mood_report_id = mood_report_id;
    }

    public Integer getMood_report_id() {
        return mood_report_id;
    }

    public void setMood_report_id(Integer mood_report_id) {
        this.mood_report_id = mood_report_id;
    }
}
