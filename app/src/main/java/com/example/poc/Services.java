package com.example.poc;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.poc.Entity.MerchantEntity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Services extends AppCompatActivity {

    private CheckBox service1, service2, service3;
    private Button submit;
    private FirebaseAuth auth;
    private FirebaseDatabase database;
    private DatabaseReference merchantRef;

    String checkboxTxt = null;
    String checkboxTxt2 = null;
    String checkboxTxt3 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        merchantRef = database.getReference("MerchantEntity");

        service1 = findViewById(R.id.Service1);
        service2 = findViewById(R.id.Service2);
        service3 = findViewById(R.id.Service3);
        submit = findViewById(R.id.btnSubmit);

        Intent b = this.getIntent();
        final String mercName = b.getStringExtra("mName");
        final String mercBusiNo = b.getStringExtra("businessReg");
        final String mercAddr = b.getStringExtra("mAdds");
        final String mercEmail = b.getStringExtra("mEmail");
        final String mercPass = b.getStringExtra("mPass");

        final Uri uri = b.getParcelableExtra("imageUrl");
//        System.out.println("Test Url2:"+uri+":End.");
        final String yrEstablish = b.getStringExtra("yrEstablish");
        final String review = b.getStringExtra("AboutUs");
        final String NoofEmp = b.getStringExtra("NoOfEmp");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(service1.isChecked()){
                    checkboxTxt = "Bodyguard";
                }
                if(service2.isChecked()){
                    checkboxTxt2  = "Arm Guard";
                }
                if(service3.isChecked()){
                    checkboxTxt3 = "Security Guard";
                }

            }

        });
    }
}
