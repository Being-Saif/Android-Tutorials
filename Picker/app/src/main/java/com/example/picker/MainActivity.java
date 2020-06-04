package com.example.picker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TextView tv,tv2;
    DatePickerDialog ddd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getAlert(View view) {
        AlertDialog.Builder b = new
                AlertDialog.Builder(this);
        b.setTitle("Alert");
        b.setMessage("Do you want to exit the screen ");
        b.setIcon(R.drawable.alert);
        b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        b.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        b.show();
    }

    public void datepick(View view) {
        Calendar c = Calendar.getInstance();
        int yyeaar = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dp = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                tv.setText(yyeaar+"-"+month+"-"+day);
            }
        },yyeaar,month,day);
        dp.show();


    }

    public void timepick(View view) {
        Calendar c = Calendar.getInstance();
        final int hoour = c.get(Calendar.HOUR_OF_DAY);
        final int minutee = c.get(Calendar.MINUTE);
        TimePickerDialog tp = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                tv2.setText(hourOfDay+"-"+minute);
            }
        },hoour,minutee,false);
        tp.show();
    }
}
