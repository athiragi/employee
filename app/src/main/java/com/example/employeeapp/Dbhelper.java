package com.example.employeeapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Dbhelper extends SQLiteOpenHelper {
    static  String Dbname="EmployeeApp.db";
    static  String TableName="Employee";
    static  String Col1="Id";
    static  String Col2="Empcode";
    static  String Col3="Empname";
    static  String Col4="Designation";
    static  String Col5="MobileNo";


    public Dbhelper(@Nullable Context context) {
        super(context, Dbname, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        String query= "create table "+TableName+"("+Col1+" integer primary key autoincrement,"+Col2+" text,"+Col3+" text,"+Col4+" text,"+Col5+" text)";
       db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String query="drop table if exists "+TableName;
        db.execSQL(query);
        onCreate(db);

    }
    public boolean insertemployee(String Empcode,String Empname,String Designation,String MobileNo){

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues content=new ContentValues();
        content.put(Col2,Empcode);
        content.put(Col3,Empname);
        content.put(Col4,Designation);
        content.put(Col5,MobileNo);
        long status=db.insert(TableName,null,content);
        if (status == -1){
            return false;
        }
        else{
            return true;
        }
    }
    public Cursor SearchEmployee(String Empcode){

        SQLiteDatabase db=this.getWritableDatabase();
        String query="select * from "+TableName+" where "+Col2+"="+"'"+Empcode+"'";
        Cursor c=db.rawQuery(query,null);
        return c;

    }

}
