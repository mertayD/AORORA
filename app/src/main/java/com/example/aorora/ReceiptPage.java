package com.example.aorora;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ReceiptPage extends AppCompatActivity implements View.OnClickListener{

    ImageView pollen_view_text_view_holder;
    ImageButton continue_button;
    ImageButton replay_button;
    ImageButton home_button;
    ImageButton jar_button;
    TextView pollen_score_tv;
    int game_settings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt_page);

        pollen_view_text_view_holder = findViewById(R.id.receipt_page_pollen_point_holder);
        continue_button = findViewById(R.id.receipt_page_exit_activity_button);
        replay_button = findViewById(R.id.play_again_button_receipt_page);
        home_button = findViewById(R.id.receipt_page_home_button);
        jar_button = findViewById(R.id.receipt_page_jar_button);
        pollen_score_tv = findViewById(R.id.receipt_page_pollen_points_tv);

        continue_button.setOnClickListener(this);
        replay_button.setOnClickListener(this);
        home_button.setOnClickListener(this);
        jar_button.setOnClickListener(this);

        Intent current_intent = this.getIntent();
        if(current_intent.hasExtra("GAME"))
        {
            game_settings = current_intent.getIntExtra("GAME", 1);
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
            to_navigate = new Intent(ReceiptPage.this, MindfullnessBreathingGame.class);
            to_navigate.putExtra("TimerValue", game_settings);
            startActivity(to_navigate);
        }
        else if(view_id == home_button.getId())
        {
            to_navigate = new Intent(ReceiptPage.this, HomeScreen.class);
            startActivity(to_navigate);
        }
        else if(view_id == jar_button.getId())
        {
            pollen_score_tv.setVisibility(View.VISIBLE);
            continue_button.setVisibility(View.VISIBLE);
            replay_button.setVisibility(View.VISIBLE);
            home_button.setVisibility(View.VISIBLE);
            pollen_view_text_view_holder.setVisibility(View.VISIBLE);
            jar_button.setImageResource(R.drawable.empty_receipt_jar);
        }
    }
}
