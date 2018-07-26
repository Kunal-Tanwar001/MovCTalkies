package com.example.prate.movctalkies;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prate.movctalkies.Dataclass.Crew;
import com.example.prate.movctalkies.Dataclass.CrewResponse;
import com.example.prate.movctalkies.Dataclass.collectingmovieDetails;
import com.example.prate.movctalkies.Dataclass.poster;
import com.example.prate.movctalkies.MovieAdapter.CrewRecyclerAdapter;
import com.example.prate.movctalkies.Retrofist.RetrofistApiClient;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivitmovieDetails extends AppCompatActivity {
CollapsingToolbarLayout collapsingToolbarLayout;
NestedScrollView  fullmoviedetails;
CardView wholecastdiscription1,c1;
LinearLayout wholediscription,movietitileandname,moviebuttonandtext;
ImageView toolbarimage,movielowimage;
TextView movietittle1,moviesuspense1,movieoverview1;
Button readmore;
RecyclerView cast;
String movie_url;
    CrewRecyclerAdapter crewRecyclerAdapter;
ArrayList<Crew> Crews=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitmovie_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

 movie_url=353081+"";



        toolbarimage=findViewById(R.id.toolbarimage);
        movielowimage=findViewById(R.id.movielowimage);
        movietittle1=findViewById(R.id.movietittle1);
        moviesuspense1=findViewById(R.id.moviesusupense1);
        movieoverview1=findViewById(R.id.movieoverview1);
        readmore=findViewById(R.id.readmore);
        cast=findViewById(R.id.cast);


        Call<collectingmovieDetails> call= RetrofistApiClient.getMovieDBService().gettingallnewmoviedetais(movie_url,"b31070658e1781f4048fd8213d7470c4");
        call.enqueue(new Callback<collectingmovieDetails>() {
            @Override
            public void onResponse(Call<collectingmovieDetails> call, Response<collectingmovieDetails> response) {
                collectingmovieDetails collect=response.body();


Picasso.get().load(MainActivity.imageurl+collect.myposter.get(0).poster_path).into(movielowimage);

Picasso.get().load(MainActivity.imageurl+collect.poster_path).into(toolbarimage);

                movieoverview1.setText(collect.overview);
                moviesuspense1.setText(collect.tagline);
                moviesuspense1.setText(collect.original_title);
                Toast.makeText(ActivitmovieDetails.this,"nhi chaala",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<collectingmovieDetails> call, Throwable t) {

            }
        });
        readmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
         crewRecyclerAdapter=new CrewRecyclerAdapter(Crews,this);
fetchCrews();
    }


    public void fetchCrews()
    {
        Call<CrewResponse> call=RetrofistApiClient.getMovieDBService().getCrew(movie_url) ;
        call.enqueue(new Callback<CrewResponse>() {
            @Override
            public void onResponse(@NonNull Call<CrewResponse> call, @NonNull Response<CrewResponse> response) {
                CrewResponse cl=response.body();
                if(cl!=null) {
                    Crews.clear();
                    Crews.addAll(cl.getCast());
                    crewRecyclerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(@NonNull Call<CrewResponse> call, @NonNull Throwable t) {
                Log.d("error", t.getMessage());
                Toast.makeText(ActivitmovieDetails.this,"No Connection",Toast.LENGTH_LONG).show();
            }
        });
    }




}
