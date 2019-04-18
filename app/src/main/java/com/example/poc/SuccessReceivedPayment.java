package com.example.poc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.poc.dashboard.dashboard_Activity;

public class SuccessReceivedPayment extends AppCompatActivity {
Button btnAllDone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_received_payment);
        btnAllDone = (Button)findViewById(R.id.btnAllDone);

        btnAllDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SuccessReceivedPayment.this, dashboard_Activity.class));
            }
        });


    }
}
