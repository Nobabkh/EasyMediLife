package com.aoop_p.easymedilife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        registrationpageone();

    }

    void registrationpageone()
    {
        setContentView(R.layout.activity_registration);
        EditText emailt = findViewById(R.id.EmailEditTextId);
        EditText namet = findViewById(R.id.NameEditTextId);
        EditText phonet = findViewById(R.id.PhoneEditTextId);
        EditText passt = findViewById(R.id.PasswordEditTextId);
        Button next = findViewById(R.id.RegisterButtonId);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = emailt.getText().toString();
                name = namet.getText().toString();
                phone = phonet.getText().toString();
                pass = passt.getText().toString();
                if (db.register(email, name, phone, pass)){
                    registerpagetwo();
                }
            }
        });
        Button login = findViewById(R.id.Buttonres);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Registration.this, Login.class));
            }
        });
    }

    String dist = "", subdist ="", email, name, pass, phone;
    ArrayList<String> subdistricts = null;
    ArrayList<String> districts = null;

        void registerpagetwo() {
            districts = new ArrayList<>();
            subdistricts = new ArrayList<>();
        setContentView(R.layout.activity_registerpage2);
        Log.i("errormes", db.connect());
        districts = db.getdistrict();
        Spinner spinnerdis = findViewById(R.id.spinnerdis);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, districts);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerdis.setAdapter(arrayAdapter);

        spinnerdis.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                dist = parent.getItemAtPosition(position).toString();

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
                    startActivity(new Intent(Registration.this, Login.class));
                }
            }
        });
        Button bclog = findViewById(R.id.Buttonres1);
        bclog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Registration.this, Login.class));
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