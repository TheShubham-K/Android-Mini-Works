package com.teachbronieindia.camera;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button cap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cap = findViewById(R.id.cam);

        cap.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent t=new Intent( MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(t,1 );

            }
        } );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==1 && resultCode==RESULT_OK)
        {
            assert data != null;
            Bundle extra=data.getExtras();
            Bitmap image=(Bitmap)extra.get( "data" );
            BitmapDrawable drawable=new BitmapDrawable( this.getResources(),  image );
            ConstraintLayout r=findViewById( R.id.cons );
            r.setBackground(drawable );
        }
        super.onActivityResult( requestCode, resultCode, data );
    }
}