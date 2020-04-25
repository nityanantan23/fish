package com.fish.eFish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth auth;


    List<AuthUI.IdpConfig> providers = Arrays.asList(
            new AuthUI.IdpConfig.EmailBuilder().build(),
            new AuthUI.IdpConfig.PhoneBuilder().build());
     FirebaseAuth Auth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth= FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null) {
            Toast.makeText(getApplicationContext(),""+auth.getCurrentUser(),Toast.LENGTH_LONG).show();
            startActivity(new Intent(MainActivity.this,HompageActivity.class));

            finish();
        }
    }

    public void openRegister(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void openLogin (View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
        public void opendetails (View view) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
    }


}
