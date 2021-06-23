package com.example.aorora;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aorora.adapter.AtriumAdapter;
import com.example.aorora.network.NetworkCalls;
import com.example.aorora.utils.MapWrapper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
This screen contains the atrium inventory logic and code to display butterfly counts from the
backend. Each butterfly presented is currently one of five basic butterflies for use in the MVP
of ARORA. These butterflies will be collected and stored here in the Atrium as a core component of
M4.
 */
public class AtriumScreen extends AppCompatActivity implements View.OnClickListener{
    //intent info
    Intent atriumIntent;

    //User account info
    Integer userId;

    //RecyclerView Variables
    private RecyclerView atriumRecycler;
    AtriumAdapter atriumAdapter;
    RecyclerView.LayoutManager layoutManager;

    Context atriumScreen;
    TextView title;
    Button add_butterflies;

    //Grab the user's local atrium map to be updated and pushed back to the UserInfo Model.
    LinkedHashMap<String, Integer> local_atrium = new LinkedHashMap<>();


    //Stores the total amount of unique basic butterflies currently registered for the user.
    Integer butterflyTypeCount;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atrium);

        title = findViewById(R.id.title);
        add_butterflies = (Button) findViewById(R.id.add_button);

        //Grab the userId
        userId = MainActivity.user_info.getUser_id();

        //Get the built atrium and set it to something easier to access here.
        atriumIntent = getIntent();
        if(atriumIntent.hasExtra("CaughtButterflies")){
            add_butterflies.setVisibility(View.VISIBLE);
            title.setText(String.valueOf("Butterflies Caught"));
            MapWrapper mapWrapper = (MapWrapper) atriumIntent.getExtras().getSerializable("map");
            local_atrium = (LinkedHashMap<String, Integer>) mapWrapper.getMap();
        } else {
            local_atrium = MainActivity.user_info.get_local_atrium();
        }

        //Grab the recyclerview
        atriumRecycler = findViewById(R.id.atriumRecycler);
        atriumAdapter = new AtriumAdapter(this, local_atrium);
        atriumRecycler.setAdapter(atriumAdapter);
        layoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        atriumRecycler.setLayoutManager(layoutManager);
        atriumRecycler.setHasFixedSize(true);

        atriumScreen = this;
        add_butterflies = (Button) findViewById(R.id.add_button);

        //Onclicklisteners for this class.
        add_butterflies.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int view_id = v.getId();
        if(view_id == add_butterflies.getId()){
//            for(Integer i = 0; i < counts.length - 1; i++){
//                String currString = "user_b" + i.toString() + "_count";
//                counts[i] = counts[i] + 1;
//                local_atrium.put(currString, counts[i]);
//            }
//            System.out.println("Local Atrium: " + Arrays.asList(local_atrium));
//            Toast.makeText(atriumScreen, "Adding to each butterfly count", Toast.LENGTH_SHORT).show();
//            atriumAdapter.notifyDataSetChanged();
//            //First update ourselves locally
//            MainActivity.user_info.update_local_atrium(local_atrium);
//            //Once we get the updated local atrium, push the new atrium map to the backend.
//            NetworkCalls.updateUserAtrium(userId, local_atrium, atriumScreen);

            finish();
        }
    }
}
