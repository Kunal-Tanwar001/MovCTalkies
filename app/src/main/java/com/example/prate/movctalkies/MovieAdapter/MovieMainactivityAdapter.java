package com.example.prate.movctalkies.MovieAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.prate.movctalkies.Dataclass.Result;
import com.example.prate.movctalkies.Fragments.MovieClickListner;
import com.example.prate.movctalkies.MainActivity;
import com.example.prate.movctalkies.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MovieMainactivityAdapter extends RecyclerView.Adapter<RecylerViewHolder>  {

    Context context;
    ArrayList<Result> myresults;
    MovieClickListner movieClickListner;

    public MovieMainactivityAdapter(Context context, ArrayList<Result> myresults, MovieClickListner movieClickListner) {
        this.context=context;
        this.movieClickListner=movieClickListner;
        this.myresults=myresults;
    }

    @NonNull
    @Override
    public RecylerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowLayout = inflater.inflate(R.layout.movieadapter,parent,false);
        return new RecylerViewHolder(rowLayout);

    }

    @Override
    public void onBindViewHolder(@NonNull RecylerViewHolder holder, final int position) {

      Result result=myresults.get(position);
      holder.moviename.setText(result.getOriginalTitle());
      holder.movieoverview.setText(result.getOverview());
        Picasso.get().load(MainActivity.imageurl+result.getPosterPath()).into(holder.moviewimage);
        Log.d("adapter","photoottt0");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movieClickListner.onpostClciked(v,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myresults.size();
    }


}
