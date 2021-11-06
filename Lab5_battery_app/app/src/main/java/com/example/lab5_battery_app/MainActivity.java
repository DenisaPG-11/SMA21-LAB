package com.example.lab5_battery_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static int notificationId;

//    TextView textView3 =  findViewById(R.id.textView3) ; // Are we charging / charged? -> status
//    TextView textView4 =  findViewById(R.id.textView4) ;// How are we charging? -> charge plug
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String t1 = "charging";
        String t2 = "usb charging";

//        textView3.setText(t1);
//        textView4.setText(t2);
    }
}