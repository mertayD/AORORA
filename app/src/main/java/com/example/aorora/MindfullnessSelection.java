package com.example.aorora;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MindfullnessSelection extends AppCompatActivity implements View.OnClickListener {
    Context mindfullnessSelection;
    ImageButton home_button_bottombar;
    ImageButton profile_button_bottombar;
    ImageButton community_button_bottombar;
    ImageButton quest_button_bottombar;
    ImageButton mindfullness_breathing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mindfullness_selection);
        mindfullnessSelection = this;

        home_button_bottombar = (ImageButton) findViewById(R.id.home_button_bottom_bar);
        profile_button_bottombar = (ImageButton) findViewById(R.id.profile_button_bottom_bar);
        community_button_bottombar = (ImageButton) findViewById(R.id.community_button_bottom_bar);
        quest_button_bottombar = (ImageButton) findViewById(R.id.quest_button_bottom_bar);
        mindfullness_breathing = (ImageButton) findViewById(R.id.mindfulness_breathing_app);

        home_button_bottombar.setOnClickListener(this);
        profile_button_bottombar.setOnClickListener(this);
        community_button_bottombar.setOnClickListener(this);
        quest_button_bottombar.setOnClickListener(this);
        mindfullness_breathing.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        int view_id = v.getId();
        Intent to_navigate;
        if(view_id == profile_button_bottombar.getId())
        {
            to_navigate = new Intent(mindfullnessSelection, ProfilePage.class );
            startActivity(to_navigate);
        }
        else if(view_id == home_button_bottombar.getId())
        {
            to_navigate = new Intent(mindfullnessSelection, HomeScreen.class);
            startActivity(to_navigate);
        }
        else if(view_id == community_button_bottombar.getId())
        {
            to_navigate = new Intent(mindfullnessSelection, CommunityPage.class);
            startActivity(to_navigate);
        }
        else if(view_id == mindfullness_breathing.getId())
        {
            to_navigate = new Intent(mindfullnessSelection, MindfullnessBreathing.class);
            startActivity(to_navigate);
        }
    }
}
