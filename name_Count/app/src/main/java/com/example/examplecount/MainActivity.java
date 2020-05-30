package com.example.examplecount;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    int i = 0;
    EditText name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        name=findViewById(R.id.name);
    }

    public void Toast(View view) {
        String n = name.getText().toString();
        Toast.makeText(this, "Welcome to the Android Studio "+n, Toast.LENGTH_SHORT).show();
    }

    public void count(View view) {
        String n = name.getText().toString();
        i++;
        tv.setText(n+":" +i);

    }

    public void DeCount(View view) {
        String n = name.getText().toString();
        i--;
        tv.setText(n+":" +i);
    }


}
