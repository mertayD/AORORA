package com.example.aorora;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

public class CommunityPage extends AppCompatActivity {

    private com.example.aorora.adapter.CustomAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_page);

        progressDoalog = new ProgressDialog(CommunityPage.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

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

}
