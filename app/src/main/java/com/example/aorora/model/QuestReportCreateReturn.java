package com.example.aorora.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuestReportCreateReturn {
    @SerializedName("quest_report_id")
    @Expose
    private Integer quest_report_id;

    public QuestReportCreateReturn(Integer quest_report_id) {
        this.quest_report_id = quest_report_id;
    }

    public Integer getQuest_report_id() {
        return quest_report_id;
    }

    public void setQuest_report_id(Integer quest_report_id) {
        this.quest_report_id = quest_report_id;
    }
}
