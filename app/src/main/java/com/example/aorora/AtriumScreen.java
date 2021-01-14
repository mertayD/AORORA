package com.example.aorora;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.aorora.adapter.AtriumAdapter;

public class AtriumScreen extends AppCompatActivity {
    private RecyclerView atriumRecycler;
    RecyclerView.LayoutManager layoutManager;
    AtriumAdapter atriumAdapter;
    int images[] = {R.drawable.red_butterfly_button, R.drawable.yellow_butterfly_button,
            R.drawable.orange_butterfly_button, R.drawable.green_butterfly_button,
            R.drawable.darkorange_butterfly_button};

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atrium);
        //Grab the recyclerview
        atriumRecycler = findViewById(R.id.atriumRecycler);
        atriumRecycler.setAdapter(new AtriumAdapter(this, images));
        layoutManager = new GridLayoutManager(this, 3);
        atriumRecycler.setLayoutManager(layoutManager);
        atriumRecycler.setHasFixedSize(true);


    }
}
