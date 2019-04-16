package com.example.aorora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aorora.model.Butterfly;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BackendTest extends AppCompatActivity {

    Button makeCall;
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backend_test);

        makeCall = (Button) findViewById(R.id.backend_make_call_button);
        output = (TextView) findViewById(R.id.data_output_backend);

        makeCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.example.aorora.network.GetDataService service = com.example.aorora.network.RetrofitClientInstance.getRetrofitInstance().create(com.example.aorora.network.GetDataService.class);

                Call<List<Butterfly>> call = service.getButterflyInfo();
                call.enqueue(new Callback<List<Butterfly>>() {

                    @Override
                    public void onResponse(Call<List<com.example.aorora.model.Butterfly>> call, Response<List<Butterfly>> response) {
                        output.append("Butterfly ID: " + response.body().get(0).getButterflyId() + "\n");
                        output.append("Butterfly Created At: " + response.body().get(0).getButterflyCreatedAt());
                    }

                    @Override
                    public void onFailure(Call<List<com.example.aorora.model.Butterfly>> call, Throwable t) {
                        Toast.makeText(BackendTest.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}

/*

    Code to get details of butterfly
     com.example.aorora.network.GetDataService service = com.example.aorora.network.RetrofitClientInstance.getRetrofitInstance().create(com.example.aorora.network.GetDataService.class);

                Call<List<Butterfly>> call = service.getButterflyInfo();
                call.enqueue(new Callback<List<Butterfly>>() {

                    @Override
                    public void onResponse(Call<List<com.example.aorora.model.Butterfly>> call, Response<List<Butterfly>> response) {
                        output.append("Butterfly ID: " + response.body().get(0).getButterflyId() + "\n");
                        output.append("Butterfly Created At: " + response.body().get(0).getButterflyCreatedAt());
                    }

                    @Override
                    public void onFailure(Call<List<com.example.aorora.model.Butterfly>> call, Throwable t) {
                        Toast.makeText(BackendTest.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                    }
                });
 */