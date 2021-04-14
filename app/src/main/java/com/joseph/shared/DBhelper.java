package com.joseph.shared;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBhelper extends SQLiteOpenHelper {
    //Define the name of the database here called userdata.db
    public static final String DATABASE_NAME = "userdata.db";


    public DBhelper(@Nullable Context context)
    {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB)
    {
//Creating table and its attributes
        DB.execSQL("create Table userdetails(motherName Text,childName Text, NRC INT primary key)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if  exists Userdetails ");

    }

    // method for inserting data into the database
    public  Boolean insert_data (String motherName, String childName, String NRC){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",motherName);
        values.put("contact",childName);
        values.put("dob",NRC);
        getdata();
        long result = DB.insert("userdetails",null, values);
        return result != -1;
    }


    //Retrieving data method
    public Cursor getdata(){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from Userdetails",null);
        cursor.moveToFirst();
        return cursor;
    }

}
