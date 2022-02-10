package com.example.employeeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EmployeesearchActivity extends AppCompatActivity {
    EditText e1,e2,e3,e4;
    AppCompatButton b1;
    String getEcode,getEname,getDes,getMob;
    Dbhelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employeesearch);
        e1=(EditText) findViewById(R.id.empcode);
        b1=(AppCompatButton) findViewById(R.id.sea);
        e2=(EditText) findViewById(R.id.empname);
        e3=(EditText) findViewById(R.id.des);
        e4=(EditText) findViewById(R.id.empmob);
        mydb=new Dbhelper(this);
        mydb.getWritableDatabase();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEcode=e1.getText().toString();
                Cursor c=mydb.SearchEmployee(getEcode);
                if (c.getCount()==0){
                    Toast.makeText(getApplicationContext(), "No Employee Found", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    while (c.moveToNext())
                    {
                        getEname=c.getString(2);
                        getDes=c.getString(3);
                        getMob=c.getString(4);
                    }
                    e2.setText(getEname);
                    e3.setText(getDes);
                    e4.setText(getMob);
                }
            }
        });

    }
}