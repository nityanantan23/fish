package com.fish.eFish;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
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

public class LoginActivity extends AppCompatActivity {
    EditText mail,pass;

    private FirebaseAuth auth;
    private FirebaseUser User;
    private View view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        auth= FirebaseAuth.getInstance();
        mail = findViewById(R.id.editText2);
        pass = findViewById(R.id.editText);

    }

    public void SignIn(View view){
        final FirebaseUser User = auth.getCurrentUser();
        if (mail.getText().toString().isEmpty() || pass.getText().toString().isEmpty()){

            Toast.makeText(getApplicationContext(),"Blank space",Toast.LENGTH_SHORT).show();
        } else {
            String email = mail.getText().toString().trim();
            String password = pass.getText().toString().trim();

            auth.signInWithEmailAndPassword (email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){


                                User.sendEmailVerification();
                                Toasty.success(getApplicationContext(),"Verification email is sent to "+ User.getEmail(),Toast.LENGTH_SHORT).show();
                                FirebaseUser user = auth.getCurrentUser();
                                if (user.isEmailVerified()){
                                    Toast.makeText(getApplicationContext(),"Email verified",Toast.LENGTH_SHORT).show();
                                    Intent i = new Intent(getApplicationContext(),activity_fisherman_details.class);
                                    startActivity(i);


                                } else {
                                    Toast.makeText(getApplicationContext(),"waiting for verification",Toast.LENGTH_SHORT).show();

                                }




                            } else {
                                Toasty.error(getApplicationContext(),"Wrong credentials",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }



    public void ResetPassword(View view){
        FirebaseAuth auth = FirebaseAuth.getInstance();
        final FirebaseUser User = auth.getCurrentUser();
        final String emailAddress = mail.getText().toString().trim();


        if (mail.getText().toString().isEmpty()){
            Toasty.error(getApplicationContext(),"Email Field is empty ",Toast.LENGTH_SHORT).show();
            mail.setError("error");
        }else {

        auth.sendPasswordResetEmail(emailAddress)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toasty.success(getApplicationContext(),"Reset Email sent to "+ emailAddress,Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

}}



