package com.example.aorora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AtriumDetail extends AppCompatActivity {
    ImageView displayImageView;
    TextView descriptionTv;
    int displayImage;
    String desc;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atrium_detail);
        //Grab our views to update.
        displayImageView = findViewById(R.id.butterfly_display);
        descriptionTv = findViewById(R.id.butterfly_desc);

        //Grab the intent data
        getData();
        //Update the ImageView in the UI
        setData();
    }

    private void getData() {
        if(getIntent().hasExtra("image")){
            displayImage = getIntent().getIntExtra("image", 1);
            Log.d("ATRIUMDETAIL", "Found atrium image");
        }

        else{
            Log.d("ATRIUMDETAIL", "Didnt find atrium image");
        }
    }

    private void setData(){
        displayImageView.setImageResource(displayImage);
    }
}