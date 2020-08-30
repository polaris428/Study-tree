package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fm=getSupportFragmentManager();
    private plant plant=new plant();
    private timeckack timeckack=new timeckack();
    private wisesaying wisesaying=new wisesaying();
    private Fragment fa, fb, fc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView=(BottomNavigationView)findViewById(R.id.bottomNavigationView);
        FragmentTransaction transaction=fm.beginTransaction();
        transaction.replace(R.id.framlayout,wisesaying).commitAllowingStateLoss();
        fa = new wisesaying();
        fm.beginTransaction().replace(R.id.framlayout,fa).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.first:{
                            fa = new wisesaying();
                            fm.beginTransaction().add(R.id.framlayout, fa).commit();


                        break;
                    }
                    case R.id.second:{
                        if(fb == null) {
                            fb = new timeckack();
                            fm.beginTransaction().add(R.id.framlayout, fb).commit();
                        }
                        if(fa != null) fm.beginTransaction().hide(fa).commit();
                        if(fb != null) fm.beginTransaction().show(fb).commit();
                        if(fc != null) fm.beginTransaction().hide(fc).commit();

                        break;
                    }
                    case R.id.third:{

                            fc = new plant();
                            fm.beginTransaction().add(R.id.framlayout, fc).commit();



                    }
                        break;
                    }





                return true;
            }
        });}
}