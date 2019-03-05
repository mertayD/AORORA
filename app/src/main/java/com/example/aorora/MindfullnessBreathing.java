package com.example.aorora;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.aorora.ClickListener.SpinnerActivity;

import java.time.chrono.MinguoDate;

public class MindfullnessBreathing extends AppCompatActivity implements View.OnClickListener {

    Spinner time_selection_spinner;
    ImageButton play_button;
    String timerCount;
    Context mindfullnessBreathing;
    ImageButton home_button_bottombar;
    ImageButton profile_button_bottombar;
    ImageButton community_button_bottombar;
    ImageButton quest_button_bottombar;
    ImageView alpha_channel_iv;
    Animation infinite_blink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mindfullness_breathing);
        mindfullnessBreathing = this;

        home_button_bottombar = (ImageButton) findViewById(R.id.home_button_bottom_bar);
        profile_button_bottombar = (ImageButton) findViewById(R.id.profile_button_bottom_bar);
        community_button_bottombar = (ImageButton) findViewById(R.id.community_button_bottom_bar);
        quest_button_bottombar = (ImageButton) findViewById(R.id.quest_button_bottom_bar);
        play_button = (ImageButton) findViewById(R.id.play_button_breathing);
        alpha_channel_iv = (ImageView) findViewById(R.id.alpha_channel_breathing_icon);

        home_button_bottombar.setOnClickListener(this);
        profile_button_bottombar.setOnClickListener(this);
        community_button_bottombar.setOnClickListener(this);
        quest_button_bottombar.setOnClickListener(this);
        play_button.setOnClickListener(this);

        infinite_blink = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.infinite_blink);
        alpha_channel_iv.startAnimation(infinite_blink);
        time_selection_spinner = findViewById(R.id.spinner_breathing_time_selection);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.breathing_menu_selection, R.layout.simple_spinner_tv);
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown);
        time_selection_spinner.setAdapter(adapter);
        time_selection_spinner.setOnItemSelectedListener(new SpinnerActivity());


    }

    @Override
    public void onClick(View v) {
        int view_id = v.getId();
        Intent to_navigate;
        if(view_id == profile_button_bottombar.getId())
        {
            to_navigate = new Intent(mindfullnessBreathing, ProfilePage.class );
            startActivity(to_navigate);
        }
        else if(view_id == quest_button_bottombar.getId())
        {
            to_navigate = new Intent(mindfullnessBreathing, MindfullnessSelection.class);
        }
        else if(view_id == home_button_bottombar.getId())
        {
            to_navigate = new Intent(mindfullnessBreathing, HomeScreen.class);
            startActivity(to_navigate);
        }
        else if(view_id == community_button_bottombar.getId())
        {
            to_navigate = new Intent(mindfullnessBreathing, CommunityPage.class);
            startActivity(to_navigate);
        }
        else if(view_id == play_button.getId())
        {
            timerCount = String.valueOf(time_selection_spinner.getSelectedItem());
            to_navigate = new Intent(mindfullnessBreathing, MindfullnessBreathingGame.class);
            to_navigate.putExtra("TimerValue", timerCount);
            startActivity(to_navigate);
        }
    }
}
