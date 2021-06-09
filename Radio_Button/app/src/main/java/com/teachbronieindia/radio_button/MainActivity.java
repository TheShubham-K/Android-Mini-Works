package com.teachbronieindia.radio_button;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button submit, clear;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        submit = findViewById(R.id.sb1);
        clear = findViewById(R.id.cb1);

        rg = findViewById(R.id.rg);
        rg.clearCheck();
        rg.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton rb = group.findViewById(checkedId);
            // Toast.makeText(this, rb.getText()+" Selected", Toast.LENGTH_SHORT).show();
        });

        submit.setOnClickListener(v -> {
            int selectedId = rg.getCheckedRadioButtonId();
            if(selectedId == -1){
                Toast.makeText(this,
                        "No answer has been selected",
                        Toast.LENGTH_SHORT).show();
            }else{
                RadioButton radioButton = rg.findViewById(selectedId);
                Toast.makeText(this,
                        radioButton.getText(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        clear.setOnClickListener(v -> rg.clearCheck());
    }
}