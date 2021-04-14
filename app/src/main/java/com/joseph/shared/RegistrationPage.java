package com.joseph.shared;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationPage extends AppCompatActivity {
    EditText name, contact, dob;

    Button insert;
    DBhelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);


        //Initializing the edit texts
        name = findViewById(R.id.name);
        contact = findViewById(R.id.contact);
        dob = findViewById(R.id.dob);


        //Initializing the register button and DB object
        insert = findViewById(R.id.btnInsert);
        DB = new DBhelper(this);

// On click listener for register specifying what should happen upon registration
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String contactTXT = contact.getText().toString();
                String dobTXT = dob.getText().toString();

                Boolean checkinsetdata = DB.insertdata(nameTXT,contactTXT,dobTXT);
                if(checkinsetdata == true)
                    Toast.makeText(RegistrationPage.this,"Data Inserted",Toast.LENGTH_LONG).show();

                else  Toast.makeText(RegistrationPage.this,"Error",Toast.LENGTH_LONG).show();

            }
        });


    }

}