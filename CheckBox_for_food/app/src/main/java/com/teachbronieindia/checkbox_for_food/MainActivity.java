package com.teachbronieindia.checkbox_for_food;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b, b2;
    CheckBox c1, c2, c3, c4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = findViewById(R.id.button);
        b2 = findViewById(R.id.cl);
        c1 = findViewById(R.id.ck1);
        c2 = findViewById(R.id.ck2); 
        c3 = findViewById(R.id.ck3);
        c4 = findViewById(R.id.ck4);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sum =0;
                StringBuilder s = new StringBuilder();
                s.append("Ordered Items are \n");
                if(c1.isChecked()){
                    s.append("Biryani\n");
                    sum += 120;
                }
                if(c2.isChecked()){
                    s.append("Mutton Macho's\n");
                    sum += 170;
                }
                if (c3.isChecked()) {
                    s.append( "Masala Papad\n" );
                    sum += 20;

                }
                if (c4.isChecked()) {
                    s.append( "Tuborg Strong\n" );
                    sum += 140;

                }
                if(sum == 0){
                    Toast.makeText(MainActivity.this, "Please select atleast one item", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, s+" Sum is - "+sum, Toast.LENGTH_LONG).show();
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });

    }
}