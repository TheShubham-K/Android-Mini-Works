package com.teachbronieindia.sms_using_intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Telephony;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText e1, e2;
    Button b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.button);
        e1 = findViewById(R.id.editText);
        e2 = findViewById(R.id.editText2);


        // Runtime permissions are now necessary for SEND_SMS, since API level 23
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},1);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.RECEIVE_SMS},1);

        b1.setOnClickListener(v -> {
            Toast.makeText(this, "Clicked me", Toast.LENGTH_SHORT).show();
            try{

//                if(getDefaultSmsAppPackageName(this) != null){
//                    Intent i =  new Intent(Intent.ACTION_VIEW);
//                    String ph = e1.getText().toString();
//                    String sms = e1.getText().toString();
//                    i.setDataAndType(Uri.parse( "sms : "+ph ), "vnd.andriod-dir/mms-sms");
//                    i.putExtra( Intent.EXTRA_TEXT, sms);
//                    startActivity(i);
//
//                    Toast.makeText(this, "Message sent successfully", Toast.LENGTH_SHORT).show();
//                }
                String ph = e1.getText().toString();
                String sms = e1.getText().toString();
                sendSms(this, sms, Collections.singletonList(ph));

            }catch (Exception e){
                //Toast.makeText(MainActivity.this, "Error : "+e.toString(), Toast.LENGTH_LONG).show();
                Log.i("Error :" , e.toString());
            }
        });

    }

    public static boolean sendSms(Context context, String text, List<String> numbers) {

        String numbersStr = TextUtils.join(",", numbers);

        Uri uri = Uri.parse("sms:" + numbersStr);

        Intent intent = new Intent();
        intent.setData(uri);
        intent.putExtra(Intent.EXTRA_TEXT, text);
        intent.putExtra("sms_body", text);
        intent.putExtra("address", numbersStr);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            intent.setAction(Intent.ACTION_SENDTO);
            String defaultSmsPackageName = Telephony.Sms.getDefaultSmsPackage(context);
            if(defaultSmsPackageName != null) {
                intent.setPackage(defaultSmsPackageName);
            }
        } else {
            intent.setAction(Intent.ACTION_VIEW);
            intent.setType("vnd.android-dir/mms-sms");
        }

        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static String getDefaultSmsAppPackageName(@NonNull Context context) {
        String defaultSmsPackageName;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            defaultSmsPackageName = Telephony.Sms.getDefaultSmsPackage(context);
            return defaultSmsPackageName;
        } else {
            Intent intent = new Intent(Intent.ACTION_VIEW)
                    .addCategory(Intent.CATEGORY_DEFAULT).setType("vnd.android-dir/mms-sms");
            final List<ResolveInfo> resolveInfos = context.getPackageManager().queryIntentActivities(intent, 0);
            if (resolveInfos != null && !resolveInfos.isEmpty())
                return resolveInfos.get(0).activityInfo.packageName;

        }
        return null;
    }
}