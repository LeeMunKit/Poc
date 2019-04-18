package com.example.poc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.poc.dashboard.dashboard_Activity;

public class Send_receipt extends AppCompatActivity {
Button btnAllDone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_receipt);
        btnAllDone = (Button)findViewById(R.id.btnAllDone);


        btnAllDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Send_receipt.this,SuccessReceivedPayment.class));
            }
        });


    }
}
