package com.example.prate.movctalkies;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.prate.movctalkies.Dataclass.Crew;
import com.example.prate.movctalkies.Dataclass.Youtubepojo;
import com.example.prate.movctalkies.Dataclass.collectingmovieDetails;
import com.example.prate.movctalkies.Retrofist.RetrofistApiClient;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivitmovieDetails extends YouTubeBaseActivity implements  YouTubePlayer.OnInitializedListener {
CollapsingToolbarLayout collapsingToolbarLayout;
NestedScrollView  fullmoviedetails;
CardView wholecastdiscription1,c1;
LinearLayout wholediscription,movietitileandname,moviebuttonandtext;
ImageView toolbarimage,movielowimage;
TextView movietittle1,moviesuspense1,movieoverview1;
Button readmore;
RecyclerView cast;
String movie_url;
Youtubepojo useyoutube;
    collectingmovieDetails collect;

ArrayList<Crew> Crews=new ArrayList<>();
    YouTubePlayerView youTubePlayerView;
    YouTubePlayer youTubePlayer;

    public final static int RECOVERY_REQUEST=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitmovie_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        Intent intent=getIntent();
         movie_url=intent.getStringExtra("movie_url");




        toolbarimage=findViewById(R.id.toolbarimage);
        movielowimage=findViewById(R.id.movielowimage);
        movietittle1=findViewById(R.id.movietittle1);
        moviesuspense1=findViewById(R.id.moviesusupense1);
        movieoverview1=findViewById(R.id.movieoverview1);

//        cast=findViewById(R.id.cast);

        youTubePlayerView=findViewById(R.id.yoview);
        youTubePlayerView.initialize(Youtubeapi.YOUTUBE_API_KEY,this);

//        fetchCrews();

Call<Youtubepojo> calyoutube=RetrofistApiClient.getMovieDBService().getvideos(Integer.parseInt(movie_url));
calyoutube.enqueue(new Callback<Youtubepojo>() {
    @Override
    public void onResponse(Call<Youtubepojo> call, Response<Youtubepojo> response) {
        useyoutube=response.body();
    }

    @Override
    public void onFailure(Call<Youtubepojo> call, Throwable t) {

    }
});
        Call<collectingmovieDetails> call= RetrofistApiClient.getMovieDBService().gettingallnewmoviedetais(Integer.parseInt(movie_url),"b31070658e1781f4048fd8213d7470c4");
        call.enqueue(new Callback<collectingmovieDetails>() {
            @Override
            public void onResponse(Call<collectingmovieDetails> call, Response<collectingmovieDetails> response) {
                 collect=response.body();

            Log.d("Mainactivitmoviedetails","mydetails");
Picasso.get().load(MainActivity.imageurl+collect.myposter.poster_path).into(movielowimage);

Picasso.get().load(MainActivity.imageurl+collect.poster_path).into(toolbarimage);

                movieoverview1.setText(collect.overview);
                moviesuspense1.setText(collect.tagline);
                movietittle1.setText(collect.original_title);

            }

            @Override
            public void onFailure(Call<collectingmovieDetails> call, Throwable t) {
                Log.i("Error",t.getMessage());
            }
        });


    }

//
//    public void fetchCrews()
//    {
//        Call<CrewResponse> call=RetrofistApiClient.getMovieDBService().getCrew(movie_url) ;
//        call.enqueue(new Callback<CrewResponse>() {
//            @Override
//            public void onResponse(@NonNull Call<CrewResponse> call, @NonNull Response<CrewResponse> response) {
//                CrewResponse cl=response.body();
//                if(cl!=null) {
//                    Crews.clear();
//                    Crews.addAll(cl.getCast());
//                    crewRecyclerAdapter.notifyDataSetChanged();
//                }
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<CrewResponse> call, @NonNull Throwable t) {
//                Log.d("error", t.getMessage());
//                Toast.makeText(ActivitmovieDetails.this,"No Connection",Toast.LENGTH_LONG).show();
//            }
//        });
//    }



    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer1, boolean b) {
        if (!b) {
            if (youTubePlayer == null) {
                youTubePlayer = youTubePlayer1;
            }
            youTubePlayer.loadVideo("wb49-oV0F78");
            youTubePlayer.play();
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult errorReason) {

    }




}

