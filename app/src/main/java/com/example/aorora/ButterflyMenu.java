package com.example.aorora;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ButterflyMenu extends AppCompatActivity {


    List<Butterfly> lstButterfly ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butterfly_menu);

        lstButterfly = new ArrayList<>();
        lstButterfly.add(new Butterfly("The Vegitarian","Categorie: Common Butterfly","Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr,  sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr,  sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.",R.drawable.reg_red));
        lstButterfly.add(new Butterfly("The Wild Robot","Categorie Book","Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr,  sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr,  sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.",R.drawable.reg_red));
        lstButterfly.add(new Butterfly("Maria Semples","Categorie Book","Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr,  sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr,  sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.",R.drawable.blue));
        lstButterfly.add(new Butterfly("The Martian","Categorie Book","Description book",R.drawable.bluegreen));
        lstButterfly.add(new Butterfly("He Died with...","Categorie Book","Description book",R.drawable.brown));
        lstButterfly.add(new Butterfly("The Vegitarian","Categorie Book","Description book",R.drawable.cyan));
        lstButterfly.add(new Butterfly("The Wild Robot","Categorie Book","Description book",R.drawable.dgreen));
        lstButterfly.add(new Butterfly("Maria Semples","Categorie Book","Description book",R.drawable.orange));
        lstButterfly.add(new Butterfly("The Martian","Categorie Book","Description book",R.drawable.orangey_brown));
        lstButterfly.add(new Butterfly("He Died with...","Categorie Book","Description book",R.drawable.pink));
        lstButterfly.add(new Butterfly("The Vegitarian","Categorie Book","Description book",R.drawable.purple));
        lstButterfly.add(new Butterfly("The Wild Robot","Categorie Book","Description book",R.drawable.yellow));
        lstButterfly.add(new Butterfly("Maria Semples","Categorie Book","Description book",R.drawable.reg_red));
        lstButterfly.add(new Butterfly("The Martian","Categorie Book","Description book",R.drawable.reg_red));
        lstButterfly.add(new Butterfly("He Died with...","Categorie Book","Description book",R.drawable.reg_red));

        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerView_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,lstButterfly);
        myrv.setLayoutManager(new GridLayoutManager(this,3));
        myrv.setAdapter(myAdapter);


    }
}