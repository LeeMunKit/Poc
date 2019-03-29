package com.example.poc;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.poc.Entity.MerchantEntity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    private EditText CompanyName, businessReg, address, email, password;
    private Button next1;
    private FirebaseDatabase database;
    private FirebaseAuth auth;
    private DatabaseReference merchantRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        merchantRef = database.getReference("MerchantEntity");

//        if (auth.getCurrentUser()!= null){
//            startActivity(new Intent(Register.this, Document.class));
//        }

        CompanyName = findViewById(R.id.etName);
        businessReg = findViewById(R.id.etBusinessReg);
        address = findViewById(R.id.etAddress);
        email = findViewById(R.id.etEmail);
        password = findViewById(R.id.etPassword);
        next1 = findViewById(R.id.btnNext);

        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String merchantName = CompanyName.getText().toString().trim();
                final String merchantAdds = address.getText().toString().trim();
                final String businessRegNo = businessReg.getText().toString().trim();
                final String merchantEmail = email.getText().toString().trim();
                final String merchantPass = password.getText().toString().trim();

                if (TextUtils.isEmpty(merchantName)) {
                    Toast.makeText(getApplicationContext(), "Please Enter Company Name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(businessRegNo)) {
                    Toast.makeText(getApplicationContext(), "Please Enter businessRegNo", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(merchantAdds)) {
                    Toast.makeText(getApplicationContext(), "Please enter address", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(merchantEmail)) {
                    Toast.makeText(getApplicationContext(), "Please enter email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (merchantPass.length() < 8) {
                    Toast.makeText(getApplicationContext(), "Please enter at least 8 characters", Toast.LENGTH_SHORT).show();
                    return;
                }
               Intent intent = new Intent(Register.this, Document.class);
//                Bundle bundle = new Bundle();
//                bundle.putString("mName",CompanyName.getText().toString().trim());
//                bundle.putString("businessReg", businessReg.getText().toString().trim());
//                bundle.putString("mAdds",address.getText().toString().trim());
//                bundle.putString("mEmail",email.getText().toString().trim());
//                bundle.putString("mPass",password.getText().toString().trim());

                intent.putExtra("mName",CompanyName.getText().toString());
                intent.putExtra("businessReg", businessReg.getText().toString());
                intent.putExtra("mAdds",address.getText().toString());
                intent.putExtra("mEmail",email.getText().toString());
                intent.putExtra("mPass",password.getText().toString());
                startActivity(intent);


            }
        });
//                auth.createUserWithEmailAndPassword(merchantEmail, merchantPass).addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (!task.isSuccessful()) {
//                            Toast.makeText(Register.this, "Authentication failed!\n" + task.getException().getLocalizedMessage(),
//                                    Toast.LENGTH_SHORT).show();
//                        } else {
//                            FirebaseUser merchant = auth.getCurrentUser();
//                            MerchantEntity.LogFirebase(merchantRef, merchantName, businessRegNo, merchantAdds, merchantEmail, merchant.getUid());
//                            startActivity(new Intent(Register.this, Document.class));
//                            finish();
//                        }
//                    }
//                });

//            }
//    });
    }
}
