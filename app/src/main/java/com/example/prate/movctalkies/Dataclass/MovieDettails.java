package com.example.prate.movctalkies.Dataclass;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MovieDettails {
    @SerializedName("results")
   private ArrayList<Result> gettingresults=new ArrayList<>();

    public ArrayList<Result> getGettingresults() {
        return gettingresults;
    }

    public void setGettingresults(ArrayList<Result> gettingresults) {
        this.gettingresults = gettingresults;
    }
}
