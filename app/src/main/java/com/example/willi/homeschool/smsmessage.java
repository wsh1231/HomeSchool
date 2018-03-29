package com.example.willi.homeschool;

import android.*;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class smsmessage extends AppCompatActivity {

    Button button;

    EditText editText, editText2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvity_smsmessage);

        if(ContextCompat.checkSelfPermission(smsmessage.this,
                android.Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(smsmessage.this,
                    android.Manifest.permission.SEND_SMS)) {
                ActivityCompat.requestPermissions(smsmessage.this,
                        new String[]{android.Manifest.permission.SEND_SMS}, 1);
            } else {
                ActivityCompat.requestPermissions(smsmessage.this,
                        new String[]{android.Manifest.permission.SEND_SMS}, 1);
            }
        }else {
            //do nothing
        }

        button = (Button) findViewById(R.id.button);

        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = editText.getText().toString();
                String sms = editText2.getText().toString();

                try{
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(number, null, sms, null, null );
                    Toast.makeText(smsmessage.this, "Sent!", Toast.LENGTH_SHORT).show();

                }catch (Exception e){
                    Toast.makeText(smsmessage.this, "Failed!", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode){
            case 1 : {
                if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    if(ContextCompat.checkSelfPermission(smsmessage.this,
                            android.Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(this, "Permission granted!", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(this, "No permisson granted!", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }
}
