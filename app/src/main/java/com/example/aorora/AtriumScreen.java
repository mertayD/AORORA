package com.example.aorora;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.aorora.adapter.AtriumAdapter;
import com.example.aorora.network.NetworkCalls;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AtriumScreen extends AppCompatActivity implements View.OnClickListener{
    //User account info
    Integer userPollen;
    Integer userId;

    //RecyclerView Variables
    private RecyclerView atriumRecycler;
    AtriumAdapter atriumAdapter;
    RecyclerView.LayoutManager layoutManager;
    int unique_butterflies;


    Context atriumScreen;
    ImageButton back_button;
    ImageButton home_button_bottombar;
    ImageButton profile_button_bottombar;
    ImageButton community_button_bottombar;
    ImageButton quest_button_bottombar;
    Button add_butterflies;

    //Images for the butterflies
    int images[] = {R.drawable.red_butterfly_button, R.drawable.yellow_butterfly_button,
            R.drawable.orange_butterfly_button, R.drawable.green_butterfly_button,
            R.drawable.darkorange_butterfly_button};
    //Counts of each type of butterfly, we can make this look nicer.
    int counts[] = {MainActivity.user_info.getUser_b0_count(),
            MainActivity.user_info.getUser_b1_count(),
            MainActivity.user_info.getUser_b2_count(),
            MainActivity.user_info.getUser_b3_count(),
            MainActivity.user_info.getUser_b4_count(),};
    //Store the amount of basic butterfly counts
    List<Integer> butterflyCounts = new ArrayList<>();
    //Grab the user's local atrium map
    Map<String, Integer> local_atrium = new HashMap<>();

    //Stores the total amount of unique basic butterflies currently registered for the user.
    Integer butterflyTypeCount;

    Map<String, Integer> countsMap;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atrium);
        //Grab the userId
        userId = MainActivity.user_info.getUser_id();

        //Grab the recyclerview
        atriumRecycler = findViewById(R.id.atriumRecycler);
        atriumAdapter = new AtriumAdapter(this, images, counts);
        atriumRecycler.setAdapter(atriumAdapter);
        layoutManager = new GridLayoutManager(this, 3);
        atriumRecycler.setLayoutManager(layoutManager);
        atriumRecycler.setHasFixedSize(true);

        atriumScreen = this;
        home_button_bottombar = (ImageButton) findViewById(R.id.home_button_bottom_bar);
        profile_button_bottombar = (ImageButton) findViewById(R.id.profile_button_bottom_bar);
        community_button_bottombar = (ImageButton) findViewById(R.id.community_button_bottom_bar);
        quest_button_bottombar = (ImageButton) findViewById(R.id.quest_button_bottom_bar);
        back_button = (ImageButton) findViewById(R.id.back_button_atrium);
        add_butterflies = (Button) findViewById(R.id.add_button);


        //Onclicklisteners for this class.
        home_button_bottombar.setOnClickListener(this);
        profile_button_bottombar.setOnClickListener(this);
        community_button_bottombar.setOnClickListener(this);
        quest_button_bottombar.setOnClickListener(this);
        back_button.setOnClickListener(this);
        add_butterflies.setOnClickListener(this);

        countsMap = new HashMap<>();
        MainActivity.user_info.build_atrium();
        local_atrium = MainActivity.user_info.get_local_atrium();
        butterflyTypeCount = local_atrium.size();


    }

    @Override
    public void onClick(View v) {
        int view_id = v.getId();
        Intent to_navigate;
        if(view_id == profile_button_bottombar.getId())
        {
            to_navigate = new Intent(atriumScreen, ProfilePage.class );
            startActivity(to_navigate);
        }
        else if(view_id == quest_button_bottombar.getId())
        {
            to_navigate = new Intent(atriumScreen, MindfullnessSelection.class);
            startActivity(to_navigate);
        }
        else if(view_id == home_button_bottombar.getId())
        {
            to_navigate = new Intent(atriumScreen, HomeScreen.class);
            startActivity(to_navigate);
        }
        else if(view_id == community_button_bottombar.getId())
        {
            Toast.makeText(atriumScreen, "Community page is under maintenance.", Toast.LENGTH_SHORT).show();
            //to_navigate = new Intent(butterflyCollection, CommunityPage.class);
            //startActivity(to_navigate);
        }
        else if(view_id == back_button.getId())
        {
            to_navigate = new Intent(atriumScreen, ProfilePage.class);
            startActivity(to_navigate);
        }
        else if(view_id == add_butterflies.getId()){
            for(Integer i = 0; i < counts.length; i++){
                String currString = "user_b" + i.toString() + "_count";
                counts[i] = counts[i] + 1;
                countsMap.put(currString, counts[i]);
            }
            System.out.println(Arrays.asList(countsMap));
            Toast.makeText(atriumScreen, "Adding to each butterfly count", Toast.LENGTH_SHORT).show();
            atriumAdapter.notifyDataSetChanged();
            System.out.println(countsMap.keySet());
            NetworkCalls.updateUserAtrium(userId, countsMap, atriumScreen);
        }
    }
}
