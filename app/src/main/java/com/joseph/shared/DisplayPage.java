package com.joseph.shared;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DisplayPage extends AppCompatActivity {
    //variables
    ListView listView;
    ArrayList<String> listItem;
    ArrayAdapter adapter;
    DBhelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_page);

        //Initializing variables
        listView = findViewById(R.id.myListView);
        DB = new DBhelper(this);
        listItem = new ArrayList<>();

        viewData();


    }

 //method for displaying stored data
    private void viewData() {
        Cursor cursor = DB.getdata();
        if(cursor.getCount()==0){
            Toast.makeText(DisplayPage.this,"Error",Toast.LENGTH_LONG).show();
        } else {
            while (cursor.moveToNext()){
                listItem.add("Province:" + "\t" + "Eastern");
                listItem.add("District:" + "\t" + "Katete");
                listItem.add("Village:" + "\t" + "Kasongo");
                listItem.add("Chief:" + "\t" + "Kathumba");
                listItem.add("Mothers Name:" + "\t" + cursor.getString(0));
                listItem.add("Child`s Name:" + "\t" + cursor.getString(1));
                listItem.add("Mothers NRC:" + "\t" + cursor.getString(2)+"\n\n");


            }
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listItem);
            listView.setAdapter(adapter);
        }
    }



}
