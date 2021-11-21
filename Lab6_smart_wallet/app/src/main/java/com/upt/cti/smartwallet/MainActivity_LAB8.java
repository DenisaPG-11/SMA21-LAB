package com.upt.cti.smartwallet;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import ui.PaymentAdapter;

public class MainActivity_LAB8 extends AppCompatActivity {

    // firebase
    private DatabaseReference databaseReference;
    private int currentMonth;
    private List<Payment> payments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab8_activity_main);

        TextView tStatus = (TextView) findViewById(R.id.tStatus_n);
        Button bPrevious = (Button) findViewById(R.id.bPrevious_n);
        Button bNext = (Button) findViewById(R.id.bNext_n);
        FloatingActionButton fabAdd = (FloatingActionButton) findViewById(R.id.fabAdd_n);
        ListView listPayments = (ListView) findViewById(R.id.listPayments_n);

        final PaymentAdapter adapter = new PaymentAdapter(this, R.layout.item_payment, payments);
        listPayments.setAdapter(adapter);

        // setup firebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference();

        //databaseReference.child("wallet").addChildEventListener(new ChildEventListener ...);

        // ...
    }
}
