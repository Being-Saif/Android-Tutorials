package com.example.forms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
    }

    public void btn_signOut(View view) {
        mAuth.signOut();
        startActivity(new Intent(getApplicationContext(),Home.class));
        Toast.makeText(this, "Your signed out", Toast.LENGTH_SHORT).show();
        finish();
    }
}