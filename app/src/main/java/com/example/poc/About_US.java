package com.example.poc;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.poc.Entity.MerchantEntity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class About_US extends AppCompatActivity {

    private EditText yearEstablish, NoEmployee;
    private TextInputEditText etAboutUs;
    private ImageView comLogo;
    private Button submit, uploadLogo;
    private FirebaseAuth auth;
    private FirebaseDatabase database;
    private DatabaseReference merchantRef;
    public static final int PICK_IMAGE_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        merchantRef = database.getReference("MerchantEntity");

        comLogo = findViewById(R.id.LogoView);
        yearEstablish = findViewById(R.id.etYear);
        etAboutUs = findViewById(R.id.Abouttxt);
        NoEmployee = findViewById(R.id.etNoEmployee);
        uploadLogo = findViewById(R.id.btnUpload);
        submit = findViewById(R.id.btnSubmit);


        final String Year = yearEstablish.getText().toString();
        final String aboutUs = etAboutUs.getText().toString();
        final String NoOfEmp = NoEmployee.getText().toString();

        //Register Activity
//        Bundle bundle = getIntent().getExtras();
//        final String mercName = bundle.getString("mName");
//        final String mercBusiNo = bundle.getString("businessReg");
//        final String mercAddr = bundle.getString("mAddr");
//        final String mercEmail = bundle.getString("mEmail");
//        final String mercPass = bundle.getString("mPass");

//        Intent b = this.getIntent();
        Bundle b = getIntent().getExtras();
        final String mercName = b.getString("mName");
        final String mercBusiNo = b.getString("businessReg");
        final String mercAddr = b.getString("mAdds");
        final String mercEmail = b.getString("mEmail");
        final String mercPass = b.getString("mPass");

        uploadLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ContextCompat.checkSelfPermission(About_US.this,
                        Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(intent, PICK_IMAGE_REQUEST);
                }
                else {
                    ActivityCompat.requestPermissions(About_US.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},9);
                }
            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(aboutUs == null){
                    Toast.makeText(About_US.this, "Please describe about your company",Toast.LENGTH_SHORT).show();
                    return;
                }

                auth.createUserWithEmailAndPassword(mercEmail, mercPass).addOnCompleteListener(About_US.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            Toast.makeText(About_US.this, "Authentication failed!\n" + task.getException().getLocalizedMessage(),
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            FirebaseUser merchant = auth.getCurrentUser();
                            MerchantEntity.LogFirebase(merchantRef, mercName, mercBusiNo, mercAddr, mercEmail, merchant.getUid(), Year, aboutUs, NoOfEmp);
                            startActivity(new Intent(About_US.this, MainActivity.class));
                            finish();
                        }
                    }
                });

            }
        });

    }
}

