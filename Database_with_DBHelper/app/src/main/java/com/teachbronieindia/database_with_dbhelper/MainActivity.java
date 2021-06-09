package com.teachbronieindia.database_with_dbhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText e1, e2, e3, e4;
    Button b1, b2, b3;
    SQLiteDatabase db = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.editText);
        e2 = findViewById(R.id.editText2);
        e3 = findViewById(R.id.editText3);
        e4 = findViewById(R.id.editText4);
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        String name = e1.getText().toString();
        String age = e2.getText().toString();
        String add = e3.getText().toString();

        try {

            db = this.openOrCreateDatabase("student", MODE_PRIVATE, null);
            db.execSQL("create table if not exists test(name varchar(20), age varchar(10), address varchar(20))");
            if (v.getId() == b1.getId()) {
                db.execSQL("insert into test values('" + name + "', '" + age + "', '" + add + "')");
                Toast.makeText(this, "Data inserted", Toast.LENGTH_SHORT).show();
            }
            if (v.getId() == b2.getId()) {
                String all = "";
                Cursor c = db.rawQuery("Select * from test", null);
                if (c != null) {
                    if (c.moveToFirst()) {
                        do {
                            String oname = c.getString(c.getColumnIndex("name"));
                            String oage = c.getString(c.getColumnIndex("age"));
                            String oadd = c.getString(c.getColumnIndex("address"));
                            all = all + "\nName:" + oname + " Age:" + oage + " Address:" + oadd;
                        } while (c.moveToNext());
                        Toast.makeText(getApplicationContext(), all, Toast.LENGTH_SHORT).show();
                    }
                }
            }


            if (v.getId() == b3.getId()) {

                Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
                String delname = e4.getText().toString();
                db.execSQL("delete from test where name='" + delname + "'");
            }

        } catch (Exception e) {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        } finally {
            if (db != null)
                db.close();
        }

    }
}