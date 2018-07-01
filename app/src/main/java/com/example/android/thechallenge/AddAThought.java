package com.example.android.thechallenge;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

public class AddAThought extends AppCompatActivity{

//    this is the String that will be representing the email
    String Email = "dummy";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_athought);
//Get the Edit-Texts
        EditText title = (EditText) findViewById(R.id.the_thoughts_title);

        EditText thoughts = (EditText) findViewById(R.id.the_thoughts_data);

        final String theTitle = title.getText().toString();
        final String theThoughts = thoughts.getText().toString();

//The date will be auto-generated


//        this is for the clicking of the add button
         Button add =(Button) findViewById(R.id.add);

//Do the setting of the usersdata
        TheUser maggie = new TheUser();
        maggie.setTitle(theTitle);
        maggie.setThoughts(theThoughts);


          add.setOnClickListener(new View.OnClickListener() {

              String action = "AddingToDatabase";
            @Override
            public void onClick(View view) {
                // Create a new intent to start an intent Service
//                Inturn the intent Service will trigger the database activity
//                the particular activity is to add an entry to the journal
//                the activity to be triggered will correspond to the action
                Intent addTaskIntent = new Intent(AddAThought.this,TheIntentService.class)
                        .setAction(DatabaseActivities.UPDATE_DATABASE);
                     startService(addTaskIntent);
                     Log.d("Intent", "Intent Service started");
//
            }
        });
    }

    }

