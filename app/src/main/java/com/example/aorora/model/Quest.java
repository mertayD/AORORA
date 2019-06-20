package com.example.aorora.model;

import com.google.gson.annotations.SerializedName;

public class Quest {

    @SerializedName("quest_type_id")
    private Integer quest_type_id;
    @SerializedName("quest_id")
    private Integer quest_id;
    @SerializedName("quest_status_id")
    private Integer quest_status_id;

    public Quest(Integer quest_type_id, Integer quest_id, Integer quest_status_id) {
        this.quest_type_id = quest_type_id;
        this.quest_id = quest_id;
        this.quest_status_id = quest_status_id;
    }
    public Integer getQuest_type_id() {
        return quest_type_id;
    }

    public void setQuest_type_id(Integer quest_type_id) {
        this.quest_type_id = quest_type_id;
    }

    public Integer getQuest_id() {
        return quest_id;
    }

    public void setQuest_id(Integer quest_id) {
        this.quest_id = quest_id;
    }

    public Integer getQuest_status_id() {
        return quest_status_id;
    }

    public void setQuest_status_id(Integer quest_status_id) {
        this.quest_status_id = quest_status_id;
    }
}
