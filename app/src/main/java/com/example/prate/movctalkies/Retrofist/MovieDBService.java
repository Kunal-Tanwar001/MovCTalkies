package com.example.prate.movctalkies.Retrofist;

import com.example.prate.movctalkies.Dataclass.CrewResponse;
import com.example.prate.movctalkies.Dataclass.MovieDettails;
import com.example.prate.movctalkies.Dataclass.Result;
import com.example.prate.movctalkies.Dataclass.collectingmovieDetails;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieDBService {
    @GET("now_playing")
    Call<MovieDettails> getNowPlayingResponse(@Query("api_key") String apikey, @Query("page") String page);
//
//    @GET("popular")
//    Call<MovieDettails> getPopularResponse(@Query("api_key") String apikey);
//
//
//    @GET("top_rated")
//    Call<MovieDettails> getTopRatedResponse(@Query("api_key") String apikey,@Query("l")String language ,@Query("page") int page);
//
//    @GET("upcoming")
//    Call<MovieDettails> getUpcomingResponse(@Query("api_key") String apikey);

    @GET("{movie_id}")
    Call<collectingmovieDetails>  gettingallnewmoviedetais(@Path("movie_id")String movieid,@Query("api_key")String apikey);

    @GET("{MOVIE_ID}/credits?api_key=80379bfe5c660b84e1888e3de33db3bb")
    Call<CrewResponse> getCrew(@Path("MOVIE_ID") String MOVIE_ID);


}
