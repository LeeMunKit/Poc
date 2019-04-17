package com.example.poc;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.poc.Entity.MerchantEntity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class  Registration_Activity extends AppCompatActivity {
    private TextView joinUs, companyDetails, companyInfo, DocumentUpload, ic;
    private EditText compName,compEmail,compPass,regNo,compAddr,postCode,state,summary;

    private ImageButton icBtn;
    private Button docBtn, logoBtn, submitBtn;

    private FirebaseDatabase database;
    private FirebaseAuth auth;
    private DatabaseReference merchantRef;
    public static final int PICK_IMAGE_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        merchantRef = database.getReference("MerchantEntity");

        joinUs = findViewById(R.id.joinTxt);
        companyDetails = findViewById(R.id.fillInTxt);
        companyInfo = findViewById(R.id.CompanyTxt);
        DocumentUpload = findViewById(R.id.documentTxt);
        ic = findViewById(R.id.IcTxt);

        compName = findViewById(R.id.etCompName);
        compEmail = findViewById(R.id.etEmail);
        compPass = findViewById(R.id.etPassword);
        regNo = findViewById(R.id.etRegNo);
        compAddr = findViewById(R.id.etCompAdrress);
        postCode = findViewById(R.id.etPostcode);
        state = findViewById(R.id.etState);
        summary = findViewById(R.id.etSummary);

        icBtn = findViewById(R.id.ic_btn);
        docBtn = findViewById(R.id.DocBtn);
        logoBtn = findViewById(R.id.logoBtn);
        submitBtn = findViewById(R.id.submitBtn);

        icBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            }
        });

        docBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ContextCompat.checkSelfPermission(Registration_Activity.this,
                        Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(intent, PICK_IMAGE_REQUEST);
                }
                else {
                    ActivityCompat.requestPermissions(Registration_Activity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 3);
                }
            }
        });
        logoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ContextCompat.checkSelfPermission(Registration_Activity.this,
                        Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(intent, PICK_IMAGE_REQUEST);

                }
                else {
                    ActivityCompat.requestPermissions(Registration_Activity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 3);
                }
            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = compName.getText().toString().trim();
                final String email = compEmail.getText().toString().trim();
                String password = compPass.getText().toString().trim();
                final String regisNo = regNo.getText().toString().trim();
                final String address = compAddr.getText().toString().trim();
                final String postcode = postCode.getText().toString().trim();
                final String State = state.getText().toString().trim();
                final String compSummary = summary.getText().toString().trim();
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(Registration_Activity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            Toast.makeText(Registration_Activity.this, "Authentication failed!\n" + task.getException().getLocalizedMessage(),
                                    Toast.LENGTH_SHORT).show();
                            //Log.i("test123", task.getException().getLocalizedMessage());
                        } else {
                            FirebaseUser merchant = auth.getCurrentUser();
                            MerchantEntity.LogFirebase(merchantRef, name, email, regisNo, address, postcode, State, compSummary, merchant.getUid());
                            startActivity(new Intent(Registration_Activity.this, Pending.class));
                            finish();
                        }
                    }
                });
            }
        });


    }


}
