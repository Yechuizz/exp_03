package com.example.exp_03;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class AlertDialogDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog_demo);
    }

    public void alertDialogClick(View view){
        getLayoutInflater().inflate(R.layout.alert_dialog, null);
        View dialogView = getLayoutInflater().inflate(R.layout.alert_dialog, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setView(dialogView)
                .create()
                .show();
    }

    public void btnClick(View view){
        Intent intent = new Intent(this, XmlMenu.class);
        startActivity(intent);
    }

}