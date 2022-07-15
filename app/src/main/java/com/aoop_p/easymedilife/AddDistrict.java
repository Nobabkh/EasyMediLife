package com.aoop_p.easymedilife;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.aoop_p.easymedilife.dbmanager.DBManager;

public class AddDistrict extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_district);
        DBManager db = new DBManager();
        Button save = findViewById(R.id.savedisbtn);
        save.setOnClickListener(view -> {
            EditText get = findViewById(R.id.takedist);
            Toast.makeText(this, db.addDistrct(get.getText().toString()), Toast.LENGTH_SHORT).show();
            get.setText("");
        });
    }
}