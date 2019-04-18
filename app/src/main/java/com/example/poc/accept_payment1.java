package com.example.poc;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.example.poc.Entity.service_Info;
import com.example.poc.dashboard.dashboard_Activity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class accept_payment1 extends AppCompatActivity {
ImageView detailsImg;
    DatabaseReference service_Info1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accept_payment1);

        final String TestCurrentUser;
        TestCurrentUser = "ggggjhjh";
        service_Info1 = FirebaseDatabase.getInstance().getReference().child("service_Info").child(TestCurrentUser);
        Intent quote = getIntent();
        final String ServiceID=  quote.getStringExtra("ServiceID");
        final String furtherStatus=  quote.getStringExtra("furtherStatus");
        final String status=  quote.getStringExtra("status");
        final String addressInfo=  quote.getStringExtra("addressInfo");
        final String JobName=  quote.getStringExtra("JobName");
        final String NoOfGuard=  quote.getStringExtra("NoOfGuard");
        final String theDate=  quote.getStringExtra("theDate");

        System.out.println("Services ID3:"+ServiceID+":End");
        detailsImg = (ImageView)findViewById(R.id.detailsImg);

        detailsImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                service_Info1.addValueEventListener(new ValueEventListener(){

                    public void onDataChange(DataSnapshot dataSnapshot) {



                        //service_Info user = dataSnapshot.child(ServiceID.toString()).getValue(service_Info.class);

                        if(status.equals("booked")) {

                            service_Info SInfo = new service_Info("ggggjhjh", ServiceID, "Armed", "Foreigners", "past", NoOfGuard, addressInfo, theDate, JobName, "");

                            service_Info1.child(ServiceID).setValue(SInfo);
//                        System.out.println("tEST USER GET:"+user.getServiceID().toString()+":eND");
                            //    System.out.println("tEST USER GET:"+user.getNoOfPax().toString()+":eND");
                        }else{

                        }


                        return;







                    }
                    public void onCancelled(DatabaseError databaseError){

                    }
                });
                startActivity(new Intent(accept_payment1.this, Send_receipt.class));

            }
        });

    }
}
