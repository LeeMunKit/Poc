package com.example.poc;

import android.content.Intent;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.poc.dashboard.dashboard_Activity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseNetworkException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

public class Login_Activity extends AppCompatActivity {
    private TextView welcomeTxt, loginTxt, NoAccTxt;
    private EditText username, password;
    private Button forgotPassBtn, loginBtn, registerBtn;
    private ImageView appImg, fingerImg;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);

        auth = FirebaseAuth.getInstance();
        welcomeTxt = findViewById(R.id.welcomeTxt);
        loginTxt = findViewById(R.id.logInView);
        NoAccTxt = findViewById(R.id.NoAccTxt);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        forgotPassBtn = findViewById(R.id.forgotBtn);
        loginBtn = findViewById(R.id.loginBtn);
        registerBtn = findViewById(R.id.regBtn);

        appImg = findViewById(R.id.imgApp);
        fingerImg = findViewById(R.id.fingerImg);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = username.getText().toString();
                final String pass = password.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(pass)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }
                auth.signInWithEmailAndPassword(email, pass)
                        .addOnCompleteListener(Login_Activity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    // there was an error
                                    if (pass.length() < 6) {
                                        password.setError(getString(R.string.minimum_password));
                                    } else {
                                        try {
                                            throw task.getException();
                                        } catch(FirebaseNetworkException e) {
                                            Toast.makeText(Login_Activity.this, "Please check your network connection", Toast.LENGTH_SHORT).show();
                                        } catch (FirebaseAuthInvalidUserException e) {
                                            Toast.makeText(Login_Activity.this, "Email doesn't exist", Toast.LENGTH_SHORT).show();
                                        } catch (FirebaseAuthInvalidCredentialsException e) {
                                            Toast.makeText(Login_Activity.this, "Invalid password", Toast.LENGTH_SHORT).show();
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                } else {
                                    Intent intent = new Intent(Login_Activity.this, dashboard_Activity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });
            }
        });
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerBtn.setPaintFlags(registerBtn.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                startActivity(new Intent(Login_Activity.this, Registration_Activity.class));
            }
        });

//        forgotPassBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(Login_Activity.this, ResetPasswordActivity.class));
//            }
//        });

    }
}
