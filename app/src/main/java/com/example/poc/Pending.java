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
    private TextView description, pendingtxt, approvetxt;
    private Button done;
    private Integer Status;

    private String userId;
    private FirebaseDatabase database;
    private DatabaseReference userRef, approveRef;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending);

        pendingtxt = findViewById(R.id.pendingTxt);
        pending = findViewById(R.id.pendingView);
        description = findViewById(R.id.txtPending);
        done = findViewById(R.id.btnDone);

        userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        database = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();
        userRef = database.getReference("MerchantEntity");
        approveRef = database.getReference("ApproveEntity");

        Status = 1;
        if(Status == 1) {
            pendingtxt.setVisibility(View.VISIBLE);
        }
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child(auth.getCurrentUser().getUid());
                ApproveEntity.LogFirebase(approveRef, userRef, userId, Status);
//                System.out.println("Testing111:"+Status+":End.");
                startActivity(new Intent(Pending.this, MainActivity.class));
                finish();

            }
        });

    }
}
