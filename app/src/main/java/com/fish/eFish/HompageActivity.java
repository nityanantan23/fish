package com.fish.eFish;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.fish.eFish.camera.CameraActivity;
import com.fish.eFish.camera.ClassifierActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.Objects;

import es.dmoral.toasty.Toasty;

import static com.fish.eFish.camera.CameraActivity.Fish_name;

public  class HompageActivity extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
//    SharedPreferences sharedPreferences = getSharedPreferences("ok", MODE_PRIVATE);
//    SharedPreferences.Editor editor = sharedPreferences.edit();
//    String name = sharedPreferences.getString("ID", "");
    FirebaseUser user;
    FirebaseAuth auth;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hompage);
        auth= FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        System.out.println(user.getEmail());

//        SharedPreferences.Editor mEditor = sharedPreferences.edit();
//        mEditor.putString("ID",email);
//        mEditor.apply();


    }

    public void opencamera(View view) {


//        SharedPreferences sharedPreferences = getSharedPreferences("ok", MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//
//        String name = sharedPreferences.getString("ID", "");



        db.collection("Fish").document(user.getEmail()).addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                String Seller_name = documentSnapshot.getString("Seller_name");
                String Seller_address = documentSnapshot.getString("Seller_address");
                String phone_number = documentSnapshot.getString("phone_number");

                if (Objects.requireNonNull(documentSnapshot.getData()).isEmpty()){
                    Intent i = new Intent(getApplicationContext(), ProfileActivity.class);
                    startActivity(i);
                    Toasty.info(getApplicationContext(), "Profile need to be updated", Toasty.LENGTH_SHORT).show();


                } else {
                    if (Seller_address.isEmpty() || Seller_name.isEmpty() || phone_number.isEmpty()) {
                        Intent i = new Intent(getApplicationContext(), ProfileActivity.class);
                        startActivity(i);


                        Toasty.info(getApplicationContext(), "Profile need to be updated", Toasty.LENGTH_SHORT).show();
                    }else {
                        Intent i = new Intent(getApplicationContext(), ClassifierActivity.class);
                        startActivity(i);
                    }
                }
            }



    });
    }

    public void openprofile(View view) {


        Intent i = new Intent(getApplicationContext(), ProfileActivity.class);
        startActivity(i);
    }




}

