package com.example.forms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_form extends AppCompatActivity {
    EditText lemail,lpass;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);
        getSupportActionBar().setTitle("Login Form");
        lemail = findViewById(R.id.lemail);
        lpass = findViewById(R.id.lpass);
        mAuth = FirebaseAuth.getInstance();

    }

    public void btn_signupform(View view) {
        startActivity(new Intent(getApplicationContext(),Signup_form.class));
    }

    public void btn_login(View view) {
        String email = lemail.getText().toString().trim();
        String password = lpass.getText().toString().trim();
         if(TextUtils.isEmpty(email)){
             Toast.makeText(this, "Please fill the email Correctly", Toast.LENGTH_SHORT).show();
             return;
         }

         if(TextUtils.isEmpty(password)){
             Toast.makeText(this, "Please fill the password correctly", Toast.LENGTH_SHORT).show();
             return;
         }

         if(password.length()<6){
             Toast.makeText(this, "Password is too short", Toast.LENGTH_SHORT).show();
             return;

         }
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(Login_form.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));

                        } else {
                            Toast.makeText(Login_form.this, "User is not available for this configuration", Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });


    }

    public void forgot(View view) {
        startActivity(new Intent(getApplicationContext(),forgot.class));
    }
}