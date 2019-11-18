package com.example.aorora;

import java.util.ArrayList;
import java.util.List;

public class HolderCommunityPage {

    public List<String> username;
    public List<Integer> user_butterfly_id;
    public List<Integer> interaction_type;


    public HolderCommunityPage() {
        this.username = new ArrayList<>();
        this.user_butterfly_id = new ArrayList<>();
        this.interaction_type = new ArrayList<>();
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

    public List<Integer> getInteraction_type() {
        return interaction_type;
    }

    public void setInteraction_type(int quest_type) {
        this.interaction_type.add(quest_type);
    }

}
