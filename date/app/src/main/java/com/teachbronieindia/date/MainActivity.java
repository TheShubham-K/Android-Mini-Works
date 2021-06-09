package com.teachbronieindia.date;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    DatePicker dp;
    Spinner spin;
    ListView l;
    String[] branch = {"CSE", "IS", "EC", "EE", "ME", "CIVIL", "BT"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //spin = (Spinner) findViewById(R.id.sp);
//            d = (DatePicker) findViewById(R.id.dp);
//            l=(ListView)findViewById( R.id.list1 );
//            a = new ArrayAdapter<>(this, R.layout.l1, branch);
//            l.setAdapter(a);
//            l.setOnItemSelectedListener(this);

        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, branch);
        l = (ListView) findViewById(R.id.list1);
        spin = findViewById(R.id.sp);
        dp = (DatePicker) findViewById(R.id.dp);
        spin.setAdapter(ad);
        spin.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        Toast.makeText(getApplicationContext(), "course:" + branch[i], Toast.LENGTH_SHORT).show();
        String jd = "Joined on : " + dp.getDayOfMonth() + " " + (dp.getMonth() + 1) + " " + dp.getYear();
        Toast.makeText(getApplicationContext(), jd, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {}

}