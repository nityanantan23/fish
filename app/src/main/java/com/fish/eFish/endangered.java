package com.fish.eFish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.fish.eFish.camera.ClassifierActivity;

import es.dmoral.toasty.Toasty;

import static com.fish.eFish.camera.CameraActivity.Fish_name;


public class endangered extends AppCompatActivity {
    TextView yeet;
    TextView name;
    String arr[] = Fish_name.split(" ");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endangered);
         yeet = findViewById(R.id.textView9);
         name=findViewById(R.id.textView10);
         name.setText(arr[1]);
         yeet.setText("Give it back to the sea, you can save the whole "+arr[1] +" species");

    }

    public void home(View view){
        Intent i = new Intent(getApplicationContext(), HompageActivity.class);
        startActivity(i);
        Toast.makeText(getApplicationContext(),"You have saved "+ name.getText()+" from extinction",Toast.LENGTH_SHORT).show();

    }
}
