package com.fish.eFish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseUser user;
    TextView ProfileEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        auth= FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        ProfileEmail =(TextView)findViewById(R.id.textView);

        ProfileEmail.setText(user.getEmail());


    }

    public void signOut(View view){
        auth.signOut();
        finish();
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
    public void openprofile(View view){
        auth.signOut();
        finish();
        Intent i = new Intent(this,ProfileActivity.class);
        startActivity(i);
    }
}
