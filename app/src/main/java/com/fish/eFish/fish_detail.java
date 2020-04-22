package com.fish.eFish;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class fish_detail extends AppCompatActivity {

    EditText price,location,quantity;
    TextView name;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private static final String TAG = "fish_detail";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fish_detail);
        price = findViewById(R.id.editprice);
        location = findViewById(R.id.editlocation);
        quantity = findViewById(R.id.editText);
        name = findViewById(R.id.fish_name);
        name.setText(com.fish.eFish.camera.CameraActivity.Fish_name);



    }


    public void fish_details(){
        String fish_price = price.getText().toString().trim();
        String fish_location = location.getText().toString().trim();
        String fish_quantity = quantity.getText().toString().trim();

        Map<String, Object> user = new HashMap<>();
        user.put("Fish_Price", fish_price);
        user.put("Fish_location", fish_location);
        user.put("quantity",fish_quantity);

        db.collection("Fish")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });

        Intent i = new Intent(getApplicationContext(),HompageActivity.class);
        startActivity(i);
    }
}
