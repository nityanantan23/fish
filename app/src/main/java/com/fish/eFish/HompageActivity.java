package com.fish.eFish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.fish.eFish.camera.CameraActivity;
import com.fish.eFish.camera.ClassifierActivity;

public  class HompageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hompage);
    }

    public void opencamera(View view) {
        Intent intent = new Intent(this, ClassifierActivity.class);
        startActivity(intent);

    }

    public void openprofile(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }




}
