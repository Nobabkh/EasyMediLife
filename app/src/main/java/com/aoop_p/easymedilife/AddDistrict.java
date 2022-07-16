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
    DBManager db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new DBManager();
        adddis();
    }
    void adddis()
    {
        setContentView(R.layout.activity_add_district);
        Button save = findViewById(R.id.savedisbtn);
        save.setOnClickListener(view -> {
            EditText get = findViewById(R.id.takedist);
            Toast.makeText(this, db.addDistrct(get.getText().toString()), Toast.LENGTH_SHORT).show();
            get.setText("");
        });
        Button adsubd = findViewById(R.id.button3);
        adsubd.setOnClickListener(view -> addsubdis());
    }
    String dist, subdis;
    void addsubdis()
    {
        setContentView(R.layout.activity_add_subdis);
        ArrayList<String> districts = db.getdistrict();
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, districts);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                dist = parent.getItemAtPosition(position).toString();

            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });
        EditText subdist = findViewById(R.id.editsubdis);
        Button bt = findViewById(R.id.savedissubdis);
        bt.setOnClickListener(view -> {
            subdis = subdist.getText().toString();
            String res = db.addDistrctAndsubdis(dist, subdis);
            Toast.makeText(AddDistrict.this, dist+" "+subdis, Toast.LENGTH_SHORT).show();
            Toast.makeText(AddDistrict.this, res,Toast.LENGTH_SHORT).show();
            if(res.equalsIgnoreCase("Successfull"))
            {
                subdist.setText("");
            }
            else
            {
                subdist.setText("Failed");
            }
        });
        Button bt2 = findViewById(R.id.button4);
        bt2.setOnClickListener(view -> adddis());
    }
}