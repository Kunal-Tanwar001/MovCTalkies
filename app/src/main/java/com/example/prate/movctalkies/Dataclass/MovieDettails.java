package com.example.prate.movctalkies.Dataclass;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MovieDettails {
    @SerializedName("results")
   private ArrayList<Resultnow> gettingresults=new ArrayList<>();

    public ArrayList<Resultnow> getGettingresults() {
        return gettingresults;
    }

    public void setGettingresults(ArrayList<Resultnow> gettingresults) {
        this.gettingresults = gettingresults;
    }
}
