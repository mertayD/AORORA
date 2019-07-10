package com.example.aorora;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.aorora.network.NetworkCalls;

import static com.example.aorora.MainActivity.user_info;

public class MindfulnessMeditationGame_R extends AppCompatActivity implements View.OnClickListener {

    ImageView outer_most_ring;
    ImageView outer_ring;
    ImageView inner_ring;
    ImageView most_inner_ring;
    ImageView theme_image;

    ImageButton pause;
    ImageButton pause_ring;

    Animation wrong_parts;
    Animation last_right_part;
    Animation full_cycle_most_inner;
    Animation full_cycle_inner;
    Animation full_cycle_outer;
    Animation full_cycle_most_outer;

    boolean animation_start;
    boolean is_first_cycle;
    boolean is_second_cycle;
    boolean is_third_cycle;
    boolean is_forth_cycle;

    ConstraintLayout layout;

    Vibrator myVibrate;
    MediaPlayer theme_music;
    MediaPlayer snap_sound;

    ImageButton exit_button;
    ImageView arrow;

    Animation expand;
    Timer myTimer;

    int game_theme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mindfulness_meditation_game__r);

        is_first_cycle = false;
        is_second_cycle = false;
        is_third_cycle = false;
        is_forth_cycle = false;

        // Change the number of ms to adjust it to length of meditation sound.
        myTimer = new Timer(64000, 1000);
        myTimer.start();

        expand = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.meditation_expand_anim);

        exit_button = findViewById(R.id.exit_button_meditation_r);

        theme_image = findViewById(R.id.theme_image);
        layout = findViewById(R.id.meditation_layout);

        arrow = findViewById(R.id.meditation_arrow);
        pause = findViewById(R.id.pause_button_meditations);
        pause_ring = findViewById(R.id.ring_pause_button_meditations);

        snap_sound = MediaPlayer.create(MindfulnessMeditationGame_R.this,R.raw.snap_sound_meditation);

        outer_most_ring = findViewById(R.id.most_outer_ring);
        outer_ring = findViewById(R.id.outer_ring);
        inner_ring = findViewById(R.id.inner_ring);
        most_inner_ring = findViewById(R.id.most_inner_ring);

        full_cycle_most_inner = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.full_cycle);
        full_cycle_most_inner.setDuration(4000);
        full_cycle_most_inner.setInterpolator(new LinearInterpolator());

        full_cycle_inner = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.full_cycle);
        full_cycle_inner.setDuration(5500);
        full_cycle_inner.setInterpolator(new LinearInterpolator());

        full_cycle_outer = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.full_cycle);
        full_cycle_outer.setDuration(7000);
        full_cycle_outer.setInterpolator(new LinearInterpolator());

        wrong_parts = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.wrong_parts_of_circle);
        wrong_parts.setInterpolator(new LinearInterpolator());

        last_right_part = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.final_40_degre);
        last_right_part.setInterpolator(new LinearInterpolator());

        most_inner_ring.startAnimation(full_cycle_most_inner);
        inner_ring.startAnimation(full_cycle_inner);
        outer_ring.startAnimation(full_cycle_outer);

        myVibrate = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        //Game Settings
        Intent meditation_game = getIntent();
        if(meditation_game.hasExtra("Theme"))
        {
            game_theme = meditation_game.getIntExtra("Theme", 1);
            switch(game_theme){
                case 4:
                    theme_music = MediaPlayer.create(MindfulnessMeditationGame_R.this,R.raw.feather2);
                    layout.setBackgroundResource(R.drawable.background_orange_ring);
                    theme_image.setImageResource(R.drawable.mountain_orange_ring);
                    outer_most_ring.setImageResource(R.drawable.orange_ring_1);
                    outer_ring.setImageResource(R.drawable.orange_ring_2);
                    inner_ring.setImageResource(R.drawable.orange_ring_3);
                    most_inner_ring.setImageResource(R.drawable.orange_ring_4);
                    pause.setImageResource(R.drawable.orange_button);
                    pause_ring.setImageResource(R.drawable.orange_button_ring);
                    arrow.setImageResource(R.drawable.orange_arrow);
                    break;
                case 1:
                    theme_music = MediaPlayer.create(MindfulnessMeditationGame_R.this,R.raw.feather4);
                    layout.setBackgroundResource(R.drawable.background_white_ring);
                    theme_image.setImageResource(R.drawable.white_theme);
                    outer_most_ring.setImageResource(R.drawable.white_ring_1);
                    outer_ring.setImageResource(R.drawable.white_ring_2);
                    inner_ring.setImageResource(R.drawable.white_ring_3);
                    most_inner_ring.setImageResource(R.drawable.white_ring_4);
                    pause.setImageResource(R.drawable.white_button);
                    pause_ring.setImageResource(R.drawable.white_button_ring);
                    arrow.setImageResource(R.drawable.white_arrow);
                    break;
                case 2:
                    theme_music = MediaPlayer.create(MindfulnessMeditationGame_R.this,R.raw.feather3);
                    layout.setBackgroundResource(R.drawable.background_blue_ring);
                    theme_image.setImageResource(R.drawable.blue_theme_ring);
                    outer_most_ring.setImageResource(R.drawable.blue_ring_1);
                    outer_ring.setImageResource(R.drawable.blue_ring_2);
                    inner_ring.setImageResource(R.drawable.blue_ring_3);
                    most_inner_ring.setImageResource(R.drawable.blue_ring_4);
                    pause.setImageResource(R.drawable.blue_button);
                    pause_ring.setImageResource(R.drawable.blue_button_ring);
                    arrow.setImageResource(R.drawable.blue_arrow);
                    break;
                case 3:
                    theme_music = MediaPlayer.create(MindfulnessMeditationGame_R.this,R.raw.feather1);
                    layout.setBackgroundResource(R.drawable.background_purple_ring);
                    theme_image.setImageResource(R.drawable.purple_theme);
                    outer_most_ring.setImageResource(R.drawable.purple_ring_1);
                    outer_ring.setImageResource(R.drawable.purple_ring_2);
                    inner_ring.setImageResource(R.drawable.purple_ring_3);
                    most_inner_ring.setImageResource(R.drawable.purple_ring_4);
                    pause.setImageResource(R.drawable.purple_button);
                    pause_ring.setImageResource(R.drawable.purple_button_ring);
                    arrow.setImageResource(R.drawable.purple_arrow);
                    break;
            }
        }

        theme_music.start();

        exit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent to_navigate = new Intent(MindfulnessMeditationGame_R.this, MindfullnessMeditation.class);
                startActivity(to_navigate);
                if(theme_music.isPlaying())
                {
                    Log.e("MUSIC", " STOPPED");
                    theme_music.stop();
                }
                myTimer.cancel();
            }
        });

        wrong_parts.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if(!is_first_cycle)
                {
                    outer_most_ring.startAnimation(last_right_part);
                }
                else if(!is_second_cycle)
                {
                    outer_ring.startAnimation(last_right_part);
                }
                else if(!is_third_cycle)
                {
                    inner_ring.startAnimation(last_right_part);
                }
                else if(!is_forth_cycle)
                {
                    most_inner_ring.startAnimation(last_right_part);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        last_right_part.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                animation_start = true;
                pause_ring.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if(!is_first_cycle)
                {
                    outer_most_ring.startAnimation(wrong_parts);
                }
                else if(!is_second_cycle)
                {
                    outer_ring.startAnimation(wrong_parts);
                }
                else if(!is_third_cycle)
                {
                    inner_ring.startAnimation(wrong_parts);
                }
                else if(!is_forth_cycle)
                {
                    most_inner_ring.startAnimation(wrong_parts);
                }

                animation_start = false;
                pause_ring.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        pause.setOnClickListener(this);
        pause_ring.setOnClickListener(this);
        outer_most_ring.startAnimation(wrong_parts);

    }


    @Override
    public void onClick(View v) {
        if(animation_start)
        {
            snap_sound.start();

            theme_image.startAnimation(expand);

            if(!is_first_cycle)
            {
                is_first_cycle = true;
                outer_most_ring.clearAnimation();
                outer_ring.clearAnimation();
                outer_ring.startAnimation(wrong_parts);
            }
            else if(!is_second_cycle)
            {
                is_second_cycle = true;
                outer_ring.clearAnimation();
                inner_ring.clearAnimation();
                inner_ring.startAnimation(wrong_parts);
            }
            else if(!is_third_cycle)
            {
                is_third_cycle = true;
                inner_ring.clearAnimation();
                most_inner_ring.clearAnimation();
                most_inner_ring.startAnimation(wrong_parts);
            }
            else if(!is_forth_cycle)
            {
                is_forth_cycle = true;
                most_inner_ring.clearAnimation();

                new CountDownTimer(5000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        is_first_cycle = false;
                        is_second_cycle = false;
                        is_third_cycle = false;
                        is_forth_cycle = false;

                        most_inner_ring.startAnimation(full_cycle_most_inner);
                        inner_ring.startAnimation(full_cycle_inner);
                        outer_ring.startAnimation(full_cycle_outer);
                        outer_most_ring.startAnimation(wrong_parts);

                    }
                }.start();
            }
        }
        else
        {
            myVibrate.vibrate(500);
        }
    }

    class Timer extends CountDownTimer {
        int mins;
        int sec;
        float mod_sec;
        //long remaining;

        public Timer(long ms, long countdownInterval)
        {
            super(ms,countdownInterval);
            //remaining = ms;
        }
        @Override
        public void onTick(long millisUntilFinished) {
            /*
            mins = (int) millisUntilFinished/60000;
            mod_sec = millisUntilFinished % 60000;
            sec = (int) mod_sec / 1000;
            remaining = millisUntilFinished;
            if(sec > 9) {
                countDownTimer.setText(mins + ":" + sec);
            }
            else
            {
                countDownTimer.setText(mins + ":0" + sec);
            }
            */
            //Log.e("ON TICK", "" + " TICK");
        }

        @Override
        public void onFinish() {
            if(theme_music.isPlaying())
            {
                theme_music.stop();
            }
            Intent to_navigate = new Intent(MindfulnessMeditationGame_R.this, ReceiptPage.class);
            to_navigate.putExtra("NavigatedFrom", 2);
            to_navigate.putExtra("Game Theme", game_theme);
            startActivity(to_navigate);
            int user_points = user_info.getUser_pollen();
            NetworkCalls.updateUserCurrentPoints(user_info.getUser_id(), user_points + 5 , MindfulnessMeditationGame_R.this);
            NetworkCalls.updateDailyTaskM2(user_info.getUser_id(), 1, MindfulnessMeditationGame_R.this);
            Log.e("ON FINISH", "" + " FINISH");
        }
/*
        public long onPause()
        {
            this.cancel();
            return remaining;
        }
        */
    }
}
