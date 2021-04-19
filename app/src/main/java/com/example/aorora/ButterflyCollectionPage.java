package com.example.aorora;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;

import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.aorora.interfaces.OnItemClickListener;
import com.example.aorora.model.UserInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*OLD VERSION of Atrium, which is integrated with the unimplemented community logic that breaks the
whole thing. Reference AtriumScreen and AtriumDetail for now.
 */
public class ButterflyCollectionPage extends AppCompatActivity implements View.OnClickListener {

    private com.example.aorora.adapter.GridViewAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDoalog;
    ImageButton home_button_bottombar;
    ImageButton profile_button_bottombar;
    ImageButton community_button_bottombar;
    ImageButton quest_button_bottombar;
    ImageButton back_button;
    Context butterflyCollection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butterfly_collection_page);

        butterflyCollection = this;
        progressDoalog = new ProgressDialog(butterflyCollection);

        home_button_bottombar = (ImageButton) findViewById(R.id.home_button_bottom_bar);
        profile_button_bottombar = (ImageButton) findViewById(R.id.profile_button_bottom_bar);
        community_button_bottombar = (ImageButton) findViewById(R.id.community_button_bottom_bar);
        quest_button_bottombar = (ImageButton) findViewById(R.id.quest_button_bottom_bar);
        back_button = (ImageButton) findViewById(R.id.back_button_butterflyc_page);
        home_button_bottombar.setOnClickListener(this);
        profile_button_bottombar.setOnClickListener(this);
        community_button_bottombar.setOnClickListener(this);
        quest_button_bottombar.setOnClickListener(this);
        back_button.setOnClickListener(this);
        progressDoalog.setMessage("Friends Loading....");
        progressDoalog.show();

        com.example.aorora.network.GetDataService service = com.example.aorora.network.RetrofitClientInstance.getRetrofitInstance().create(com.example.aorora.network.GetDataService.class);

        Call<List<UserInfo>> call = service.getCommunity();
        call.enqueue(new Callback<List<UserInfo>>() {
            @Override
            public void onResponse(Call<List<UserInfo>> call, Response<List<UserInfo>> response) {
                if(response.isSuccess())//response.body().getUsername()
                {
                    List<UserInfo> users = response.body();
                    generateDataListGrid(users);
                }
                else
                {
                    Toast.makeText(butterflyCollection, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<UserInfo>> call, Throwable t) {
                Toast.makeText(butterflyCollection, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                Log.e("ERROR CAUSE", "" + t.getMessage() +  " Cause  " + t.getCause());
            }
        });


    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataListGrid(List<UserInfo> community) {
        recyclerView = findViewById(R.id.customRecyclerView);
        adapter = new com.example.aorora.adapter.GridViewAdapter(butterflyCollection, community, new OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent details = new Intent(butterflyCollection, ButterflyDetailsPage.class);
                details.putExtra("ButterflyId", position);
                startActivity(details);
            }
        });
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(butterflyCollection, 3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onClick(View v) {
        int view_id = v.getId();
        Intent to_navigate;
        if(view_id == profile_button_bottombar.getId())
        {
            to_navigate = new Intent(butterflyCollection, ProfilePage.class );
            startActivity(to_navigate);
        }
        else if(view_id == quest_button_bottombar.getId())
        {
            to_navigate = new Intent(butterflyCollection, MindfullnessSelection.class);
            startActivity(to_navigate);
        }
        else if(view_id == home_button_bottombar.getId())
        {
            to_navigate = new Intent(butterflyCollection, HomeScreen.class);
            startActivity(to_navigate);
        }
        else if(view_id == community_button_bottombar.getId())
        {
            Toast.makeText(ButterflyCollectionPage.this, "Community page is under maintenance.", Toast.LENGTH_SHORT).show();
            //to_navigate = new Intent(butterflyCollection, CommunityPage.class);
            //startActivity(to_navigate);
        }
        else if(view_id == back_button.getId())
        {
            to_navigate = new Intent(butterflyCollection, ProfilePage.class);
            startActivity(to_navigate);
        }
    }
}
