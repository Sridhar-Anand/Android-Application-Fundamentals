package com.example.lifecycyletoast;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;


public class secondActivity extends AppCompatActivity {

    CheckBox checkBox;
    RadioGroup radioGroup;
    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button btn= findViewById(R.id.btn4);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToThirdActivity();
                Toast.makeText(secondActivity.this, "Explicit Intent is called", Toast.LENGTH_SHORT).show();
            }
        });

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
//Below set of codes will give a toast message if either of a radio button is selected
        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                Toast.makeText(secondActivity.this, radioButton.getText().toString()+" is called", Toast.LENGTH_SHORT).show();
            }
        });
//        Below set of codes will create a list of spinner to opt out

//        View
        spinner = findViewById(R.id.spinner);

//        DATA Source
        String[] spinnerArray = {"SpinItem1","SpinItem2","SpinItem3"};


//        An array adapter is a class that acts as a bridge between an array or a list of data and the list of new grid view spinner or other similar UI widgets.
//        These Array adapters are commonly used to populate these widgets with data and display them to the user.
//        This will take care of converting each item in the data source into a corresponding view that can be displayed within the UI
//        Array Adapter :used to populate th e'Spinner' with items from a string array resource

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,spinnerArray);
//        Importantly: These Array Adapter is acting as a bridge between DATA Source and the View

//  Apply the adapter to the spinner
        spinner.setAdapter(adapter);






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

    public void goToThirdActivity(){
        Intent secondToThird = new Intent(this, thirdActivity.class);
        startActivity(secondToThird);
    }
}