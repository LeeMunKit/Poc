package com.example.poc;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class Document extends AppCompatActivity {

    private Button next2, uploadDoc;
    private ImageButton camerabtn;
    private FirebaseAuth auth;
    private FirebaseDatabase database;
    private DatabaseReference aboutRef;
    public static final int PICK_IMAGE_REQUEST = 1;
    Uri uriImage;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null){

            final Uri imageUri = data.getData();
            uriImage = imageUri;
        }
        else {
            Toast.makeText(getApplicationContext(),"Please select file", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document);

        camerabtn = findViewById(R.id.cameraBtn);
        uploadDoc = findViewById(R.id.uploadbtn);
        next2 = findViewById(R.id.next2btn);
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        aboutRef = database.getReference("MerchantEntity");

        Intent b = this.getIntent();
        final String mercName = b.getStringExtra("mName");
        final String mercBusiNo = b.getStringExtra("businessReg");
        final String mercAddr = b.getStringExtra("mAdds");
        final String mercEmail = b.getStringExtra("mEmail");
        final String mercPass = b.getStringExtra("mPass");

        camerabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            }
        });

        uploadDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ContextCompat.checkSelfPermission(Document.this,
                        Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(intent, PICK_IMAGE_REQUEST);
                }
                else {
                    ActivityCompat.requestPermissions(Document.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},9);
                }
            }
        });

        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Document.this, About_US.class);
                intent.putExtra("mName", mercName);
                intent.putExtra("businessReg", mercBusiNo);
                intent.putExtra("mAdds",mercAddr);
                intent.putExtra("mEmail",mercEmail);
                intent.putExtra("mPass",mercPass);
                startActivity(intent);
            }
        });
    }
}
