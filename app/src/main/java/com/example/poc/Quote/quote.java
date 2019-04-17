package com.example.poc.Quote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.poc.R;

public class quote extends AppCompatActivity {
    private TextView jobdetail, quoteTxt;
    private ImageView details;
    private EditText amount;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote);

        jobdetail = findViewById(R.id.jobTxt);
        quoteTxt = findViewById(R.id.quoteTxt);
        details = findViewById(R.id.detailsImg);
        amount = findViewById(R.id.etAmt);
        submit = findViewById(R.id.btnSubmit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(quote.this, TJobDetails1.class));
            }
        });
    }
}
