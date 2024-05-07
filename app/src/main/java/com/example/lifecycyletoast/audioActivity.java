package com.example.lifecycyletoast;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class audioActivity extends AppCompatActivity {


    Button classic,meteor, himalayan, interceptor, super_meteor, conti_gt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);


        classic = findViewById(R.id.classicBtn);
        meteor = findViewById(R.id.meteorBtn);
        himalayan = findViewById(R.id.himalayanBtn);
        interceptor= findViewById(R.id.interceptorBtn);
        super_meteor = findViewById(R.id.superMeteorBtn);
        conti_gt = findViewById(R.id.contiBtn);


        classic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                MediaPlayer media = new MediaPlayer();
                MediaPlayer media= MediaPlayer.create(
                        getApplicationContext(),
                        R.raw.classic);

                media.start();
            }
        });
    }


}