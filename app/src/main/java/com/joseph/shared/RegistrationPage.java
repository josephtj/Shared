package com.joseph.shared;


import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationPage extends AppCompatActivity {
    EditText motherName, childName, NRC;
    Button register;
    DBhelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);



        //Initializing the edit texts
        motherName = findViewById(R.id.motherName);
        childName = findViewById(R.id.childName);
        NRC = findViewById(R.id.NRC);


        //Initializing the register button and DB object
        register = findViewById(R.id.register);
        DB = new DBhelper(this);

// On click listener for register specifying what should happen upon registration
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String motherString = motherName.getText().toString();
                String childString = childName.getText().toString();
                String nrcString = NRC.getText().toString();

                Boolean check_inserted_data = DB.insert_data(motherString,childString,nrcString);
                if(check_inserted_data == true)
                {
                    Toast.makeText(RegistrationPage.this,"Registration complete!!!",
                            Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(RegistrationPage.this, DashBoardActivity.class);
                    startActivity(intent);
                }

            }
        });


    }

}

