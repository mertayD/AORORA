package com.example.aorora.model;

import com.google.gson.annotations.SerializedName;

public class ButterflyComment {
    /*
    |–> butterfly_comment_id (integer)
|–> butterfly_id* (integer)
|–> user_id* (integer)
|–> comment_created_at (datetime)
|–> comment_text* (string)
     */

    @SerializedName("butterfly_comment_id")
    private Integer butterfly_comment_id;
    @SerializedName("butterfly_id")
    private Integer butterfly_id;
    @SerializedName("user_id")
    private Integer user_id;
    @SerializedName("comment_created_at")
    private String comment_created_at;
    @SerializedName("comment_text")
    private String comment_text;

    public ButterflyComment(Integer butterfly_comment_id, Integer butterfly_id, Integer user_id, String comment_created_at, String comment_text) {
        this.butterfly_comment_id = butterfly_comment_id;
        this.butterfly_id = butterfly_id;
        this.user_id = user_id;
        this.comment_created_at = comment_created_at;
        this.comment_text = comment_text;
    }

    public Integer getButterfly_comment_id() {
        return butterfly_comment_id;
    }

    public void setButterfly_comment_id(Integer butterfly_comment_id) {
        this.butterfly_comment_id = butterfly_comment_id;
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

    public String getComment_created_at() {
        return comment_created_at;
    }

    public void setComment_created_at(String comment_created_at) {
        this.comment_created_at = comment_created_at;
    }

    public String getComment_text() {
        return comment_text;
    }

    public void setComment_text(String comment_text) {
        this.comment_text = comment_text;
    }
}
