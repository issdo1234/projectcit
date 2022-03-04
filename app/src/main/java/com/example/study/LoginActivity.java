package com.example.study;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    Button btn_login;
//    TextView txtsignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_login = findViewById(R.id.btn_login);
//        txtsignup = findViewById(R.id.txtsignup);


        btn_login.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
            startActivity(intent);
        });
//        txtsignup.setOnClickListener(view -> {
//            Intent intent = new Intent(getApplicationContext(),SignUp.class);
//            startActivity(intent);
//        });
    }



}
