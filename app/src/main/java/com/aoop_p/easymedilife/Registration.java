package com.aoop_p.easymedilife;

import androidx.appcompat.app.AppCompatActivity;

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

import com.aoop_p.easymedilife.dbmanager.DBManager;

import java.util.ArrayList;
import java.util.Arrays;

public class Registration extends AppCompatActivity {

    DBManager db;
    Spinner spinsubdis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        db =new DBManager();
        setContentView(R.layout.activity_registration);
        Log.i("errormes", "lunched firstpage");
        registerpagetwo();
    }

    String dist = "", subdist ="", email, name, pass;
    ArrayList<String> subdistricts = null;
    ArrayList<String> districts = null;

        void registerpagetwo() {
            districts = new ArrayList<>();
            subdistricts = new ArrayList<>();
        setContentView(R.layout.activity_registerpage2);
        Log.i("errormes", "lunched secondtpage");
        Log.i("errormes", db.connect());
        districts = db.getdistrict();
        for(int i = 0; i < districts.size(); i++)
        {
            Log.i("errormes", districts.get(i));
        }
        Spinner spinnerdis = findViewById(R.id.spinnerdis);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, districts);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerdis.setAdapter(arrayAdapter);
        Log.i("errormes", "passed arrayadapter");
        spinnerdis.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                dist = parent.getItemAtPosition(position).toString();
                Log.i("errormes", "selected"+dist);
                subdisfunc();
            }

            @Override
            public void onNothingSelected(AdapterView <?> parent) {
                dist = "";
            }
        });

        spinsubdis = findViewById(R.id.spinner2);
        ArrayAdapter<String> arrayAdsub = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, subdistricts);
        arrayAdsub.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinsubdis.setAdapter(arrayAdsub);
        spinsubdis.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                subdist = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
                subdist = "";
            }
        });
        Button bt = findViewById(R.id.button5);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((!dist.equalsIgnoreCase("")) && (!subdist.equalsIgnoreCase("")))
                {
                    EditText addredd = findViewById(R.id.addressedittext);
                    String address = addredd.getText().toString();
                    db.update_user_address(email, pass, dist, subdist, address);
                }
            }
        });
    }
    private void subdisfunc() {
        subdistricts = db.getsubDist(dist);
        ArrayAdapter<String> arrayAdsub = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, subdistricts);
        arrayAdsub.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinsubdis.setAdapter(arrayAdsub);
    }
}