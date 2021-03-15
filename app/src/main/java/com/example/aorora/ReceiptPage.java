package com.example.aorora;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class ReceiptPage extends AppCompatActivity implements View.OnClickListener{

    ImageView pollen_view_text_view_holder;
    ImageButton continue_button;
    ImageButton replay_button;
    ImageButton home_button;
    LottieAnimationView jar_button;
    TextView tap_me_text;
    TextView go_to_pollen_tore_text;
    TextView pollen_score_tv;
    TextView receipt_desc_tv;
    TextView receipt_desc_tv_2;
    TextView receipt_score_tv;
    TextView receipt_score_tv_2;

    int game_settings;
    int coming_from;
    int game_theme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt_page);

        pollen_view_text_view_holder = findViewById(R.id.receipt_page_pollen_point_holder);
        continue_button = findViewById(R.id.receipt_page_exit_activity_button);
        replay_button = findViewById(R.id.play_again_button_receipt_page);
        home_button = findViewById(R.id.receipt_page_home_button);
        pollen_score_tv = findViewById(R.id.receipt_page_pollen_points_tv);
        jar_button = findViewById(R.id.receipt_page_jar_button);
        go_to_pollen_tore_text = findViewById(R.id.tap_to_access_shop_tv);
        tap_me_text = findViewById(R.id.tap_to_collect_receipt_tv);
        receipt_desc_tv = findViewById(R.id.receipt_desc_text_view);
        receipt_desc_tv_2 = findViewById(R.id.receipt_desc_text_view_2);
        receipt_score_tv = findViewById(R.id.receipt_desc_score_text_view);
        receipt_score_tv_2 =  findViewById(R.id.receipt_desc_score_text_view_1);

        continue_button.setOnClickListener(this);
        replay_button.setOnClickListener(this);
        home_button.setOnClickListener(this);
        jar_button.setOnClickListener(this);
        Intent current_intent = this.getIntent();
        if(current_intent.hasExtra("NavigatedFrom"))
        {
            coming_from = current_intent.getIntExtra("NavigatedFrom", 1);
            Log.e("NAVIGATED FROM", "" + coming_from);
            if(coming_from == 1)
            {
                if(current_intent.hasExtra("GAME"))
                {
                    game_settings = current_intent.getIntExtra("GAME", 1);
                }
            }
            else if(coming_from == 2)
            {
                if(current_intent.hasExtra("Game Theme"))
                {
                    game_theme = current_intent.getIntExtra("Game Theme",1);
                }
            }
            else
            {
                if(current_intent.hasExtra("Game Theme"))
                {
                    game_theme = current_intent.getIntExtra("Game Theme",1);
                }
            }
        }

    }

    @Override
    public void onClick(View v) {
        int view_id = v.getId();
        Intent to_navigate;
        if(view_id == continue_button.getId())
        {
            to_navigate = new Intent(ReceiptPage.this, MindfullnessBreathing.class);
            startActivity(to_navigate);
        }
        else if(view_id == replay_button.getId())
        {
            switch (coming_from){
                case 1:
                    to_navigate = new Intent(ReceiptPage.this, MindfullnessBreathingGame.class);
                    to_navigate.putExtra("TimerValue", game_settings);
                    startActivity(to_navigate);
                    break;
                case 2:
                    to_navigate = new Intent(ReceiptPage.this, MindfulnessMeditationGame_R.class);
                    to_navigate.putExtra("Theme",game_theme);
                    startActivity(to_navigate);
                    break;
                case 3:
                    to_navigate = new Intent(ReceiptPage.this, MindfullnessWalkingGame.class);
                    to_navigate.putExtra("Game Theme", game_theme);
                    startActivity(to_navigate);
                    break;
            }
        }
        else if(view_id == home_button.getId())
        {
            to_navigate = new Intent(ReceiptPage.this, HomeScreen.class);
            startActivity(to_navigate);
        }
        else if(view_id == jar_button.getId())
        {
            jar_button.setClickable(false);
            jar_button.setAnimation(R.raw.jar_pop);
            jar_button.loop(false);
            jar_button.playAnimation();
            new CountDownTimer(3000, 100){

                @Override
                public void onTick(long millisUntilFinished) {

                }

                @Override
                public void onFinish() {
                    receipt_score_tv.setVisibility(View.INVISIBLE);
                    receipt_score_tv_2.setVisibility(View.INVISIBLE);
                    receipt_desc_tv.setVisibility(View.INVISIBLE);
                    receipt_desc_tv_2.setVisibility(View.INVISIBLE);

                    go_to_pollen_tore_text.setVisibility(View.VISIBLE);
                    tap_me_text.setVisibility(View.INVISIBLE);
                    pollen_score_tv.setVisibility(View.VISIBLE);
                    continue_button.setVisibility(View.VISIBLE);
                    replay_button.setVisibility(View.VISIBLE);
                    home_button.setVisibility(View.VISIBLE);
                    jar_button.pauseAnimation();
                    pollen_view_text_view_holder.setVisibility(View.VISIBLE);
                }
            }.start();
        }
    }
}
