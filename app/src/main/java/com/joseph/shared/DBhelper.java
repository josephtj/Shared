package com.joseph.shared;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBhelper extends SQLiteOpenHelper {

    //Define the name of the database here called serdata.db
    public DBhelper(@Nullable Context context) {
        super(context, "serdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {

        //Creating table and its attributes
        DB.execSQL("create Table Userdetails(name Text primary key,contact Text,dob Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if  exists Userdetails ");

    }

    // method for inserting data into the database
    public  Boolean insertdata (String name, String contact, String dob){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("contact",contact);
        contentValues.put("dob",dob);
        long result = DB.insert("Userdetails",null, contentValues);
        if(result == -1){
            return false;
        }
        else {
            return true;
        }
    }


    public  Cursor getdata(){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from Userdetails",null);
        return cursor;
    }

}
