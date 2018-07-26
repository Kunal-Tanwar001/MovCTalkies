package com.example.prate.movctalkies.Viewalll;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.prate.movctalkies.Dataclass.Result;
import com.example.prate.movctalkies.Fragments.MovieClickListner;
import com.example.prate.movctalkies.MovieAdapter.MovieMainactivityAdapter;
import com.example.prate.movctalkies.MovieAdapter.Viewalladapter;
import com.example.prate.movctalkies.R;

import java.util.ArrayList;

public class Viewall extends AppCompatActivity {
RecyclerView recyclerViewmovies;
Viewalladapter viewalladapter;
    ArrayList<Result> mymovieresults=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewall);
        Intent intent=getIntent();

        recyclerViewmovies=findViewById(R.id.recyclerviewofnowplaying);






    }
}
