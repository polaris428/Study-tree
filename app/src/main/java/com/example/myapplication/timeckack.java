package com.example.myapplication;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import java.util.Random;


public class timeckack extends Fragment{
    public Chronometer chronometer;
    public long pauseOffset;
    private boolean running;

    public static  long totlatime;
    public static long  previoustotlatime1,hour,min,second;




    public timeckack() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.fragment_timechack, null);
        TextView massge=(TextView)v.findViewById(R.id.massge);
        Button startChronometer=(Button) v.findViewById(R.id.startChronometer);
        Button pauseChronometer=(Button) v.findViewById(R.id.pauseChronometer);
        Button resetChronometer=(Button)v.findViewById(R.id.resetChronometer);
        final TextView total=(TextView)v.findViewById(R.id.total);
        chronometer = v.findViewById(R.id.chronometer);
        chronometer.setFormat("공부시간 : %s");
        chronometer.setBase(SystemClock.elapsedRealtime());
        int max_num_value = 7;
        int min_num_value = 0;
        Random random = new Random();
        int randomNum = random.nextInt(max_num_value - min_num_value + 1) + min_num_value;
        massge.setText(R.string.b1+randomNum);

        startChronometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!running){
                    chronometer.setBase(SystemClock.elapsedRealtime()-pauseOffset);
                    chronometer.start();
                    running = true;
                }
            }
        });
        pauseChronometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (running) {
                    chronometer.stop();
                    pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
                    totlatime=(SystemClock.elapsedRealtime()-chronometer.getBase())/1000+previoustotlatime1;
                    second=totlatime;
                    hour = second/3600;
                    second %= 3600;
                    min = second/60;
                    second %= 60;

                    total.setText(""+hour+"시"+min+"분"+second+"초");
                    running = false;
                }
            }
        });
        resetChronometer.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View view) {

                previoustotlatime1=totlatime;
                chronometer.setBase(SystemClock.elapsedRealtime());
                pauseOffset = 0;

            }
        });

        return v;

    }


}