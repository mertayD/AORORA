package com.example.aorora;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.aorora.network.GetDataService;
import com.example.aorora.network.NetworkCalls;
import com.example.aorora.network.RetrofitClientInstance;

public class ARScreen extends AppCompatActivity implements View.OnClickListener {
    //User account info
    Integer userPollen;
    Integer userId;

    //Retrofit network object
    GetDataService service;

    Context arScreen;
    ImageButton home_button_bottombar;
    ImageButton profile_button_bottombar;
    ImageButton community_button_bottombar;
    ImageButton quest_button_bottombar;
    Button spendPollenBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //User account info
        userPollen = MainActivity.user_info.getUser_pollen();
        userId = MainActivity.user_info.getUser_id();

        //Retrofit objects
        //Init our backend service
        service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);

        setContentView(R.layout.activity_ar_screen);
        arScreen = this;
        home_button_bottombar = (ImageButton) findViewById(R.id.home_button_bottom_bar);
        profile_button_bottombar = (ImageButton) findViewById(R.id.profile_button_bottom_bar);
        community_button_bottombar = (ImageButton) findViewById(R.id.community_button_bottom_bar);
        quest_button_bottombar = (ImageButton) findViewById(R.id.quest_button_bottom_bar);
        spendPollenBtn = (Button) findViewById(R.id.spend_pollen_btn);


        //Onclicklisteners for this class.
        home_button_bottombar.setOnClickListener(this);
        profile_button_bottombar.setOnClickListener(this);
        community_button_bottombar.setOnClickListener(this);
        quest_button_bottombar.setOnClickListener(this);



        spendPollenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!hasEnoughPollen()){
                    Toast.makeText(ARScreen.this, "Sorry! Not enough pollen! Complete some quests!", Toast.LENGTH_SHORT).show();
                    return;
                }
                //Otherwise, we have enough pollen, decrement it and update the backend.
                userPollen -= 10;
                Toast.makeText(ARScreen.this, "Spending pollen to access AR butterflies for one day.", Toast.LENGTH_SHORT).show();
                //TODO: Add one day activation of butterfly activity, perhaps in MainActivity or UserInfo?
                //Finally do the PUT request with the new pollen value. May need to refresh the UI.
                //This is not updating the backend, need to use a network call.
                MainActivity.user_info.setUser_pollen(userPollen);
                //This will update the backend and set the current pollen to our decremented value.
                NetworkCalls.updateUserCurrentPoints(userId, userPollen,ARScreen.this);
            }
        });

    }

    public boolean hasEnoughPollen() {
        return userPollen >= 10;
    }

    @Override
    public void onClick(View v) {
        int view_id = v.getId();
        Intent to_navigate;

        if(view_id == profile_button_bottombar.getId())
        {
            to_navigate = new Intent(arScreen, ProfilePage.class);
            startActivity(to_navigate);
        }
        else if(view_id == community_button_bottombar.getId())
        {
            to_navigate = new Intent(arScreen, CommunityPage.class);
            startActivity(to_navigate);
        }
        else if(view_id == quest_button_bottombar.getId())
        {
            to_navigate = new Intent(arScreen, MindfullnessSelection.class);
            startActivity(to_navigate);

        }
        else if(view_id == home_button_bottombar.getId())
        {
            to_navigate = new Intent(arScreen, HomeScreen.class);
            startActivity(to_navigate);
        }

    }


}