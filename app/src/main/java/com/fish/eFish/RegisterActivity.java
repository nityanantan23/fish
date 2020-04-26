package com.fish.eFish;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import es.dmoral.toasty.Toasty;

import static com.fish.eFish.camera.CameraActivity.Fish_name;

public class RegisterActivity extends AppCompatActivity {

    EditText e1,e2;

    FirebaseAuth auth;
    FirebaseUser firebaseUser;
    private View view;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    Map<String, Object> user = new HashMap<>();
    private static final String TAG = "fish_detail";
     String Doc="";
    String email="";






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        e1 = (EditText)findViewById(R.id.editText4);
        e2 = (EditText)findViewById(R.id.editText5);
        auth= FirebaseAuth.getInstance();


    }


    public void Createuser(View view){


        if (e1.getText().toString().isEmpty() || e2.getText().toString().isEmpty()){
            Toast.makeText(getApplication(),"its Blank",Toast.LENGTH_SHORT).show();
        } else {
             email = e1.getText().toString();
            String password = e2.getText().toString();

            Map<String, Object> user = new HashMap<>();
            user.put("email", email);
            user.clear();

            auth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toasty.success(getApplicationContext(),"User created succesfully!",Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                                startActivity(i);



                                db.collection("Fish").document(auth.getUid()).set(user)
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {
                                                Toasty.success(getApplicationContext(),"Register success",Toast.LENGTH_SHORT).show();
                                            }
                                        });





//
//                                db.collection("Fish")
//                                        .add(Objects.requireNonNull(auth.getUid()))
//                                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                                            @Override
//                                            public void onSuccess(DocumentReference documentReference) {
//                                                Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
//
////                                                SharedPreferences sharedPreferences = getSharedPreferences("ok", MODE_PRIVATE);
////                                                SharedPreferences.Editor mEditor = sharedPreferences.edit();
////                                                mEditor.putString("ID",email);
////                                                mEditor.apply();
//                                                Toasty.success(getApplicationContext(), "Succesfuly added" + Fish_name, Toasty.LENGTH_SHORT).show();
//                                                System.out.println(Doc);
//                                            }
//                                        })
//                                        .addOnFailureListener(new OnFailureListener() {
//                                            @Override
//                                            public void onFailure(@NonNull Exception e) {
//                                                Log.w(TAG, "Error adding document", e);
//
//                                            }
//                                        });
                                Toasty.success(getApplicationContext(), "Succesfuly added" + Fish_name, Toasty.LENGTH_SHORT).show();
                                FirebaseUser user = auth.getCurrentUser();

                            } else {
                                Toasty.error(getApplicationContext(),"User not created ",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

        }
    }


}
