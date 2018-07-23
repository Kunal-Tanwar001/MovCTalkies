package com.example.prate.movctalkies.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.prate.movctalkies.Dataclass.MovieDettails;
import com.example.prate.movctalkies.Dataclass.Result;
import com.example.prate.movctalkies.MovieAdapter.MovieMainactivityAdapter;
import com.example.prate.movctalkies.R;
import com.example.prate.movctalkies.Retrofist.RetrofistApiClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class NowShowing extends Fragment {
OnItemClick listner;
ArrayList<Result> myresults=new ArrayList<>() ;

    public NowShowing() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        {
            View output = inflater.inflate(R.layout.fragment_now_showing, container, false);
            RecyclerView recyclerView = output.findViewById(R.id.recyclerviewofnowplaying);
            final MovieMainactivityAdapter adapter = new MovieMainactivityAdapter(output.getContext(), myresults, new MovieClickListner() {
                @Override
                public void onpostClciked(View view, int position) {


                }
            });
            recyclerView.setAdapter(adapter);


            recyclerView.setItemAnimator(new DefaultItemAnimator());

            LinearLayoutManager layoutManager = new LinearLayoutManager(output.getContext(), LinearLayout.HORIZONTAL, false);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.addItemDecoration(new DividerItemDecoration(output.getContext(), DividerItemDecoration.VERTICAL));
            recyclerView.setItemAnimator(new DefaultItemAnimator());

           
            Call<MovieDettails> call = RetrofistApiClient.getMovieDBService().getNowPlayingResponse("80379bfe5c660b84e1888e3de33db3bb", 1);
            call.enqueue(new Callback<MovieDettails>() {
                @Override
                public void onResponse(Call<MovieDettails> call, Response<MovieDettails> response) {
                    MovieDettails movieDettails=response.body();
                    ArrayList<Result> xy=movieDettails.getGettingresults();


                    for(int i=0;i<xy.size();i++){
                        myresults.add(xy.get(i));
                    }
                    Log.d("nowplaying","have reachead");
                    adapter.notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call<MovieDettails> call, Throwable t) {
                    Toast.makeText(getContext(),"No Connection",Toast.LENGTH_LONG).show();
                }
            });

            // Inflate the layout for this fragment
            return output;
        }

    }
}
