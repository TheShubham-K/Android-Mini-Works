package com.teachbrowniesindia.database;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    Button ins, sel;
    EditText t1,t2,t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new DBHelper(this).getWritableDatabase();
        ins= findViewById(R.id.button);
        sel= findViewById(R.id.button2);
        t1= findViewById(R.id.editText);
        t2= findViewById(R.id.editText2);
        t3= findViewById(R.id.editText3);
        ins.setOnClickListener(view -> {
            String s1=t1.getText().toString();
            String s2=t2.getText().toString();
            String s3=t3.getText().toString();
            ContentValues v = new ContentValues();
            v.put("usn",s1);
            v.put("name",s2);
            v.put("phone",s3);
            db.insert("student2",null,v);
            Toast.makeText(getApplicationContext(),"Inserted",Toast.LENGTH_SHORT).show();
        });
        sel.setOnClickListener(view -> {
            Cursor c = db.rawQuery("select * from student2",null);
            {
                c.moveToNext();
                String s="";
                s+="USN: "+ c.getString(0);
                s+= " Name: " + "\t"+ c.getString(1);
                s+=  "\n Phone No. : "+ "\t"+ c.getString(2);
                Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
            }
            c.close();
        });
    };
}
