package com.aoop_p.easymedilife;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.aoop_p.easymedilife.dbmanager.DBManager;

import java.util.ArrayList;

public class Doctoractivity extends AppCompatActivity {
    Spinner districtspinner, subdisspinner, hospitalspinner;
    ArrayList<String> subdistricts = null;
    ArrayList<String> districts = null;
    ArrayList<String> hospitals = null;
    DBManager db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        db = new DBManager();
        Bundle bn = getIntent().getExtras();
        int k = bn.getInt("extra");
        switch (k)
        {
            case 1:
                adddoctor();
                break;
            case 2:
                addhospital();
                break;
            default:
                break;
        }
    }

    String district, subdistrict, hospital;
    void adddoctor()
    {
        setContentView(R.layout.adddoctor_activity);
        districtspinner = findViewById(R.id.spinner);
        subdisspinner = findViewById(R.id.spinner3);
        hospitalspinner = findViewById(R.id.spinner4);
        districts = new ArrayList<>();
        subdistricts = new ArrayList<>();
        hospitals = new ArrayList<>();
        //setContentView(R.layout.activity_registerpage2);
        Log.i("errormes", db.connect());
        districts = db.getdistrict();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, districts);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        districtspinner.setAdapter(arrayAdapter);
        districtspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                district = parent.getItemAtPosition(position).toString();
                subdisfunc();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        subdisspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                subdistrict = adapterView.getItemAtPosition(i).toString();
                hospitalfunc();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        hospitalspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                hospital = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        Button save = findViewById(R.id.button11);
        save.setOnClickListener(view -> {
            EditText ed = findViewById(R.id.editTextTextPersonName2);
            String doctor = ed.getText().toString();
            Toast.makeText(this, db.adDoctor(doctor, hospital), Toast.LENGTH_SHORT).show();
            ed.setText("");
        });
    }
    private void subdisfunc() {
        subdistricts = db.getsubDist(district);
        ArrayAdapter<String> arrayAdsub = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, subdistricts);
        arrayAdsub.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subdisspinner.setAdapter(arrayAdsub);
    }


    private void hospitalfunc() {
        hospitals = db.gethospital(district, subdistrict);
        ArrayAdapter<String> arrayAdsub = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, hospitals);
        arrayAdsub.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hospitalspinner.setAdapter(arrayAdsub);
    }
    void addhospital()
    {
        setContentView(R.layout.addhospital_activity);
        districtspinner = findViewById(R.id.spinner5);
        subdisspinner = findViewById(R.id.spinner6);
        districts = new ArrayList<>();
        subdistricts = new ArrayList<>();
        districts = db.getdistrict();
        EditText hospitaleditText = findViewById(R.id.edittesthospitalname);
        Button save = findViewById(R.id.button12);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, districts);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        districtspinner.setAdapter(arrayAdapter);
        districtspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                district = parent.getItemAtPosition(position).toString();
                subdisfunc();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        subdisspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                subdistrict = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        save.setOnClickListener(view -> {
            hospital = hospitaleditText.getText().toString();
            String toast = db.addHospital(district, subdistrict, hospital);
            hospitaleditText.setText("");
            Toast.makeText(Doctoractivity.this, toast, Toast.LENGTH_SHORT).show();
        });
    }
}
