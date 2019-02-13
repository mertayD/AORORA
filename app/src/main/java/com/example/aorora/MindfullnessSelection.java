package com.example.aorora;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

public class MindfullnessSelection extends AppCompatActivity implements GestureDetector.OnGestureListener {
    GestureDetector gestureDetector;
    Context mindfullnessSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mindfullness_selection);
        mindfullnessSelection = this;
        gestureDetector = new GestureDetector(mindfullnessSelection, MindfullnessSelection.this);
    }

    @Override
    public boolean onFling (MotionEvent motionEvent1, MotionEvent motionEvent2, float X, float Y)
    {
        if (motionEvent1.getX() - motionEvent2.getX() > 50) {
            Intent surveyPage = new Intent(mindfullnessSelection, HomeScreen.class);
            startActivity(surveyPage);
            return true;
        }else {
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

}
