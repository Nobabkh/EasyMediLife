package com.aoop_p.easymedilife;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.aoop_p.easymedilife.dbmanager.DBManager;

public class Login extends AppCompatActivity {
    DBManager db;
    private boolean activitychanged = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new DBManager();
        checkconnectionandupdate();
    }
    void checkconnectionandupdate()
    {
        if(!db.connect())
        {
            if(!activitychanged) {
                setContentView(R.layout.activity_changedburl);
                activitychanged = true;
            }
            Button save = findViewById(R.id.button2);
            save.setOnClickListener(view -> {
                EditText url = findViewById(R.id.editTextTextPersonName);
                String dburl = url.getText().toString();
                db = new DBManager(dburl);
                if(db.connect())
                {
                    setContentView(R.layout.activity_login);
                    activitychanged = false;
                }
                else
                {
                    checkconnectionandupdate();
                }
            });
        }
    }
}