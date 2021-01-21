package com.example.aorora;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AtriumDetail extends AppCompatActivity implements View.OnClickListener {
    //Class member declarations
    Context atriumDetail;
    ImageView displayImageView;
    ImageButton back_button;
    TextView descriptionTv;
    int displayImage;
    String desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atrium_detail);
        //Init context and onclicklistener
        atriumDetail = this;
        back_button = (ImageButton) findViewById(R.id.back_button_atriumDt);
        back_button.setOnClickListener(this);
        //Grab our views to update.
        displayImageView = findViewById(R.id.butterfly_display);
        descriptionTv = findViewById(R.id.butterfly_desc);

        //Grab the intent data
        getData();
        //Update the ImageView in the UI
        setData();
    }
    //Getter for our information bundled with the navigating Intent.
    private void getData() {
        if(getIntent().hasExtra("image")){
            displayImage = getIntent().getIntExtra("image", 1);
        }
    }
    //Takes the data we gathered from the intent and updates the UI.
    private void setData(){
        displayImageView.setImageResource(displayImage);
    }

    @Override
    public void onClick(View v){
        int view_id = v.getId();
        Intent to_navigate;
        if(view_id == back_button.getId())
            {
             to_navigate = new Intent(this, AtriumScreen.class);
             startActivity(to_navigate);
            }

    }
}