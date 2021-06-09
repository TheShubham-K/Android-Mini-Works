package com.teachbronieindia.database_without_dbhelper;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText e1, e2, e3, e4;
    Button submit, call;
    SQLiteDatabase db;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.name);
        e2 = findViewById(R.id.id);
        e3 = findViewById(R.id.number);
        e4 = findViewById(R.id.id_search);

        submit = findViewById(R.id.submit);
        call = findViewById(R.id.call);

        db=new Helper(this).getWritableDatabase();

        submit.setOnClickListener(v -> {

            String name = e1.getText().toString();
            String usn = e2.getText().toString();
            String phone = e3.getText().toString();

            if (name.equals("") || usn.equals("") || phone.equals("")) {
                Toast.makeText(MainActivity.this, "Insert all fields", Toast.LENGTH_SHORT).show();
            } else {
                ContentValues values = new ContentValues();
                values.put("name", name);
                values.put("usn", usn);
                values.put("phone", phone);
                db.insert("test", null, values);
                Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
            }
        });

        call.setOnClickListener(v -> {
            String id = e4.getText().toString();
            Cursor c = db.rawQuery("Select * from test where usn='" + id + "'", null);
            if (c.getCount() <= 0) {
                Toast.makeText(MainActivity.this, "No Records", Toast.LENGTH_LONG).show();
            } else {

                c.moveToNext();
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel : " + c.getString(2)));
                try {


                    if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }

                    startActivity(i);

                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Cannot call", Toast.LENGTH_SHORT).show();
                    String err = e.toString();
//                    Toast.makeText(MainActivity.this, err, Toast.LENGTH_LONG).show();
                    Log.i("Error", err);

                }
            }
            c.close();
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
    }
}