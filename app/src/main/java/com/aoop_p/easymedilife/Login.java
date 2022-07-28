package com.aoop_p.easymedilife;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
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

        Button bt = findViewById(R.id.button);
        Button regactivity = findViewById(R.id.Buttonres);
        regactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, Registration.class));
            }
        });
        bt.setOnClickListener(view -> {
            EditText mail = findViewById(R.id.editTextTextEmailAddress);
            EditText pass = findViewById(R.id.editTextTextPassword);
            if(db.userLogin(mail.getText().toString(), pass.getText().toString()) && db.useradmin(mail.getText().toString(), pass.getText().toString()))
            {
                logged_in_as_admin();
            }
            else if(db.userLogin(mail.getText().toString(), pass.getText().toString()))
            {
                setContentView(R.layout.welcomeuser);
            }
            else
            {
                Toast.makeText(Login.this, "Failed to login", Toast.LENGTH_SHORT).show();
            }
        });


    }

    void checkconnectionandupdate()
    {
        Toast.makeText(this, db.connect(), Toast.LENGTH_SHORT).show();
    }
    void logged_in_as_admin()
    {
        setContentView(R.layout.welcomeadminpanel);
        Button addist = findViewById(R.id.button6);
        Button adsubdis = findViewById(R.id.button7);
        Intent i = new Intent(Login.this, AddDistrict.class);
        addist.setOnClickListener(view -> {
            i.putExtra("extra", 0);
            startActivity(i);
        });
        adsubdis.setOnClickListener(view ->{
            i.putExtra("extra", 1);
            startActivity(i);
        });

    }
}