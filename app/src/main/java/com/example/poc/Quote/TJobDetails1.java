package com.example.poc.Quote;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.poc.dashboard.dashboard_Activity;
import com.example.poc.R;

public class TJobDetails1 extends AppCompatActivity {
    private Button view, quote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tjob_details1);

        view = findViewById(R.id.button);
        quote = findViewById(R.id.button2);

        quote.setPaintFlags(quote.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TJobDetails1.this, dashboard_Activity.class));
            }
        });
    }
}
