package com.teachbronie.resume;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    ImageView pic;
    Button submit, upload;
    RadioButton cs, is, ece;
    RadioGroup rg;
    EditText name, phone, email, cgpaIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pic = findViewById(R.id.pic);
        upload = findViewById(R.id.upload_bt);
        name = findViewById(R.id.nameIn);
        phone = findViewById(R.id.phoneId);
        email = findViewById(R.id.emailIn);
        rg = findViewById(R.id.rg);
        cgpaIn = findViewById(R.id.cgpaIn);
        submit = findViewById(R.id.submit);

        cs = findViewById(R.id.checkCs);
        is = findViewById(R.id.checkIs);
        ece = findViewById(R.id.checkEc);

        upload.setOnClickListener(v -> {
            pic.setImageResource(R.drawable.pro1);
        });

        rg.clearCheck();

        submit.setOnClickListener(v ->{

            String ne = name.getText().toString();
            String pe = phone.getText().toString();
            String em = email.getText().toString();
            String cg = cgpaIn.getText().toString();

            StringBuilder department= new StringBuilder();
            if(cs.isChecked()){
                is.setChecked(false);
                ece.setChecked(false);
                department.append("Computer Science");
            }
            else if(is.isChecked()){
                cs.setChecked(false);
                ece.setChecked(false);
                department.append("Information Science");
            }
            else if(ece.isChecked()){
                is.setChecked(false);
                cs.setChecked(false);
                department.append("Electrical and Communication Engineering");
            }

            Intent intent = new Intent(this, view_screen.class);

            intent.putExtra("name", ne);
            intent.putExtra("phone", pe);
            intent.putExtra("email", em);
            intent.putExtra("cgpa", cg);
            intent.putExtra("depart", department.toString());
            intent.putExtra("photo", R.drawable.pro1);

            Toast.makeText(this, "Data Submitted", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        });

    }
}