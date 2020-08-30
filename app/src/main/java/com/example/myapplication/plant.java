package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class plant extends timeckack {

    public ImageView plantimage;

    public plant() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.fragment_plant, null);

       plantimage=v.findViewById(R.id.plantimage);
        if(hour>2&&hour<4){
           plantimage.setImageResource(R.drawable.plant2);
        }
        else if(hour>=4&&hour<6){
            plantimage.setImageResource(R.drawable.plant3);
        }
        else if(hour>=6&&hour<8){
            plantimage.setImageResource(R.drawable.plant4);
        }
        else if(hour>=8){
            plantimage.setImageResource(R.drawable.plant5);
        }

        return v;
    }

}