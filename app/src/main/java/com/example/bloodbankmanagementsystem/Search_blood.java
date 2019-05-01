package com.example.bloodbankmanagementsystem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import Adapter.DetailsAdapter;
import Model.Details;

public class Search_blood extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_blood);

        recyclerView=findViewById(R.id.recyclerview);

        //create list of details
        List<Details> detailsList = new ArrayList<>();
        detailsList.add(new Details(R.drawable.noavatar,"Samit Bhattarai","9844687013","bhattarai905@gmail.com","Maitidevi","Male","O+ve"));

        DetailsAdapter detailsAdapter=new DetailsAdapter(this,detailsList);
        recyclerView.setAdapter(detailsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}

