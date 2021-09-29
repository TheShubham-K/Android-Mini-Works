package com.teachbronie.resume;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class view_screen extends AppCompatActivity {

    ImageView img;
    TextView name, cgpa, phone, email, department;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_screen);


        //back button
        ActionBar actionbar = getSupportActionBar();
        assert actionbar != null;
        actionbar.setHomeAsUpIndicator(R.drawable.backbutton);
        actionbar.setDisplayHomeAsUpEnabled(true);

        img = findViewById(R.id.imageView);
        name = findViewById(R.id.name);
        department = findViewById(R.id.depart);
        cgpa = findViewById(R.id.cgpaText);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);

        // photo is called from first activity
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            int resId = bundle.getInt("photo");
            img.setImageResource(resId);
        }

        Intent intent = getIntent();

        String ne = intent.getStringExtra("name");
        String po = intent.getStringExtra("phone");
        String em = intent.getStringExtra("email");
        String cg = intent.getStringExtra("cgpa");
        String dep = intent.getStringExtra("depart");

        name.setText(ne);
        department.setText(dep);
        phone.setText(po);
        email.setText(em);
        cgpa.setText(cg);

    }


    // back button
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}