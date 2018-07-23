package com.example.prate.movctalkies.Retrofist;

import com.example.prate.movctalkies.Dataclass.MovieDettails;
import com.example.prate.movctalkies.Dataclass.Result;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieDBService {

    @GET("now_playing")
    Call<MovieDettails> getNowPlayingResponse(@Query("api_key") String apikey, @Query("page") int page);

    @GET("popular")
    Call<MovieDettails> getPopularResponse(@Query("api_key") String apikey);


    @GET("top_rated")
    Call<MovieDettails> getTopRatedResponse(@Query("api_key") String apikey);

    @GET("upcoming")
    Call<MovieDettails> getUpcomingResponse(@Query("api_key") String apikey);

}
