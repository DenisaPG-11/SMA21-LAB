package com.upt.cti.smartwallet;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class AppState {
    private static AppState singletoneObject;

    public static synchronized AppState get() {
        if(singletoneObject == null)
            singletoneObject = new AppState();

        return singletoneObject;
    }

    private DatabaseReference databaseReference;

    private Payment currentPayment;

    public DatabaseReference getDatabaseReference(){
        return databaseReference;
    }

    public void setDatabaseReference (DatabaseReference databaseReference){
        this.databaseReference = databaseReference;
    }

    public void setCurrentPayment (Payment currentPayment){
        this.currentPayment = currentPayment;
    }

    public Payment getCurrentPayment() {
        return currentPayment;
    }

    public void updateLocalBackup (Context context, Payment payment, boolean toAdd){

        String fileName = payment.timestamp;

        try {
            if(toAdd) {
                //save
                //Saving of object in a file
                FileOutputStream file = new FileOutputStream(fileName);
                ObjectOutputStream out = new ObjectOutputStream(file);

                // Method for serialization of object
                out.writeObject(payment);

                out.close();
                file.close();
            }
            else {
                context.deleteFile(fileName);
            }
        }catch (IOException e) {
            Toast.makeText(context, "Cannot acces local data", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean hasLocalStorage(Context context){
        return context.getFilesDir().listFiles().length > 0 ;
    }

    public List<Payment> loadFromLocalBackup (Context context, String currentMonth){

        try {
            List<Payment> payments =  new ArrayList<>();

            for(File file : context.getFilesDir().listFiles()){
                if (){

                    if(){
                        payments.add(payment);
                    }
                }
            }

        }catch  (IOException e){
            Toast.makeText(context, "Cannot acces local data", Toast.LENGTH_SHORT).show();
        }catch (ClassNotFoundException e ) {
            e.printStackTrace();
        }

    }

    public static boolean isNetworkAvailable(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager)  context.getSystemService(context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
