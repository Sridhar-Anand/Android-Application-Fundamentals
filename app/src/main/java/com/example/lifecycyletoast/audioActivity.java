
package com.example.lifecycyletoast;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class audioActivity extends AppCompatActivity implements View.OnClickListener{


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


        classic.setOnClickListener(this);
        meteor.setOnClickListener(this);
        himalayan.setOnClickListener(this);
        interceptor.setOnClickListener(this);
        super_meteor.setOnClickListener(this);
        conti_gt.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        int clickedBtnId = view.getId();

        if (clickedBtnId == R.id.classicBtn){
            PlaySounds(R.raw.classic);}
        else if (clickedBtnId == R.id.meteorBtn){
            PlaySounds(R.raw.meteor);}
        else if (clickedBtnId == R.id.himalayanBtn){
            PlaySounds(R.raw.himalayan);}
        else if (clickedBtnId == R.id.interceptorBtn){
            PlaySounds(R.raw.interceptor);}
        else if (clickedBtnId == R.id.superMeteorBtn){
            PlaySounds(R.raw.super_meteor);}
        else if (clickedBtnId == R.id.contiBtn){
            PlaySounds(R.raw.continental_gt);}
        }

    public void PlaySounds(int id){
        MediaPlayer mediaPlayer = MediaPlayer.create(this, id);
        mediaPlayer.start();
    }
}