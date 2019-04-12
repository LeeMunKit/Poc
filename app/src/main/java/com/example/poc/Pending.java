package com.example.poc;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.poc.Entity.ApproveEntity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Pending extends AppCompatActivity {

    private ImageView pending;
    private TextView regTxt, thanktxt, staytxt, documenttxt, receivetxt, apprvtxt;
    private Button done;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending);

        pending = findViewById(R.id.pendingView);
        regTxt = findViewById(R.id.regComplete);
        thanktxt = findViewById(R.id.thanksTxt);
        staytxt = findViewById(R.id.stayTxt);
        documenttxt = findViewById(R.id.docTxt);
        receivetxt = findViewById(R.id.receiveTxt);
        done = findViewById(R.id.btnDone);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Pending.this, Login_Activity.class));
                finish();

            }
        });

    }
}
