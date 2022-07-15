package com.aoop_p.easymedilife;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.aoop_p.easymedilife.dbmanager.DBManager;

import java.util.ArrayList;

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
        setContentView(R.layout.activity_add_subdis);
        ArrayList<String> districts = db.getdistrict();
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, districts);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String tutorialsName = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Selected: " + tutorialsName,Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });


    }
}