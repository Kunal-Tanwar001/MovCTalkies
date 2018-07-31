package com.example.prate.movctalkies.Retrofist;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;





public class RetrofistApiClient {



        private static Retrofit retrofit;
        private static MovieDBService service;



        public static Retrofit getInstance()
        {
            if(retrofit == null)
            {
                Retrofit.Builder builder = new Retrofit.Builder()
                        .baseUrl("https://api.themoviedb.org/3/movie/")
                        .addConverterFactory(GsonConverterFactory.create());

                retrofit = builder.build();
            }
            return retrofit;
        }

        public static MovieDBService getMovieDBService()
        {
            if(service == null)
            {
                service = getInstance().create(MovieDBService.class);
            }
            return service;
        }



}
