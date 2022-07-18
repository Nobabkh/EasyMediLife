package com.aoop_p.easymedilife;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.aoop_p.easymedilife.dbmanager.DBManager;

import java.util.ArrayList;

public class Registerpage2 extends AppCompatActivity {

    String dist = "";
    ArrayList<String> subdist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerpage2);
        DBManager db = new DBManager();
        ArrayList<String> districts = db.getdistrict();
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, districts);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                dist = parent.getItemAtPosition(position).toString();
                subdist = db.getsubDist(dist);
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
                dist = "";
            }
        });
    }
}