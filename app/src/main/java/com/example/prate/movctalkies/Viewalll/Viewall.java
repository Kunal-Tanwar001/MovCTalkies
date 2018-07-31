package com.example.prate.movctalkies.Viewalll;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.prate.movctalkies.ActivitmovieDetails;
import com.example.prate.movctalkies.Dataclass.MovieDettails;
import com.example.prate.movctalkies.Dataclass.Result;
import com.example.prate.movctalkies.Dataclass.Resultnow;
import com.example.prate.movctalkies.Fragments.MovieClickListner;
import com.example.prate.movctalkies.MovieAdapter.MovieMainactivityAdapter;
import com.example.prate.movctalkies.R;
import com.example.prate.movctalkies.Retrofist.RetrofistApiClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Viewall extends AppCompatActivity {
    ArrayList<Resultnow> myresults=new ArrayList<>() ;
    MovieMainactivityAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewall);
        Intent intent=getIntent();
        RecyclerView recyclerView = findViewById(R.id.r1);
        adapter = new MovieMainactivityAdapter(this, myresults, new MovieClickListner() {
            @Override
            public void onpostClciked(View view, int position) {
                Long id=myresults.get(position).getId();
                String movie_url=id+"";
                Intent intent=new Intent(view.getContext(), ActivitmovieDetails.class);
                intent.putExtra("movie_url",movie_url);
                startActivity(intent);

            }
        });



        recyclerView.setItemAnimator(new DefaultItemAnimator());

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(adapter);
        fetch();


    }
    public void fetch(){

        Call<MovieDettails> call = RetrofistApiClient.getMovieDBService().getNowPlayingResponse("80379bfe5c660b84e1888e3de33db3bb", 1+"");
        Log.d("no1",call.toString());
        call.enqueue(new Callback<MovieDettails>() {
            @Override
            public void onResponse(Call<MovieDettails> call, Response<MovieDettails> response) {
                MovieDettails movieDettails=response.body();
                ArrayList<Resultnow> xy=movieDettails.getGettingresults();


                for(int i=0;i<xy.size();i++){
                    myresults.add(xy.get(i));
                }
                if(myresults!=null){

                    Toast.makeText(Viewall.this,myresults.get(0).getOriginalTitle(),Toast.LENGTH_LONG).show();
                }

                Log.d("nowplaying","have reachead");
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<MovieDettails> call, Throwable t) {
                Toast.makeText(Viewall.this,"No Connection",Toast.LENGTH_LONG).show();
            }
        });

    }
}
