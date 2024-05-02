package com.example.lifecycyletoast;

import static com.example.lifecycyletoast.R.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    //OnCreate Method - first method when activity is started
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        Toast.makeText(this, "On Create is called", Toast.LENGTH_SHORT).show();


        Button btn = findViewById(id.btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //On Clicking the button, it should show the second activity
                  goToSecondActivity();
                Toast.makeText(MainActivity.this, "Explicit Intent is called", Toast.LENGTH_LONG).show();
            }
        });

    }

    //Intents: These facilitates communication between different components of an app, as well as between different applications.

    //Two types of intents, Explicit intents, Implicit Intents

    //Below is an example of Explicit intent as it switch within the app between the activities
    public void goToSecondActivity(){
        Intent mainToSecondIntent = new Intent(this, secondActivity.class);
        startActivity(mainToSecondIntent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "On Start is called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "On Resume is called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "On Pause is called", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "On Restart is called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "On Stop is called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "On Destroy is called", Toast.LENGTH_SHORT).show();

    }
//Below line inflates menu.xml layout to mainactivity  dynamically to show its item contents
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

// Below lines access and adds functionalities to the created menu items
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int itemId = item.getItemId();
        if (itemId == id.action_home){
            Toast.makeText(this, "Home Item is called", Toast.LENGTH_SHORT).show();
        } else if (itemId == id.action_search) {
            Toast.makeText(this, "Search Item is called", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}