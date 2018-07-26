package com.example.prate.movctalkies.Dataclass;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CrewResponse {




        private ArrayList<Crew> cast;

        public ArrayList<Crew> getCast() {
            return cast;
        }

        public void setCast(ArrayList<Crew> results) {
            this.cast = results;
        }
    }


