package com.example.android.thechallenge;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by TOSHIBA on 6/29/2018.
 */

//Will be using email to identify a user uniquely

public class DatabaseActivities {
//    Changed firebase to public static and the others to public
    public  FirebaseDatabase mFirebaseDatabase;
    public DatabaseReference mref;
    public FirebaseAuth mAuth;
    public static final String UPDATE_DATABASE = "updating the database";
    public String Id;

//    Will need to do modifications since the user object will have to be created from the
//    data entered

    public void insert(String action) {
//        This is now the code necessary for obtaining the data from the other previous activity
//        Will have to check the action before proceeding

        if (UPDATE_DATABASE.equals(action)) {
            mFirebaseDatabase = FirebaseDatabase.getInstance();
            mref = mFirebaseDatabase.getReference();
            mAuth = FirebaseAuth.getInstance();

            if (mAuth.getCurrentUser() != null) {
                FirebaseUser user = mAuth.getCurrentUser();
                 Id = user.getUid();
                Log.d("USER", "there is a user");
            }

//            about to add the data from the sharedPreference
            TheUser maggie = new TheUser();
            String title = maggie.getTitle();
            String thoughts = maggie.getThoughts();
            maggie.setTitle(title);
            maggie.setTitle(thoughts);

            Log.d("Firebase","Checking whethter data has been added");
//            Added push to the db reference
//            the set value is supposed to be the java object
            mref.child("users").child("email").push().setValue(maggie).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid)
                {
                    Log.d("Firebase","Data has been succesfully added");
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.d("Firebase","No data added");
                }
            });


        }
    }
}
