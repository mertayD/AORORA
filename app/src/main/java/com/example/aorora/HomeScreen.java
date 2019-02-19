package com.example.aorora;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class HomeScreen extends AppCompatActivity implements GestureDetector.OnGestureListener, View.OnClickListener {
    Context homeScreen;
    GestureDetector gestureDetector;
    ImageButton home_button_bottombar;
    ImageButton profile_button_bottombar;
    ImageButton community_button_bottombar;
    ImageButton quest_button_bottombar;
    ImageButton ar_game_button;
    ImageButton quest_button;
    ImageButton pop_up_twobuttons_button;
    Boolean isButtonsPoppedUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        homeScreen = this;
        isButtonsPoppedUp = false;
        home_button_bottombar = (ImageButton) findViewById(R.id.home_button_bottom_bar);
        profile_button_bottombar = (ImageButton) findViewById(R.id.profile_button_bottom_bar);
        community_button_bottombar = (ImageButton) findViewById(R.id.community_button_bottom_bar);
        quest_button_bottombar = (ImageButton) findViewById(R.id.quest_button_bottom_bar);
        ar_game_button = (ImageButton) findViewById(R.id.ar_game_button);
        quest_button = (ImageButton) findViewById(R.id.quest_button);
        pop_up_twobuttons_button = findViewById(R.id.pop_up_buttons_button);
        gestureDetector = new GestureDetector(homeScreen, HomeScreen.this);

        home_button_bottombar.setOnClickListener(this);
        profile_button_bottombar.setOnClickListener(this);
        community_button_bottombar.setOnClickListener(this);
        quest_button_bottombar.setOnClickListener(this);

        pop_up_twobuttons_button.setOnClickListener(new ImageButton.OnClickListener() {
            public void onClick(View v) {
                if(!isButtonsPoppedUp) {
                    pop_up_twobuttons_button.setImageDrawable(getResources().getDrawable(R.drawable.menu_button_unfilled));
                    quest_button.setVisibility(View.VISIBLE);
                    ar_game_button.setVisibility(View.VISIBLE);
                    isButtonsPoppedUp = true;
                }
                else{
                    pop_up_twobuttons_button.setImageDrawable(getResources().getDrawable(R.drawable.menu_button_filled));
                    quest_button.setVisibility(View.INVISIBLE);
                    ar_game_button.setVisibility(View.INVISIBLE);
                    isButtonsPoppedUp = false;
                }
            }
        });

    }
    @Override
    public boolean onFling (MotionEvent motionEvent1, MotionEvent motionEvent2, float X, float Y)
    {
        if (motionEvent1.getX() - motionEvent2.getX() > 50) {
            Intent profilePage = new Intent(homeScreen, ProfilePage.class);
            startActivity(profilePage);
            return true;
        }
        if (motionEvent2.getX() - motionEvent1.getX() > 50) {
            Intent mindfullness = new Intent(homeScreen, CommunityPage.class);
            startActivity(mindfullness);
            return true;
        } else {
            return true;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return gestureDetector.onTouchEvent(motionEvent);
    }

    // We don't need to implement those unless otherwise told. They just need to be there
    // because we are implementing the GestureDetector class
    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public void onClick(View v) {
        int view_id = v.getId();
        Intent to_navigate;
        if(view_id == profile_button_bottombar.getId())
        {
            to_navigate = new Intent(homeScreen, ProfilePage.class);
            startActivity(to_navigate);
        }
        else if(view_id == community_button_bottombar.getId())
        {
            to_navigate = new Intent(homeScreen, CommunityPage.class);
            startActivity(to_navigate);
        }
        else if(view_id == quest_button_bottombar.getId())
        {
            Toast.makeText(homeScreen, "Quest Page", Toast.LENGTH_LONG).show();
            //to_navigate = new Intent(homeScreen, );
        }
        else if(view_id == home_button_bottombar.getId())
        {
            //to_navigate = new Intent(homeScreen, homeScreen);
        }

    }
}
