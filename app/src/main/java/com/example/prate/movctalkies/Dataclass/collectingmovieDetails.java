package com.example.prate.movctalkies.Dataclass;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class collectingmovieDetails {

   @SerializedName("belongs_to_collection")
  public ArrayList<poster>myposter=new ArrayList<>();
   @SerializedName("original_title")
  public String original_title;
   @SerializedName("overview")
  public String overview;
   @SerializedName("release_date")
    public String release_date;
   @SerializedName("runtime")
    public int runtime;
   @SerializedName("tagline")
    public String tagline;
   @SerializedName("poster_path")
    public String poster_path;

    @SerializedName("vote_average")
    public   String ratings;
}

