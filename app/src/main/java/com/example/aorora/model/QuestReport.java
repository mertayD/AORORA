package com.example.aorora.model;

import com.google.gson.annotations.SerializedName;

public class QuestReport {
    @SerializedName("quest_report_id")
    private Integer quest_report_id;

    @SerializedName("quest_type_id")
    private Integer quest_type_id;

    @SerializedName("user_id")
    private Integer user_id;

    @SerializedName("quest_status_id")
    private Integer quest_status_id;

    @SerializedName("quest_started_at")
    private String quest_started_at;

    @SerializedName("quest_ended_at")
    private String quest_ended_at;

    public QuestReport(Integer quest_report_id, Integer quest_type_id, Integer user_id, Integer quest_status_id, String quest_started_at, String quest_ended_at) {
        this.quest_report_id = quest_report_id;
        this.quest_type_id = quest_type_id;
        this.user_id = user_id;
        this.quest_status_id = quest_status_id;
        this.quest_started_at = quest_started_at;
        this.quest_ended_at = quest_ended_at;
    }

    public Integer getQuest_type_id() {
        return quest_type_id;
    }

    public void setQuest_type_id(Integer quest_type_id) {
        this.quest_type_id = quest_type_id;
    }

    public Integer getQuest_status_id() {
        return quest_status_id;
    }

    public void setQuest_status_id(Integer quest_status_id) {
        this.quest_status_id = quest_status_id;
    }

    public Integer getQuest_report_id() {
        return quest_report_id;
    }

    public void setQuest_report_id(Integer quest_report_id) {
        this.quest_report_id = quest_report_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getQuest_started_at() {
        return quest_started_at;
    }

    public void setQuest_started_at(String quest_started_at) {
        this.quest_started_at = quest_started_at;
    }

    public String getQuest_ended_at() {
        return quest_ended_at;
    }

    public void setQuest_ended_at(String quest_ended_at) {
        this.quest_ended_at = quest_ended_at;
    }
}
