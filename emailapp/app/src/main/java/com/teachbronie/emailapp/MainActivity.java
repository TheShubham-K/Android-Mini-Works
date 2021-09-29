package com.teachbronie.emailapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        send = findViewById(R.id.button);

        send.setOnClickListener(v -> {

            Toast.makeText(this, "send email", Toast.LENGTH_SHORT).show();
            Intent mailIntent = new Intent(Intent.ACTION_VIEW);
            Uri data = Uri.parse("mailto:?subject=" + "subject text"+ "&body=" + "body text " + "&to=" + "destination@mail.com");
            mailIntent.setData(data);


            try {
                startActivity(Intent.createChooser(mailIntent, "Send mail..."));
                //finish();
                Log.i("Finished sending email.", "");
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(MainActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
            }

        });

    }
}