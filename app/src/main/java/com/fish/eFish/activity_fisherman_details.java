package com.fish.eFish;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import es.dmoral.toasty.Toasty;

public class activity_fisherman_details extends AppCompatActivity {

    EditText Name, Address, PhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fisherman_details);

        Name = findViewById(R.id.editText9);
        Address = findViewById(R.id.editText10);
        PhoneNumber = findViewById(R.id.editText13);

    }

    public void details(View view){
        if (Name.getText().toString().isEmpty() || Address.getText().toString().isEmpty()|| PhoneNumber.getText().toString().isEmpty()){

            Toasty.error(getApplicationContext(),"Blank space",Toast.LENGTH_SHORT).show();
        } else {
            String Name1 = Name.getText().toString().trim();
            String Address1 = Address.getText().toString().trim();
            String PhoneNumber1 = PhoneNumber.getText().toString().trim();
//            FirebaseFirestore db = FirebaseFirestore.getInstance();
//
//            Map<String, Object> user = new HashMap<>();
//            user.put("Seller_name", Name1);
//            user.put("Seller_address", Address1);
//            user.put("phone_number",PhoneNumber1);
//
//            db.collection("Fish")
//                    .add(user)
//                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                        @Override
//                        public void onSuccess(DocumentReference documentReference) {
//                            Log.d(Tag, "")
//
//                        }
//                    })
//

            Intent i = new Intent(getApplicationContext(),HompageActivity.class);
            startActivity(i);









        }
    }

}


