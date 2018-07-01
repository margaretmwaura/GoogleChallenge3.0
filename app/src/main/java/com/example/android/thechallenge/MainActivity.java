package com.example.android.thechallenge;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MainActivity extends AppCompatActivity {


//    Get a reference to the recyclerView and the Adapter

    private RecyclerView recyclerView;
    private TheJournalAdpater theJounalAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //        get the recyclerView

        recyclerView = (RecyclerView) findViewById(R.id.recycler);

//        this is the code for creating of the layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

//        Set the layoutManager of the recyclerView
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        theJounalAdapter = new TheJournalAdpater();
//        this code is for setting the adapter of the recyclerView
        recyclerView.setAdapter(theJounalAdapter);

        FloatingActionButton fabButton = findViewById(R.id.fab);

        fabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new intent to start an AddTaskActivity
                Intent addTaskIntent = new Intent(MainActivity.this, AddAThought.class);
                startActivity(addTaskIntent);
            }
        });
    }


}
