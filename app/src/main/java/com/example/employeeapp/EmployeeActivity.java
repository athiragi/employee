package com.example.employeeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EmployeeActivity extends AppCompatActivity {
EditText e1,e2,e3,e4;
AppCompatButton b1;
String getEcode,getName,getDesignation,getMob;
Dbhelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);
        e1=(EditText) findViewById(R.id.ecode);
        e2=(EditText) findViewById(R.id.name);
        e3=(EditText) findViewById(R.id.desg);
        e4=(EditText) findViewById(R.id.mob);
        b1=(AppCompatButton) findViewById(R.id.submit);
        mydb=new Dbhelper(this);
        mydb.getWritableDatabase();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEcode=e1.getText().toString();
                getName=e2.getText().toString();
                getDesignation=e3.getText().toString();
                getMob=e4.getText().toString();
                boolean status=mydb.insertemployee(getEcode,getName,getDesignation,getMob);
                if(status==true){

                    Toast.makeText(getApplicationContext(), "Successfully Inserted", Toast.LENGTH_SHORT).show();
                }
                else
                {

                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();

                }

            }
        });

    }
}