package com.example.poc;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.poc.Entity.MerchantEntity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.net.URI;
import java.util.UUID;

public class About_US extends AppCompatActivity {

    private EditText yearEstablish, NoEmployee;
    private TextInputEditText etAboutUs;
    private ImageView comLogo;
    private Button submit, uploadLogo;

    private FirebaseStorage storage;
    private StorageReference storageReference;
    private FirebaseAuth auth;
    private FirebaseDatabase database;
    private DatabaseReference merchantRef;
    public static final int PICK_IMAGE_REQUEST = 1;
    private Uri filePath;
    private Uri url;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null){
            final Uri imageUri = data.getData();
            filePath = imageUri;
            comLogo.setImageURI(filePath);
        }
        else {
            Toast.makeText(getApplicationContext(),"Please select file", Toast.LENGTH_SHORT).show();
        }
    }
    private void uploadImage() {

        if(filePath != null)
        {
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();

            StorageReference ref = storageReference.child("images/"+ UUID.randomUUID().toString());
            ref.putFile(filePath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            progressDialog.dismiss();
                            Toast.makeText(About_US.this, "Uploaded", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressDialog.dismiss();
                            Toast.makeText(About_US.this, "Failed "+e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0*taskSnapshot.getBytesTransferred()/taskSnapshot
                                    .getTotalByteCount());
                            progressDialog.setMessage("Uploaded "+(int)progress+"%");
                        }
                    });
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        merchantRef = database.getReference("MerchantEntity");

        comLogo = findViewById(R.id.LogoView);
        yearEstablish = findViewById(R.id.etYear);
        etAboutUs = findViewById(R.id.Abouttxt);
        NoEmployee = findViewById(R.id.etNoEmployee);
        uploadLogo = findViewById(R.id.btnUpload);
        submit = findViewById(R.id.btnSubmit);

//
//        final String Year = yearEstablish.getText().toString().trim();
//        final String aboutUs = etAboutUs.getText().toString().trim();
//        final String NoOfEmp = NoEmployee.getText().toString().trim();

        //Register Activity
        Intent b = this.getIntent();
        final String mercName = b.getStringExtra("mName");
        final String mercBusiNo = b.getStringExtra("businessReg");
        final String mercAddr = b.getStringExtra("mAdds");
        final String mercEmail = b.getStringExtra("mEmail");
        final String mercPass = b.getStringExtra("mPass");


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
                    ActivityCompat.requestPermissions(About_US.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 3);
                }
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(filePath == null){
                    Toast.makeText(About_US.this, "Please upload company Logo!",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(yearEstablish.getText().toString())){
                    Toast.makeText(About_US.this, "Please enter your company establish year!",Toast.LENGTH_SHORT).show();
                    return;
                }
                String aboutComp = etAboutUs.getText().toString();
                if(TextUtils.isEmpty(aboutComp)){
                    Toast.makeText(About_US.this, "Please describe about your company!",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(NoEmployee.getText().toString())){
                    Toast.makeText(About_US.this, "Please enter the number of staff!",Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(About_US.this, Services.class);
                intent.putExtra("mName", mercName);
                intent.putExtra("businessReg", mercBusiNo);
                intent.putExtra("mAdds",mercAddr);
                intent.putExtra("mEmail",mercEmail);
                intent.putExtra("mPass",mercPass);

                intent.putExtra("yearEst", yearEstablish.getText().toString());
                intent.putExtra("AboutUs", etAboutUs.getText().toString());
                intent.putExtra("NoOfEmp", NoEmployee.getText().toString());
                startActivity(intent);

                uploadImage();
            }
        });
    }

}