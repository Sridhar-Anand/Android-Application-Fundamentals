package com.example.lifecycyletoast;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class secondActivity extends AppCompatActivity {

    CheckBox checkBox;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        checkBox = findViewById(R.id.check_box);
//  In order to listen the click event to the checkbox the below code is executed
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(secondActivity.this, "CheckBox is checked", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(secondActivity.this, "Unchecked the CheckBox", Toast.LENGTH_SHORT).show();
                }
            }
        });

        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                Toast.makeText(secondActivity.this, radioButton.getText().toString()+" is called", Toast.LENGTH_SHORT).show();
            }
        });
        //Below is an example of implicit intent where the switch is between this (current) application
        // and other outer applications available in the system

        Button youtube = findViewById(R.id.btn2);
        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openYoutube();
                }
            });

        Button google = findViewById(R.id.btn3);
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openwebPage();
            }
        });
        }
    public void openYoutube(){
        Uri webPage = Uri.parse("https://www.youtube.com");
        Intent mainToYoutube = new Intent(Intent.ACTION_VIEW,webPage);
        //Intent.ACTION_VIEW - This Action View is a pre-defined constant used as an action in the intet class,
        // its typically used to indicate that you want to view the content specified by the Uri. Like when you create the intent
        // with the action, view action and provide an Uri, the system will try to find an appropriate component to handle the action, such
        // as opening a webpage, or display an image or playing a video.

        //In this example the system will try to open a webpage or youtube application if available within the system automatically
        Toast.makeText(this, "Implicit Intent1 is Called", Toast.LENGTH_LONG).show();
        startActivity(mainToYoutube);


    }
    public void openwebPage(){
        Uri web = Uri.parse("https://www.google.com");
        Intent Google  = new Intent(Intent.ACTION_VIEW,web);
        Toast.makeText(this, "Implicit Intent2 is Called", Toast.LENGTH_LONG).show();
        startActivity(Google);
    }
}