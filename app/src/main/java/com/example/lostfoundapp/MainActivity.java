package com.example.lostfoundapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //Declare variables
    Button add,list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Match IDs
        add = findViewById(R.id.add);
        list = findViewById(R.id.list);

        //set on click to add button
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Go to Add page
                Intent intent = new Intent(MainActivity.this,Add.class);
                startActivity(intent);
            }
        });
        //set on click to list button
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Go to List page
                Intent intent = new Intent(MainActivity.this,List.class);
                startActivity(intent);
            }
        });

    }
}