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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;

import es.dmoral.toasty.Toasty;

public class ProfileActivity extends AppCompatActivity {

    private FirebaseFirestore mDb;

    FirebaseAuth auth;
    FirebaseUser user;
    TextView ProfileEmail;
    EditText seller_name,sell_Address,sell_number;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private static final String TAG = "Fisherman_details";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        auth= FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        seller_name = findViewById(R.id.editText8);
        sell_Address =findViewById(R.id.editText7);
        sell_number =findViewById(R.id.editText6);



        ProfileEmail =(TextView)findViewById(R.id.textView);
        ProfileEmail.setText(user.getEmail());

//        db.collection("Fish").document(auth.getUid()).get()
        DocumentReference user = db.collection("Fish").document(auth.getUid());
        user.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()){
                    String name = documentSnapshot.getString("Seller_name");
                    String addres = documentSnapshot.getString("Seller_address");
                    String phone = documentSnapshot.getString("phone_number");

                    seller_name.setText(name);
                    sell_Address.setText(addres);
                    sell_number.setText(phone);


                }
        }});
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

        Map<String, Object> fishydetails = new HashMap<>();
        fishydetails.put("Seller_name", seller_name.getText().toString());
        fishydetails.put("Seller_address", sell_Address.getText().toString());
        fishydetails.put("phone_number", sell_number.getText().toString());





        db.collection("Fish").document(auth.getUid()).set(fishydetails, SetOptions.merge())
                .addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toasty.success(getApplicationContext(),"Updated", Toast.LENGTH_SHORT).show();

            }

        });}}

