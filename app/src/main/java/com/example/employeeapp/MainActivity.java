package com.example.employeeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
AppCompatButton b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(AppCompatButton) findViewById(R.id.emp);
        b2=(AppCompatButton) findViewById(R.id.search);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(getApplicationContext(),EmployeesearchActivity.class);
                startActivity(a);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),EmployeeActivity.class);
                startActivity(i);

            }
        });

    }
}