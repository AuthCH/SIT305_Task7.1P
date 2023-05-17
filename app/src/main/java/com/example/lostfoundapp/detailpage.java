package com.example.lostfoundapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class detailpage extends AppCompatActivity {
    TextView textstatus,textitem,textname,textlocation;
    String id,status,name,item,location;
    Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailpage);

        textstatus = findViewById(R.id.textstatus);
        textitem = findViewById(R.id.textitem);
        textname = findViewById(R.id.textname);
        textlocation = findViewById(R.id.textlocation);
        delete = findViewById(R.id.removebtn);
        getandsetData();

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabase myDatabase = new MyDatabase(detailpage.this);
                myDatabase.delete(id);
                finish();
            }
        });

    }
    void getandsetData(){

        if(getIntent().hasExtra("id") && getIntent().hasExtra("status") &&
                getIntent().hasExtra("name") && getIntent().hasExtra("item") &&
                getIntent().hasExtra("location"))   {

            id = getIntent().getStringExtra("id");
            status = getIntent().getStringExtra("status");
            name = getIntent().getStringExtra("name");
            item = getIntent().getStringExtra("item");
            location = getIntent().getStringExtra("location");

            textstatus.setText(status);
            textitem.setText(item);
            textname.setText(name);
            textlocation.setText(location);

        }
        else {
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }

    }
}