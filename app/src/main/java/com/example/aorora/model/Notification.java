package com.example.aorora.model;

import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Expose;

public class Notification
{

    @SerializedName("user_notification_id")
    private Integer user_notification_id;
    @SerializedName("user_notification_type_id")
    private Integer user_notification_type_id;
    @SerializedName("notification_user_id")
    private Integer notification_user_id;
    @SerializedName("user_interaction_created_at")
    private String user_interaction_created_at;

    public Notification(Integer user_interaction_id, Integer user_interaction_type_id,
                           Integer initiator_user_id, Integer receiver_user_id, Integer quest_record_id,
                           String user_interaction_content, String user_interaction_created_at)
    {
        this.user_notification_id = user_interaction_id;
        this.user_notification_type_id = user_interaction_type_id;
        this.notification_user_id = initiator_user_id;
        this.user_interaction_created_at = user_interaction_created_at;
    }

    public Integer getNotification_id() {return user_notification_id;}
    public Integer getNotification_type_id() {return user_notification_type_id;}
    public Integer getNotification_user_id() {return notification_user_id;}
    public String getNotification_created_at() {return user_interaction_created_at;}

    public void setNotification_id(Integer user_interaction_id)
    {
        this.user_notification_id = user_interaction_id;
    }

    public void setNotification_type_id(Integer user_interaction_type_id)
    {
        this.user_notification_type_id = user_interaction_type_id;
    }

    public void setNotification_user_id(Integer initiator_user_id)
    {
        this.notification_user_id = initiator_user_id;
    }

    public void setNotification_created_at(String user_interaction_created_at)
    {
        this.user_interaction_created_at = user_interaction_created_at;
    }

}
