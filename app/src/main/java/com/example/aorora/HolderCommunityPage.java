package com.example.aorora;

import java.util.ArrayList;
import java.util.List;

public class HolderCommunityPage {

    public List<String> username;
    public List<Integer> user_butterfly_id;
    public List<Integer> quest_type;


    public HolderCommunityPage() {
        this.username = new ArrayList<>();
        this.user_butterfly_id = new ArrayList<>();
        this.quest_type = new ArrayList<>();
    }

    public List<String> getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username.add(username);
    }

    public List<Integer> getUser_butterfly_id() {
        return user_butterfly_id;
    }

    public void setUser_butterfly_id(int user_butterfly_id) {
        this.user_butterfly_id.add(user_butterfly_id);
    }

    public List<Integer> getQuest_type() {
        return quest_type;
    }

    public void setQuest_type(int quest_type) {
        this.quest_type.add(quest_type);
    }

}
