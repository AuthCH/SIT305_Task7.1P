package com.example.lostfoundapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.CharacterPickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Add extends AppCompatActivity {

    //Declare variables
    EditText nameinput, iteminput, locationinput;
    String status = "";
    private RadioGroup radioGroup;
    RadioButton radioButton;

    Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        //Match IDs
        nameinput = findViewById(R.id.name);
        iteminput = findViewById(R.id.item);
        locationinput = findViewById(R.id.location);
        add = findViewById(R.id.addbtn);
        radioGroup = findViewById(R.id.radioGroup);
        //Set on click to radio button
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.found:
                        status = "Found";
                        break;
                    case R.id.lost:
                        status = "Lost";
                        break;
                }
            }
        });

        //Set on click to add button
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Add data to database
                MyDatabase myDatabase = new MyDatabase(Add.this);
                myDatabase.additem(status.trim(),
                        nameinput.getText().toString().trim(),
                        iteminput.getText().toString().trim(),
                        locationinput.getText().toString().trim());
            }
        });


    }

}