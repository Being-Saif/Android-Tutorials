package com.example.forms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signup_form extends AppCompatActivity {
    EditText fname,uname,semail,spass,scpass;
    Button btn_sr;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_form);
        getSupportActionBar().setTitle("Signup Form");
        mAuth = FirebaseAuth.getInstance();
        fname = findViewById(R.id.fname);
        uname = findViewById(R.id.uname);
        semail = findViewById(R.id.semail);
        spass = findViewById(R.id.spass);
        scpass = findViewById(R.id.scpass);
        btn_sr = findViewById(R.id.btn_sr);
    }

    public void toasst(View view) {
        String n = fname.getText().toString();
        String p =uname.getText().toString();
        String email =semail.getText().toString();
        String password =spass.getText().toString();
        String s =scpass.getText().toString();
        String t =btn_sr.getText().toString();
        if(TextUtils.isEmpty(n)||TextUtils.isEmpty(p)||TextUtils.isEmpty(email)||TextUtils.isEmpty(password)||TextUtils.isEmpty(s))
        {
            Toast.makeText(this, "Please fill all the deatils", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.length()<6){
            Toast.makeText(this, "Password is too short", Toast.LENGTH_SHORT).show();
            return;
        }

        if(password.equals(s)){
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                Toast.makeText(Signup_form.this, "Done signed in", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(Signup_form.this, "Failed", Toast.LENGTH_SHORT).show();
                            }

                            // ...
                        }
                    });
        }


    }

    public void Login_form(View view) {
        startActivity(new Intent(getApplicationContext(),Login_form.class));
    }
}