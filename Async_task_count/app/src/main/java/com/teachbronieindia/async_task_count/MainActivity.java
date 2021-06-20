package com.teachbronieindia.async_task_count;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ProgressBar pb;
    TextView t;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = findViewById(R.id.btn);
        t = findViewById(R.id.txt);
        pb = findViewById(R.id.prob);
        b.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        T t1 = new T();
        t1.execute("1000");
    }

    class T extends AsyncTask<String,Integer,String>
    {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {

            int max = Integer.parseInt(strings[0]);
            int i=0;
            while(i<max){
                try{
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                i++;
                publishProgress(i);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            pb.setProgress(values[0]);
            t.setText(values[0].toString());
            super.onProgressUpdate(values);
        }
    }
}