package com.example.aorora;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.plattysoft.leonids.ParticleSystem;

public class MindfullnessBreathingGame extends AppCompatActivity {

    static ImageButton exit_button;
    ImageView inhale_button;
    ImageView butterfly_image;
    TextView remaining_breaths;
    TextView remaining_sec;
    Animation enlarge;
    Animation shrink;
    Vibrator myVibrate;
    boolean isRun;
    boolean clickable;
    boolean isTwoDigit;
    static int count;
    static boolean cont;
    Context mindfullness_breathing_game;
    MediaPlayer breathing_music;
    String inhale_text = "Press and hold as \n you breath in";
    String exhale_text = "Exhale as butterfly shrinks \n and leave the button";
    TextView desc_tv;
    Dialog myDialog;
    TextView score_tv;
    TextView pollen_points_desc_tv;
    ImageButton pollen_button;
    int points_to_collect;
    int initial_score;
    View pollen_layout;
    View emitter;
    int possible_points;
    Button pop_up_exit;
    Animation tap_me_animation;
    boolean is_button_still_clicked;
    boolean performed_click;
    final Timer myTimer= new Timer(3000,100);
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mindfullness_breathing_game);

        // checks if inside the run because as soon as it finishes run it goes to cancel
        isRun = false;
        clickable = true;
        cont = false;
        mindfullness_breathing_game = this;
        possible_points = 0;
        is_button_still_clicked = false;
        performed_click = false;

        LottieAnimationView animationView = findViewById(R.id.animation_view);
        animationView.setSpeed(1f);
        animationView.playAnimation();

        myDialog = new Dialog(this);
        pollen_layout = (View) findViewById(R.id.breathing_game_pollen_layout);
        score_tv = pollen_layout.findViewById(R.id.pollen_score_layout_tv);
        initial_score = Integer.parseInt(score_tv.getText().toString());

        tap_me_animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.tap_me_animation);
        desc_tv = (TextView) findViewById(R.id.desc_to_breathinggame_tv);
        exit_button = (ImageButton) findViewById(R.id.exit_button_walking);
        inhale_button = (ImageView) findViewById(R.id.breathing_inhale_button);
        butterfly_image = (ImageView) findViewById(R.id.butterfly_image_breathinggame);
        remaining_breaths = (TextView) findViewById(R.id.breath_count_tv);
        remaining_sec = (TextView) findViewById(R.id.remaining_time_breathing_tv);

        myVibrate = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        breathing_music = MediaPlayer.create(MindfullnessBreathingGame.this,R.raw.readingbreathing1);

        remaining_sec.setText("3 Seconds");
        if(getIntent().hasExtra("TimerValue"))
        {
            int text = getIntent().getIntExtra("TimerValue", 1);
            if(text == 1)
            {
                possible_points = 5;
                text = 2;
            }
            else if( text == 2)
            {
                possible_points = 10;
                text = 10;
            }
            else{
                possible_points = 15;
                text = 15;
            }
            remaining_breaths.setText(text + " Breaths");
        }
        enlarge = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.butterfly_opening);
        shrink = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.butterfly_closing);

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

                String temp = remaining_breaths.getText().toString();
                String counted = "";
                int index = 0;
                while (index<2)
                {
                    char current = temp.charAt(index);
                    if(current != ' ') {
                        counted = counted + current;
                    }
                    index++;
                }
                count = Integer.parseInt(counted);
                if(cont)
                {
                    MainActivity.user_points += 1;
                    count = count + 1;
                }
                else
                {
                    count = count -1;
                }
                remaining_breaths.setText(count + " Breaths");
            }
        };

        inhale_button.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN && clickable) {
                    butterfly_image.startAnimation(enlarge);
                    handler.postDelayed(mLongPressed, 3000);
                    myTimer.start();
                    if(!breathing_music.isPlaying())
                    {
                        breathing_music.start();
                    }
                    is_button_still_clicked = true;
                    return true;
                }
                if((event.getAction() == MotionEvent.ACTION_UP)) {
                    handler.removeCallbacks(mLongPressed);
                    Log.d("VERBOSE", "run: INSIDE CANCEL");
                    is_button_still_clicked = false;
                    if(!isRun){
                        remaining_sec.setText("3 Seconds");
                        butterfly_image.clearAnimation();
                        myTimer.cancel();
                    }
                    breathing_music.pause();
                    return false;
                }
                return false;
            }
        });


        shrink.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                Log.d("VERBOSE", "run: INSIDE 2nd ANIM");
                clickable = false;
            }

            @Override
            public void onAnimationEnd(Animation animation) {

                if (is_button_still_clicked)
                {
                    butterfly_image.startAnimation(enlarge);
                    handler.postDelayed(mLongPressed, 3000);
                    myTimer.start();
                }

                if(count == 0)
                {
                    //DialogFragment newFragment = new BreathDialog();
                    //newFragment.show(getSupportFragmentManager(), "CONTINUE");
                    ShowPopup();
                }
                else
                {
                    desc_tv.setText("" + inhale_text);
                    remaining_sec.setText("3 Seconds");
                    myVibrate.vibrate(500);
                }
                isRun = false;
                clickable = true;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        exit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!cont && count > 0)
                {
                    possible_points = 0;
                }
                MainActivity.user_points += possible_points;
                Intent to_navigate = new Intent(mindfullness_breathing_game, MindfullnessBreathing.class);
                if(breathing_music.isPlaying())
                {
                    breathing_music.stop();
                }
                startActivity(to_navigate);
            }
        });
        myDialog.setContentView(R.layout.custom_dialog_breathing);
        pop_up_exit = (Button) myDialog.findViewById(R.id.button_exercise_select);
        pop_up_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exit_button.performClick();
            }
        });

    }

    class Timer extends CountDownTimer{

        public Timer(long ms, long countdownInterval)
        {
            super(ms,countdownInterval);
        }
        @Override
        public void onTick(long millisUntilFinished) {
            if(millisUntilFinished < 2000 ){
                remaining_sec.setText("2 Seconds");
                myVibrate.vibrate(350);
            }
            if(millisUntilFinished < 1000 ){
                remaining_sec.setText("1 Seconds");
                myVibrate.vibrate(700);
            }
            else
            {
                myVibrate.vibrate(100);
            }
        }
        @Override
        public void onFinish() {
            remaining_sec.setText("0 Seconds");
            desc_tv.setText("" + exhale_text);
        }
    }

    public static class BreathDialog extends DialogFragment {
        @Override
        //TODO fix pressing outside dialog
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            //Use the Builder class for convenient dialog construction
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            LayoutInflater inflater = requireActivity().getLayoutInflater();
            builder.setView(inflater.inflate(R.layout.custom_dialog_breathing,null))
                    .setTitle("Congratulations!")
                    .setPositiveButton(R.string.Continue, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            cont = true;
                        }
                    })
                    .setNegativeButton(R.string.Exit, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            exit_button.performClick();
                        }
                    });

            return builder.create();
        }
    }
    public void ShowPopup() {
        if(breathing_music.isPlaying())
        {
            breathing_music.stop();
        }
        emitter = myDialog.findViewById(R.id.emiter_pollen);
        pollen_points_desc_tv = myDialog.findViewById(R.id.pollens_earned_receipt_tv);
        String pollen_points_desc = pollen_points_desc_tv.getText().toString();
        String temp = "";
        for(int i = 0; i < pollen_points_desc_tv.length(); i++)
        {
            if(Character.isDigit(pollen_points_desc.charAt(i)))
            {
                temp += pollen_points_desc.charAt(i);
            }
        }
        points_to_collect = Integer.parseInt(temp);
        Log.e("POLLEN POINTS", "" + temp);
        final ParticleSystem myParticle = new ParticleSystem(MindfullnessBreathingGame.this, 10, R.drawable.pollen, 2000)
                .setAcceleration(0.0018f, -90)
                .setAcceleration(0.00013f, 180)
                .setSpeedByComponentsRange(-0.07f, 0f, -0.2f, -0.15f)
                .setFadeOut(2000);;
        pollen_button = myDialog.findViewById(R.id.pollen_icon_receipt);
        pollen_button.startAnimation(tap_me_animation);
        pollen_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pollen_button.clearAnimation();
                pollen_button.setImageResource(R.drawable.half_pollen);
                myParticle.emitWithGravity(pollen_points_desc_tv, Gravity.TOP, 4);
                pollen_button.setClickable(false);
                new CountDownTimer(3000, 100) {

                    public void onTick(long millisUntilFinished) {
                        String cur_score = score_tv.getText().toString();
                        int score = Integer.parseInt(cur_score);
                        Log.e("INITIALSCORE TICK", "" + score);
                        Log.e("POSSIBLESCORE TICK", "" + (int) (points_to_collect * 1 / 30));
                        score += (int) (points_to_collect * 1 / 30);
                        Log.e("TOTAL TICK","" + score);
                        score_tv.setText("" + score);
                    }

                    public void onFinish() {
                        myParticle.stopEmitting();
                        Log.e("Possible POINTS","" + points_to_collect );
                        Log.e("Initial Score POINTS","" + initial_score );
                        int total_score = points_to_collect + initial_score;
                        score_tv.setText("" + total_score);
                    }
                }.start();
            }
        });

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.setCanceledOnTouchOutside(false);
        myDialog.show();
    }
}
