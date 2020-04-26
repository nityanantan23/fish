package com.fish.eFish;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class History extends AppCompatActivity {

    String s1[], s2[],s3[];
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        s1= getResources().getStringArray(R.array.name);
        s2= getResources().getStringArray(R.array.price);
        s3= getResources().getStringArray(R.array.quantity);


//        ArrayList<String> numbersList = (ArrayList<String>) getIntent().getSerializableExtra("key");
//        textView.setText(String.valueOf(numbersList));
//
//        ArrayList<String> numbersList = (ArrayList<String>) getIntent().getSerializableExtra("key");
//        textView.setText(String.valueOf(numbersList));
//
//        ArrayList<String> numbersList = (ArrayList<String>) getIntent().getSerializableExtra("key");
//        textView.setText(String.valueOf(numbersList));


        recyclerView = findViewById(R.id.recyclerView);

        MyAdapter myAdapter = new MyAdapter(this,s1,s2,s3);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }


}
