package com.example.aorora.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NotificationCreateReturn {

    @SerializedName("notificaiton_id")
    @Expose
    private Integer notification_id;

    public NotificationCreateReturn(Integer notification_id)
    {
        this.notification_id = notification_id;
    }

    public Integer getNotification_id() {
        return notification_id;
    }

    public void setNotification_id(Integer notification_id)
    {
        this.notification_id = notification_id;
    }


}
