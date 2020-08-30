package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class loding extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loding);
        Handler mHandler = new Handler();


            mHandler.postDelayed(new Runnable() {
                public void run() {

                    Intent intent = new Intent(loding.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, 3000);

        }


}