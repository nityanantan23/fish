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
import com.google.firebase.auth.FirebaseUser;

import es.dmoral.toasty.Toasty;

public class activity_fisherman_details extends AppCompatActivity {

    EditText Name, Street, State , City, PhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fisherman_details);

        Name = findViewById(R.id.editText9);
        Street = findViewById(R.id.editText10);
        State = findViewById(R.id.editText11);
        City = findViewById(R.id.editText12);
        PhoneNumber = findViewById(R.id.editText13);

    }

    public void details(View view){
        if (Name.getText().toString().isEmpty() || Street.getText().toString().isEmpty()|| State.getText().toString().isEmpty()|| City.getText().toString().isEmpty()|| PhoneNumber.getText().toString().isEmpty()){

            Toasty.error(getApplicationContext(),"Blank space",Toast.LENGTH_SHORT).show();
        } else {
            String Name1 = Name.getText().toString().trim();
            String Street1 = Street.getText().toString().trim();
            String State1 = State.getText().toString().trim();
            String City1 = City.getText().toString().trim();
            String PhoneNumber1 = PhoneNumber.getText().toString().trim();

            Intent i = new Intent(getApplicationContext(),Bank_Detail_Activity.class);
            startActivity(i);









        }
    };

}


