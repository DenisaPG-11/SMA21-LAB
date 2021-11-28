package com.upt.cti.smartwallet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class AddPaymentActivity extends AppCompatActivity {

    // firebase
    private DatabaseReference databaseReference;
    private int currentMonth;
    private List<Payment> payments = new ArrayList<>();

    public static String getCurrentTimeDate(){
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        return sdfDate.format(now);
    }

    public void clicked(View view) {

//        Button bSave = (Button) findViewById(R.id.bSave);
//        Button bDelete = (Button) findViewById(R.id.bDelete);

        switch (view.getId()) {
            case R.id.bSave:
             if(payment != null)
                 save(payment.timestamp);
             else
                 save(AppState.getCurrentTimeDate());
             break;
            case R.id.bDelete:
                if(payment != null)
                    delete(payment.timestamp);
                else
                    Toast.makeText(this, "Payment does not exist", Toast.LENGTH_SHORT.show());
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab9_layout);

        setTitle("Add or edit payment");

        //ui
        EditText eName = (EditText) findViewById(R.id.eName);
        EditText eCost = (EditText) findViewById(R.id.eCost);
        Spinner sType = (Spinner) findViewById(R.id.sType);
        TextView tTimestamp = (TextView) findViewById(R.id.tTimestamp);

        //SPINNER
        String types = PaymentType.getColorFromPaymentType(types);

        final ArrayAdapter<String> sAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, types);
        // Specify the layout to use when the list of choices appears
        sAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        sType.setAdapter(sAdapter);

        //initialize UI

       Payment payment = AppState.get().getCurentPayment();
        if (payment != null)
        {
            eName.setText(payment.getName());
            eCost.setText(String.valueOf(payment.getCost()));
            tTimestamp.setText("Time of payment " + payment.timestamp);

            try{
                sType.setSelection(Arrays.asList(types).indexOf(payment.getType()));
            } catch (Exception e ) {

            }
        } else {
            tTimestamp.setText("");
        }

        AdapterView<Adapter> listPayments = null;
        listPayments.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick (AdapterView<?> adapterView, View view, int i, long l ){
                AppState.get().setCurrentPayment(payments.get(i));
                startActivity(new Intent(getApplicationContext(), AddPaymentActivity.class));
            }
        });
    }
}