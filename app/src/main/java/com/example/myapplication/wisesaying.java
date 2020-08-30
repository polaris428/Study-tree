package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;


public class wisesaying extends Fragment {



    String a;
    public wisesaying() {
        // Required empty public constructor
    }

    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = LayoutInflater.from(getContext()).inflate(R.layout.fragment_wisesaying, null);
        int max_num_value = 7;
        int min_num_value = 0;

        Random random = new Random();

        int randomNum = random.nextInt(max_num_value - min_num_value + 1) + min_num_value;

        TextView wise=(TextView) v.findViewById(R.id.wise);

        wise.setText(getText(R.string.a+randomNum));

        return v;

    }
}