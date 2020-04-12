package com.fish.eFish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class Bank_Detail_Activity extends AppCompatActivity {

    EditText Acc_name, Bank, Acc_number , IC_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank__detail_);


        Acc_name = findViewById(R.id.editText3);
        Bank = findViewById(R.id.editText10);
        Acc_number = findViewById(R.id.editText15);
        IC_number = findViewById(R.id.editText16);

    }



    public void Bank(View view) {
        if (Acc_name.getText().toString().isEmpty() || Bank.getText().toString().isEmpty() || Acc_number.getText().toString().isEmpty() || IC_number.getText().toString().isEmpty()) {

            Toasty.error(getApplicationContext(), "Blank space", Toast.LENGTH_SHORT).show();
        } else {
            String Acc_name1 = Acc_name.getText().toString().trim();
            String Bank1 = Bank.getText().toString().trim();
            String Acc_number1 = Acc_number.getText().toString().trim();
            String IC_number1 = IC_number.getText().toString().trim();

            Intent i = new Intent(getApplicationContext(), HompageActivity.class);
            startActivity(i);
        }
    }
    }
