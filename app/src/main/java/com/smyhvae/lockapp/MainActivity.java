package com.smyhvae.lockapp;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button send_btn = (Button) this.findViewById(R.id.button1);
        send_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText num_edit = (EditText) findViewById(R.id.editText);
                String send_str = num_edit.getText().toString();
                String target_phone = "18382265479";
                System.out.print(target_phone);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    //SEE NEXT STEP
                    if (MainActivity.this.checkSelfPermission(Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
                        //SEE NEXT STEP
                        sendSms(target_phone,send_str,v);
                    } else {


                    }

/*                    if (MainActivity.this.shouldShowRequestPermissionRationale(Manifest.permission.SEND_SMS)) {
                        //show some description about this permission to the user as a dialog, toast or in Snackbar
                    } else {
                        //request for the permission
                    }*/
                    System.out.print("in1");

                }else{

                    sendSms(target_phone,send_str,v);
                    System.out.print("in1");

                }
            }
        });
    }

    public void sendSms(String phone,String msg,View v) {

        PendingIntent pi = PendingIntent.getActivity(this,0,new Intent(this,MainActivity.class),0);
        SmsManager sm = SmsManager.getDefault();
        sm.sendTextMessage(phone,null,msg,pi,null);
        Toast.makeText(MainActivity.this,"发送成功！",Toast.LENGTH_LONG).show();
    }

}