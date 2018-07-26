package com.example.prate.movctalkies.Dataclass;

import com.google.gson.annotations.SerializedName;

public class Crew {


        @SerializedName("profile_path")
        private String crew_profile_path;
        @SerializedName("name")
        private String crew_name;

        public Crew()
        {

        }

        public Crew(String crew_profile_path, String crew_name) {
            this.crew_profile_path = crew_profile_path;
            this.crew_name = crew_name;
        }

        public String getCrew_profile_path() {
            return crew_profile_path;
        }

        public void setCrew_profile_path(String crew_profile_path) {
            this.crew_profile_path = crew_profile_path;
        }

        public String getCrew_name() {
            return crew_name;
        }

        public void setCrew_name(String crew_name) {
            this.crew_name = crew_name;
        }
    }


