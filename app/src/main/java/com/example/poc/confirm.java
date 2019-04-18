package com.example.poc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


import com.example.poc.Entity.service_Info;
import com.example.poc.Quote.TJobDetails1;
import com.example.poc.Quote.quote;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class confirm extends AppCompatActivity {
ImageView detailsImg;
    DatabaseReference service_Info1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        final String TestCurrentUser;
        TestCurrentUser = "ggggjhjh";
        service_Info1 = FirebaseDatabase.getInstance().getReference().child("service_Info").child(TestCurrentUser);
        detailsImg = (ImageView)findViewById(R.id.detailsImg);

        Intent quote = getIntent();
        final String ServiceID=  quote.getStringExtra("ServiceID");
        final String furtherStatus=  quote.getStringExtra("furtherStatus");
        final String status=  quote.getStringExtra("status");
        final String addressInfo=  quote.getStringExtra("addressInfo");
        final String JobName=  quote.getStringExtra("JobName");
        final String NoOfGuard=  quote.getStringExtra("NoOfGuard");
        final String theDate=  quote.getStringExtra("theDate");

        System.out.println("Services ID3:"+ServiceID+":End");
        detailsImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                startActivity(new Intent(confirm.this, TJobDetails1.class));
            }
        });

    }
}
