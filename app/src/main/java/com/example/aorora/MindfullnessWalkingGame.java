package com.example.aorora;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.CountDownTimer;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.DetectedActivity;
import com.plattysoft.leonids.Particle;
import com.plattysoft.leonids.ParticleSystem;
import com.plattysoft.leonids.modifiers.AlphaModifier;


public class MindfullnessWalkingGame extends AppCompatActivity {

    BroadcastReceiver broadcastReceiver;
    ImageButton exit;
    ParticleSystem myParticle;
    View emitter;
    Context walking;
    int count;
    TextView count_tv;
    Boolean check_first_drop;
    Animation flap;
    ImageView butterfly;
    AlphaModifier myAlpha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mindfullness_walking_game);
        exit = (ImageButton) findViewById(R.id.mindfullness_walking_exit_button);
        emitter = (View) findViewById(R.id.emiter_top);
        count_tv = (TextView) findViewById(R.id.walking_count_tv);
        butterfly = (ImageView) findViewById(R.id.butterfly_minfullness_walking);

        myAlpha = new AlphaModifier(1000, 10, 0, 8000, new AccelerateInterpolator());

        flap = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.butterfly_flap);
        flap.setRepeatCount(4);
        check_first_drop = true;
        walking = this;
        count = 0;



        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent to_navigate = new Intent(MindfullnessWalkingGame.this, SurveyPage.class);
                to_navigate.putExtra("NavigatedFrom", 3);
                startActivity(to_navigate);
                stopTracking();
            }
        });

        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals("activity_intent")) {
                    int type = intent.getIntExtra("type", -1);
                    int confidence = intent.getIntExtra("confidence", 0);
                    handleUserActivity(type, confidence);
                }
            }
        };
        startTracking();
    }
    private void handleUserActivity(int type, int confidence) {

        String label = "";

        switch (type) {
            case DetectedActivity.IN_VEHICLE: {
                label = "IN_VEHICLE";
                break;
            }
            case DetectedActivity.ON_BICYCLE: {
                label = "ON_BICYCLE";
                break;
            }
            case DetectedActivity.ON_FOOT: {
                label = "ON_FOOT";
                break;
            }
            case DetectedActivity.RUNNING: {
                label = "RUNNING";
                break;
            }
            case DetectedActivity.STILL: {
                label = "STILL";
                break;
            }
            case DetectedActivity.TILTING: {
                label = "TILTING";
                break;
            }
            case DetectedActivity.WALKING: {
                label = "WALKING";
                break;
            }
            case DetectedActivity.UNKNOWN: {
                label = "UNKNOWN";
                break;
            }
        }

        Log.e("ACTION_DETECTION", "User activity: " + label + ", Confidence: " + confidence);
        MindfullnessWalkingGame.Timer myTimer= new MindfullnessWalkingGame.Timer(10000,1000);

        if (confidence > 70) {
            Log.e("ACTION_DETECTION FINAL", "User activity: " + label + ", Confidence: " + confidence);
            //label == "WALKING" || label == "RUNNING" || label == "ON_FOOT"
            if(label == "WALKING" || label == "RUNNING" || label == "ON_FOOT")
            {
                butterfly.startAnimation(flap);
                if(myParticle != null)
                {
                    myParticle.cancel();
                }
                myParticle = new ParticleSystem(MindfullnessWalkingGame.this, 10, R.drawable.pollen, 8000)
                        .setAcceleration(0.00013f, 90)
                        .setSpeedByComponentsRange(0f, 0f, 0.05f, 0.08f)
                        .setFadeOut(8000, new AccelerateInterpolator())
                        .addModifier(myAlpha);
                myParticle.emitWithGravity(emitter, Gravity.BOTTOM, 1);
                myTimer.start();
            }
            else
            {
                myTimer.cancel();
                check_first_drop = true;
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver,
                new IntentFilter("activity_intent"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
    }

    private void startTracking() {
        Intent intent1 = new Intent( MindfullnessWalkingGame.this, BackgroundDetectedActivitiesService.class);
        startService(intent1);
    }

    private void stopTracking() {
        Intent intent = new Intent(walking, BackgroundDetectedActivitiesService.class);
        stopService(intent);
        if(myParticle != null )
        {
            myParticle.stopEmitting();

        }
    }

    class Timer extends CountDownTimer {
        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
        public Timer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            count += 1;
            if(check_first_drop && millisUntilFinished < 5000) {
                count_tv.setText("" + count);
                check_first_drop =false;
            }
            else
            {
                count_tv.setText("" + count);
            }
        }

        @Override
        public void onFinish() {
            myParticle.stopEmitting();
        }

    }
}
