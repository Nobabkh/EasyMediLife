package com.aoop_p.easymedilife;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.aoop_p.easymedilife.dbmanager.DBManager;

public class Login extends AppCompatActivity {
    DBManager db;
    //private final boolean activitychanged = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        db = new DBManager();
        checkconnectionandupdate();
        startActivity(new Intent(Login.this, Registration.class));/*
        Button bt = findViewById(R.id.button);
        bt.setOnClickListener(view -> {
            EditText mail = findViewById(R.id.editTextTextEmailAddress);
            EditText pass = findViewById(R.id.editTextTextPassword);
            if(db.userLogin(mail.getText().toString(), pass.getText().toString()))
            {
                startActivity(new Intent(Login.this, AddDistrict.class));
            }
            else
            {
                Toast.makeText(Login.this, "Failed to login", Toast.LENGTH_SHORT).show();
            }
        });*/


    }

    void checkconnectionandupdate()
    {
        Toast.makeText(this, db.connect(), Toast.LENGTH_SHORT).show();
    }
}