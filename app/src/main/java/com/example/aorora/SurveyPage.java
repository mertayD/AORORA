package com.example.aorora;

import android.content.Context;
import android.content.Intent;
import android.gesture.GestureOverlayView;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class SurveyPage extends AppCompatActivity implements View.OnClickListener {
    Context surveyPage;
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
            Toast.makeText(surveyPage, "Your answer is reported as RED", Toast.LENGTH_SHORT).show();
        }
        else if(v_id == darkorange_mood_button.getId())
        {
            result = 2;
            Toast.makeText(surveyPage, "Your answer is reported as DarkOrange", Toast.LENGTH_SHORT).show();
        }
        else if(v_id == orange_mood_button.getId())
        {
            result =32;
            Toast.makeText(surveyPage, "Your answer is reported as Orange", Toast.LENGTH_SHORT).show();
        }
        else if(v_id == yellow_mood_button.getId())
        {
            result = 4;
            Toast.makeText(surveyPage, "Your answer is reported as Yellow", Toast.LENGTH_SHORT).show();
        }
        else if(v_id == green_mood_button.getId())
        {
            result = 5;
            Toast.makeText(surveyPage, "Your answer is reported as Green", Toast.LENGTH_SHORT).show();
        }

        question_order_count++;
        if(question_order_count < questions_array_size) {
            survey_question_tv.setText(questions[question_order_count]);
        }
        else
        {
            Intent home_page = new Intent(surveyPage, HomeScreen.class);
            startActivity(home_page);
        }


    }
}
