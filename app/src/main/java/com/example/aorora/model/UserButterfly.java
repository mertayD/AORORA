package com.example.aorora.model;

import com.google.gson.annotations.SerializedName;

public class UserButterfly {
    /*
|–> user_butterfly_id (integer)
|–> butterfly_id* (integer)
|–> time_caught (datetime) (Record the date time when it is created)
|–> user_id* (integer)
     */

    @SerializedName("user_butterfly_id")
    private Integer user_butterfly_id;
    @SerializedName("butterfly_id")
    private Integer butterfly_id;
    @SerializedName("user_id")
    private Integer user_id;
    @SerializedName("time_caught")
    private String time_caught;


    public UserButterfly(Integer user_butterfly_id, Integer butterfly_id, Integer user_id, String time_caught) {
        this.user_butterfly_id = user_butterfly_id;
        this.butterfly_id = butterfly_id;
        this.user_id = user_id;
        this.time_caught = time_caught;
    }

    public Integer getUser_butterfly_id() {
        return user_butterfly_id;
    }

    public void setUser_butterfly_id(Integer user_butterfly_id) {
        this.user_butterfly_id = user_butterfly_id;
    }

    public Integer getButterfly_id() {
        return butterfly_id;
    }

    public void setButterfly_id(Integer butterfly_id) {
        this.butterfly_id = butterfly_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getTime_caught() {
        return time_caught;
    }

    public void setTime_caught(String time_caught) {
        this.time_caught = time_caught;
    }
}
