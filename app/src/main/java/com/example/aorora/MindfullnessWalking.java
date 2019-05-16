package com.example.aorora;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MindfullnessWalking extends AppCompatActivity implements View.OnClickListener {

    Animation infinite_blink;
    ImageButton left_most_button;
    ImageButton left_button;
    ImageButton right_button;
    ImageButton right_most_button;
    ImageButton center;
    ImageButton play;
    ImageButton home_button_bottombar;
    ImageButton profile_button_bottombar;
    ImageButton community_button_bottombar;
    ImageButton quest_button_bottombar;
    Context mindfullnessWalking;
    ImageButton exit_button;
    ImageView alphaChannelImage;
    //1 is pink
    int lm_color = 1;
    //2 is blue
    int l_color = 2;
    //3 is green
    int c_color = 3;
    //4 is orange
    int r_color = 4;
    //5 is grey
    int rm_color = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mindfullness_walking);

        mindfullnessWalking = this;

        left_most_button= findViewById(R.id.left_most_circle_buttom);
        left_button = findViewById(R.id.left_circle_button);
        center = findViewById(R.id.elipse_center_button);
        right_button = findViewById(R.id.right_circle_button);
        right_most_button = findViewById(R.id.right_most_circle_button);
        play = (ImageButton) findViewById(R.id.play_button_walking);
        exit_button = (ImageButton) findViewById(R.id.exit_button_walking);
        alphaChannelImage = (ImageView) findViewById(R.id.alpha_channel_walking_icon);

        home_button_bottombar = (ImageButton) findViewById(R.id.home_button_bottom_bar);
        profile_button_bottombar = (ImageButton) findViewById(R.id.profile_button_bottom_bar);
        community_button_bottombar = (ImageButton) findViewById(R.id.community_button_bottom_bar);
        quest_button_bottombar = (ImageButton) findViewById(R.id.quest_button_bottom_bar);

        home_button_bottombar.setOnClickListener(this);
        profile_button_bottombar.setOnClickListener(this);
        community_button_bottombar.setOnClickListener(this);
        quest_button_bottombar.setOnClickListener(this);

        exit_button.setOnClickListener(this);
        play.setOnClickListener(this);
        left_most_button.setOnClickListener(this);
        left_button.setOnClickListener(this);
        center.setOnClickListener(this);
        right_button.setOnClickListener(this);
        right_most_button.setOnClickListener(this);

        infinite_blink = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.infinite_blink);
        alphaChannelImage.startAnimation(infinite_blink);
    }

    @Override
    public void onClick(View v) {
        int view_id = v.getId();
        int temp;
        Intent to_navigate;
        if(view_id == profile_button_bottombar.getId())
        {
            to_navigate = new Intent(mindfullnessWalking, ProfilePage.class );
            startActivity(to_navigate);
        }
        else if(view_id == quest_button_bottombar.getId())
        {
            to_navigate = new Intent(mindfullnessWalking, MindfullnessSelection.class);
        }
        else if(view_id == home_button_bottombar.getId())
        {
            to_navigate = new Intent(mindfullnessWalking, HomeScreen.class);
            startActivity(to_navigate);
        }
        else if(view_id == community_button_bottombar.getId())
        {
            to_navigate = new Intent(mindfullnessWalking, CommunityPage.class);
            startActivity(to_navigate);
        }
        else if(view_id == exit_button.getId())
        {
            to_navigate = new Intent(mindfullnessWalking, MindfullnessSelection.class);
            startActivity(to_navigate);
        }
        else if (view_id == left_most_button.getId())
        {
            temp = lm_color;
            lm_color = c_color;
            c_color = temp;
            recolor(center,c_color,true);
            recolor(left_most_button,lm_color,false);
        }
        else if(view_id == left_button.getId())
        {
            temp = l_color;
            l_color = c_color;
            c_color = temp;
            recolor(center,c_color,true);
            recolor(left_button,l_color,false);
        }
        else if(view_id ==right_button.getId())
        {
            temp = r_color;
            r_color = c_color;
            c_color = temp;
            recolor(center,c_color,true);
            recolor(right_button,r_color,false);
        }
        else if(view_id == right_most_button.getId())
        {
            temp = rm_color;
            rm_color = c_color;
            c_color = temp;
            recolor(center,c_color,true);
            recolor(right_most_button,rm_color,false);
        }
        else if(view_id == play.getId())
        {
            Intent intent = new Intent(MindfullnessWalking.this, MindfullnessWalkingGame.class);
            //intent.putExtra("NavigatedFrom", -3);
            startActivity(intent);
        }
    }

    public void recolor(ImageButton v, int color, boolean center)
    {
        switch (color){
            case 1:
                if(center)
                {
                    v.setImageResource(R.drawable.pink_elipse_walking);
                }
                else
                {
                    v.setImageResource(R.drawable.pink_circle_walking);
                }
                break;
            case 2:
                if(center)
                {
                    v.setImageResource(R.drawable.blue_elipse_walking);
                }
                else
                {
                    v.setImageResource(R.drawable.blue_circle_walking);
                }
                break;
            case 3:
                if(center)
                {
                    v.setImageResource(R.drawable.green_elipse_walking);
                }
                else
                {
                    v.setImageResource(R.drawable.green_circle_walking);
                }
                break;
            case 4:
                if(center)
                {
                    v.setImageResource(R.drawable.orange_elipse_walking);
                }
                else
                {
                    v.setImageResource(R.drawable.orange_circle_walking);
                }
                break;
            case 5:
                if(center)
                {
                    v.setImageResource(R.drawable.grey_circle_walking);
                }
                else
                {
                    v.setImageResource(R.drawable.grey_circle_walking);
                }
                break;
        }
    }
}
