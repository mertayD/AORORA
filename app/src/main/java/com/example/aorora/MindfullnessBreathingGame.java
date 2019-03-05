package com.example.aorora;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static java.sql.Types.INTEGER;

public class MindfullnessBreathingGame extends AppCompatActivity {

    ImageButton exit_button;
    ImageView inhale_button;
    ImageView butterfly_image;
    TextView remaining_breaths;
    TextView remaining_sec;
    Animation enlarge;
    Animation shrink;
    Vibrator myVibrate;
    boolean isRun;
    Context mindfullness_breathing_game;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mindfullness_breathing_game);

        // checks if inside the run because as soon as it finishes run it goes to cancel
        isRun = false;
        mindfullness_breathing_game = this;

        exit_button = (ImageButton) findViewById(R.id.exit_button_breathing);
        inhale_button = (ImageView) findViewById(R.id.breathing_inhale_button);
        butterfly_image = (ImageView) findViewById(R.id.butterfly_image_breathinggame);
        remaining_breaths = (TextView) findViewById(R.id.breath_count_tv);
        remaining_sec = (TextView) findViewById(R.id.remaining_time_breathing_tv);

        myVibrate = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        remaining_sec.setText("3 Seconds");
        if(getIntent().hasExtra("TimerValue"))
        {
            String text = getIntent().getStringExtra("TimerValue");
            remaining_breaths.setText(text + " Breaths");
        }
        enlarge = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.myanimation);
        shrink = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.shrink_to_original);

        final Handler handler = new Handler();
        final Runnable mLongPressed = new Runnable() {
            public void run() {
                Log.d("VERBOSE", "run: INSIDE RUN ");
                butterfly_image.startAnimation(shrink);
                isRun = true;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    myVibrate.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    //deprecated in API 26
                    myVibrate.vibrate(500);
                }
            }
        };

        inhale_button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    butterfly_image.startAnimation(enlarge);
                    handler.postDelayed(mLongPressed, 3000);

                    new CountDownTimer(3000, 100) {
                        ConstraintSet constraints = new ConstraintSet();
                        public void onTick(long millisUntilFinished) {

                            if(millisUntilFinished < 2000 ){
                                remaining_sec.setText("2 Seconds");
                            }
                            if(millisUntilFinished < 1000 ){
                                remaining_sec.setText("1 Seconds");
                            }


                        }

                        public void onFinish() {
                            remaining_sec.setText("0 Seconds");

                        }
                    }.start();
                    return true;
                }
                if((event.getAction() == MotionEvent.ACTION_MOVE)||(event.getAction() == MotionEvent.ACTION_UP)) {
                    handler.removeCallbacks(mLongPressed);
                    Log.d("VERBOSE", "run: INSIDE CANCEL");
                    if(!isRun){
                        butterfly_image.clearAnimation();
                    }
                    return false;
                }
                return false;
            }
        });

        shrink.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Log.d("VERBOSE", "run: INSIDE 2nd ANIM");
            }

            @Override
            public void onAnimationEnd(Animation animation) {

                int count = Character.getNumericValue(remaining_breaths.getText().charAt(0));
                if(count == 1)
                {
                    exit_button.performClick();
                }
                else
                {
                    count = count -1;
                    remaining_breaths.setText(count + " Breaths");
                    remaining_sec.setText("3 Seconds");
                }
                isRun = false;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        exit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent to_navigate = new Intent(mindfullness_breathing_game, MindfullnessBreathing.class);
                startActivity(to_navigate);
            }
        });

    }

}
