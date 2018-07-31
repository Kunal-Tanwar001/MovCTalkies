package com.example.prate.movctalkies.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.prate.movctalkies.R;
import com.example.prate.movctalkies.Viewalll.Viewall;

/**
 * A simple {@link Fragment} subclass.
 */
public class Nowshowingabove extends Fragment {
Button viewall;

    public Nowshowingabove() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View output=inflater.inflate(R.layout.fragment_nowshowingabove, container, false);
       viewall=output.findViewById(R.id.button1);
       viewall.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent inetnt=new Intent(getContext(), Viewall.class);
               startActivity(inetnt);

           }
       });

        return output;

    }

}
