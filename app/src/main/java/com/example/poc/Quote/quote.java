package com.example.poc.Quote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.poc.Entity.service_Info;
import com.example.poc.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class quote extends AppCompatActivity {
    private TextView jobdetail, quoteTxt;
    private ImageView details;
    private EditText amount;
    private Button submit;
    DatabaseReference service_Info1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote);
        final String TestCurrentUser;
        TestCurrentUser = "ggggjhjh";
        service_Info1 = FirebaseDatabase.getInstance().getReference().child("service_Info").child(TestCurrentUser);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        //final DatabaseReference table_user = database.getReference("User1");
        Intent quote = getIntent();
        final String ServiceID=  quote.getStringExtra("ServiceID");
        final String furtherStatus=  quote.getStringExtra("furtherStatus");
        final String status=  quote.getStringExtra("status");
        final String addressInfo=  quote.getStringExtra("addressInfo");
        final String JobName=  quote.getStringExtra("JobName");
        final String NoOfGuard=  quote.getStringExtra("NoOfGuard");
        final String theDate=  quote.getStringExtra("theDate");

        System.out.println("Services ID2:"+ServiceID+":End");

        service_Info1.addValueEventListener(new ValueEventListener(){

            public void onDataChange(DataSnapshot dataSnapshot) {



                    service_Info user = dataSnapshot.child(ServiceID.toString()).getValue(service_Info.class);



service_Info SInfo=new service_Info("ggggjhjh",ServiceID,"Armed","Foreigners",status,NoOfGuard,addressInfo,theDate,JobName,"Quoted");

                service_Info1.child(ServiceID).setValue(SInfo);
                System.out.println("tEST USER GET:"+user.getServiceID().toString()+":eND");
                System.out.println("tEST USER GET:"+user.getNoOfPax().toString()+":eND");



                            return;







            }
            public void onCancelled(DatabaseError databaseError){

            }
        });


//---
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
