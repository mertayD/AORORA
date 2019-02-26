package com.example.aorora;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.gesture.GestureOverlayView;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class SurveyPage extends AppCompatActivity implements View.OnClickListener {
    Context surveyPage;
    Animation move_to_animation;
    Animation move_from_animation;
    ImageButton red_mood_button;
    ImageButton darkorange_mood_button;
    ImageButton orange_mood_button;
    ImageButton  yellow_mood_button;
    ImageButton green_mood_button;
    TextView survey_question_tv;
    String[] questions = {"How is everything?","How are you feeling today?","Are you upset?","Are you happy?","How did you start your day?","Do tou feel tired?"};
    final int questions_array_size = 6;
    int question_order_count;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey_page);

        //Initialization
        red_mood_button = (ImageButton) findViewById(R.id.red_mood_button);
        darkorange_mood_button = (ImageButton) findViewById(R.id.darkorange_mood_button);
        orange_mood_button = (ImageButton) findViewById(R.id.orange_mood_button);
        yellow_mood_button = (ImageButton) findViewById(R.id.yellow_mood_button);
        green_mood_button = (ImageButton) findViewById(R.id.green_mood_button);
        survey_question_tv = findViewById(R.id.survey_question_tv);
        question_order_count = 0;
        survey_question_tv.setText(questions[question_order_count]);
        surveyPage = this;

        red_mood_button.setOnClickListener(this);
        darkorange_mood_button.setOnClickListener(this);
        orange_mood_button.setOnClickListener(this);
        yellow_mood_button.setOnClickListener(this);
        green_mood_button.setOnClickListener(this);

        move_to_animation =
                AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.move);
        move_from_animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.movefromnegative);

        move_from_animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                red_mood_button.setClickable(true);
                darkorange_mood_button.setClickable(true);
                orange_mood_button.setClickable(true);
                yellow_mood_button.setClickable(true);
                green_mood_button.setClickable(true);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        move_to_animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                red_mood_button.setClickable(false);
                darkorange_mood_button.setClickable(false);
                orange_mood_button.setClickable(false);
                yellow_mood_button.setClickable(false);
                green_mood_button.setClickable(false);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                survey_question_tv.setText(questions[question_order_count]);
                survey_question_tv.startAnimation(move_from_animation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        // result will be considered on a scale of 1-5
        int result = 0;
        //v_id is the id of the view that is passed as a parameter
        int v_id = v.getId();

        if(v_id == red_mood_button.getId())
        {
            result = 1;
        }
        else if(v_id == darkorange_mood_button.getId())
        {
            result = 2;
        }
        else if(v_id == orange_mood_button.getId())
        {
            result =32;
        }
        else if(v_id == yellow_mood_button.getId())
        {
            result = 4;
        }
        else if(v_id == green_mood_button.getId())
        {
            result = 5;
        }

        question_order_count++;
        if(question_order_count < questions_array_size) {
            survey_question_tv.startAnimation(move_to_animation);

        }
        else
        {
            Intent home_page = new Intent(surveyPage, HomeScreen.class);
            startActivity(home_page);
        }


    }



}
