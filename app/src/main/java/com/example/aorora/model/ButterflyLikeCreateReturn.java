package com.example.aorora.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ButterflyLikeCreateReturn
{
        @SerializedName("quest_report_id")
        @Expose
        private Integer quest_report_id;

        public ButterflyLikeCreateReturn(Integer quest_report_id) {
            this.quest_report_id = quest_report_id;
        }

        public Integer getButterfly_like_id() {
            return quest_report_id;
        }

        public void setButterfly_like_id(Integer quest_report_id) {
            this.quest_report_id = quest_report_id;
        }


}
