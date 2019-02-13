package com.example.aorora;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import com.example.aorora.R;
import com.example.aorora.adapter.CustomAdapter;
import com.example.aorora.model.RetroPhoto;
import com.example.aorora.network.GetDataService;
import com.example.aorora.network.RetrofitClientInstance;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommunityPage extends AppCompatActivity implements GestureDetector.OnGestureListener, View.OnClickListener {

    private com.example.aorora.adapter.CustomAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDoalog;
    ImageButton home_button_bottombar;
    ImageButton profile_button_bottombar;
    ImageButton community_button_bottombar;
    ImageButton quest_button_bottombar;
    Context communityPage = this;
    GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_page);

        progressDoalog = new ProgressDialog(CommunityPage.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        home_button_bottombar = (ImageButton) findViewById(R.id.home_button_bottom_bar);
        profile_button_bottombar = (ImageButton) findViewById(R.id.profile_button_bottom_bar);
        community_button_bottombar = (ImageButton) findViewById(R.id.community_button_bottom_bar);
        quest_button_bottombar = (ImageButton) findViewById(R.id.quest_button_bottom_bar);

        home_button_bottombar.setOnClickListener(this);
        profile_button_bottombar.setOnClickListener(this);
        community_button_bottombar.setOnClickListener(this);
        quest_button_bottombar.setOnClickListener(this);

        gestureDetector = new GestureDetector(communityPage, CommunityPage.this);

        /*Create handle for the RetrofitInstance interface*/
        com.example.aorora.network.GetDataService service = com.example.aorora.network.RetrofitClientInstance.getRetrofitInstance().create(com.example.aorora.network.GetDataService.class);

        Call<List<RetroPhoto>> call = service.getAllPhotos();
        call.enqueue(new Callback<List<RetroPhoto>>() {

            @Override
            public void onResponse(Call<List<com.example.aorora.model.RetroPhoto>> call, Response<List<RetroPhoto>> response) {
                progressDoalog.dismiss();
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<com.example.aorora.model.RetroPhoto>> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(CommunityPage.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(List<com.example.aorora.model.RetroPhoto> photoList) {
        recyclerView = findViewById(R.id.customRecyclerView);
        adapter = new com.example.aorora.adapter.CustomAdapter(this,photoList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(CommunityPage.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

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

    @Override
    public boolean onFling (MotionEvent motionEvent1, MotionEvent motionEvent2, float X, float Y)
    {
        if (motionEvent1.getX() - motionEvent2.getX() > 50) {
            Intent homePage = new Intent(communityPage, HomeScreen.class);
            startActivity(homePage);
            return true;
        }
        else {
            return true;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return gestureDetector.onTouchEvent(motionEvent);
    }

    @Override
    public void onClick(View v) {
        int view_id = v.getId();
        Intent to_navigate;
        if(view_id == profile_button_bottombar.getId())
        {
            Toast.makeText(communityPage, "Profile Page", Toast.LENGTH_LONG).show();
            //to_navigate = new Intent(homeScreen, );
        }
        else if(view_id == community_button_bottombar.getId())
        {
            Toast.makeText(communityPage, "Community Page", Toast.LENGTH_LONG).show();
            //to_navigate = new Intent(communityPage, CommunityPage.class);
            //startActivity(to_navigate);
        }
        else if(view_id == quest_button_bottombar.getId())
        {
            Toast.makeText(communityPage, "Quest Page", Toast.LENGTH_LONG).show();
            //to_navigate = new Intent(homeScreen, );
        }
        else if(view_id == home_button_bottombar.getId())
        {
            to_navigate = new Intent(communityPage, HomeScreen.class);
            startActivity(to_navigate);
        }
    }
}
