package com.example.lifecycyletoast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.TimePicker;
import android.widget.Toast;

public class thirdActivity extends AppCompatActivity {

    TimePicker timePicker;
    DatePicker  datePicker;
    Button buttonProgress;
    ProgressBar progressBar;

    Button audioBtn;

    int progressCompletion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
         timePicker= findViewById(R.id.timePicker);

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int hourOfDay, int minute) {
                //Handle Time Change
                Toast.makeText(thirdActivity.this, "Hour" + hourOfDay +" : Minute "+ minute, Toast.LENGTH_SHORT).show();

            }
        });

        datePicker = findViewById(R.id.datePicker);
        datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                Toast.makeText(thirdActivity.this, "day: " + i2+" ; Month: "+ (i1 +1)+" year: " +i, Toast.LENGTH_SHORT).show();
            }
        });



        progressBar = findViewById(R.id.progressBar);
        buttonProgress = findViewById(R.id.btnProgressBar);


        buttonProgress.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                progressCompletion = progressCompletion + 10;

                if(progressCompletion>100){
                    progressCompletion=0;
                }
                progressBar.setProgress(progressCompletion);
            }
        });

        audioBtn = findViewById(R.id.audioBtn);
        audioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToAudioActivity();
                Toast.makeText(thirdActivity.this, "AudioActivity Called", Toast.LENGTH_SHORT).show();
            }
        });





        


    }
    public void goToAudioActivity(){
        Intent thirdToAudio= new Intent(this, audioActivity.class);
        startActivity(thirdToAudio);
    }
}