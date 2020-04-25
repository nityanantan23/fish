package com.fish.eFish;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class ProfileActivity extends AppCompatActivity {

    private FirebaseFirestore mDb;

    FirebaseAuth auth;
    FirebaseUser user;
    TextView ProfileEmail;
    EditText seller_name,Address,number;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private static final String TAG = "Fisherman_details";
//    SharedPreferences sharedPreferences = getSharedPreferences("ok", MODE_PRIVATE);
//    SharedPreferences.Editor editor = sharedPreferences.edit();
//    String name = sharedPreferences.getString("ID", "");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        auth= FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        seller_name = findViewById(R.id.editText8);
        Address =findViewById(R.id.editText7);
        number =findViewById(R.id.editText6);


        ProfileEmail =(TextView)findViewById(R.id.textView);
        ProfileEmail.setText(user.getEmail());




    }

    public void signOut(View view){
        auth.signOut();
        finish();
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);

//        SharedPreferences sharedPreferences = getSharedPreferences("ok", MODE_PRIVATE);
//        SharedPreferences.Editor mEditor = sharedPreferences.edit();
//        mEditor.clear();
    }
    public void openprofile(View view){
        auth.signOut();
        finish();
        Intent i = new Intent(this,ProfileActivity.class);
        startActivity(i);
    }

    public void update(View view){

        Map<String, Object> user = new HashMap<>();
        user.put("Seller_name", seller_name);
        user.put("Seller_address", Address);
        user.put("phone_number", number);

//        db.collection("Fish").document("G07skyG2lc0quzZRPHLc").set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
//            @Override
//            public void onSuccess(Void aVoid) {
//                Log.d(TAG, "DocumentSnapshot successfully written!");
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Log.w(TAG, "Error writing document", e);
//            }

//        });
    }



}
