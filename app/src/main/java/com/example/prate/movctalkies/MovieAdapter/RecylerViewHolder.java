package com.example.prate.movctalkies.MovieAdapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.prate.movctalkies.R;

public class RecylerViewHolder extends RecyclerView.ViewHolder{

 ImageView moviewimage;
 TextView moviename,movieoverview,ratings;
View itemView;

    public RecylerViewHolder(View itemView) {
        super(itemView);
        this.itemView=itemView;

         this.ratings=itemView.findViewById(R.id.ratings);
       this.moviewimage=itemView.findViewById(R.id.moviewimage);
       this.moviename=itemView.findViewById(R.id.moviename);
       this.movieoverview=itemView.findViewById(R.id.movieoverview);

    }





}
