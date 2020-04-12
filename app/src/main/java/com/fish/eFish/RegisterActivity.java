package com.fish.eFish;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import es.dmoral.toasty.Toasty;

public class RegisterActivity extends AppCompatActivity {

    EditText e1,e2;

    FirebaseAuth auth;
    FirebaseUser firebaseUser;
    private View view;

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
            String email = e1.getText().toString();
            String password = e2.getText().toString();

            auth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toasty.success(getApplicationContext(),"User created succesfully!",Toast.LENGTH_SHORT).show();
                                FirebaseUser user = auth.getCurrentUser();
                                finish();
                            } else {
                                Toasty.error(getApplicationContext(),"User not created ",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

        }
    }


}
