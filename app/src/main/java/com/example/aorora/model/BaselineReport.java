package com.example.aorora.model;

import com.google.gson.annotations.SerializedName;

public class BaselineReport {


    @SerializedName("baseline_report_id")
    private Integer baseline_report_id;
    @SerializedName("user_id")
    private Integer user_id;
    @SerializedName("baseline_report_created_at")
    private String baseline_report_created_at;
    @SerializedName("baseline_report_results")
    private String baseline_report_results;

    public BaselineReport(Integer baseline_report_id, Integer user_id, String baseline_report_created_at, String baseline_report_results) {
        this.baseline_report_id = baseline_report_id;
        this.user_id = user_id;
        this.baseline_report_created_at = baseline_report_created_at;
        this.baseline_report_results = baseline_report_results;
    }

    public String getBaseline_report_results() {
        return baseline_report_results;
    }

    public void setBaseline_report_results(String baseline_report_results) {
        this.baseline_report_results = baseline_report_results;
    }

    public String getBaseline_report_created_at() {
        return baseline_report_created_at;
    }

    public void setBaseline_report_created_at(String baseline_report_created_at) {
        this.baseline_report_created_at = baseline_report_created_at;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getBaseline_report_id() {
        return baseline_report_id;
    }

    public void setBaseline_report_id(Integer baseline_report_id) {
        this.baseline_report_id = baseline_report_id;
    }

}
