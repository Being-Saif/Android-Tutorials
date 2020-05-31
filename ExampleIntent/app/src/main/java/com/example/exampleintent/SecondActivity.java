package com.example.exampleintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String name = getIntent().getStringExtra("key");
        Toast.makeText(this, "Welcome to my screen "+name, Toast.LENGTH_SHORT).show();
    }
}
