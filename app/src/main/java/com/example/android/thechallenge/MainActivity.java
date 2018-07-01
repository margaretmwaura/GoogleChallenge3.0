package com.example.android.thechallenge;

import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Intent;
import android.content.Loader;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String[]>{


//    Get a reference to the recyclerView and the Adapter

    private RecyclerView recyclerView;
    private TheJournalAdpater theJounalAdapter;
    public static final int LOADER_ID = 22;
    public String Id;
   String[] results;

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

        theJounalAdapter = new TheJournalAdpater(this);
//        this code is for setting the adapter of the recyclerView
        recyclerView.setAdapter(theJounalAdapter);

        FloatingActionButton fabButton = findViewById(R.id.fab);

        //        Getting the intent and the account Id
        Intent i = getIntent();
        Id = i.getStringExtra("theUserId");

        fabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new intent to start an AddTaskActivity
                Intent addTaskIntent = new Intent(MainActivity.this, AddAThought.class).putExtra("theAccountId",Id);
                startActivity(addTaskIntent);
            }
        });

//        getting the loaderManager
        LoaderManager loaderManager = getLoaderManager();
        Loader<String[]> dbSearchLoader = loaderManager.getLoader(LOADER_ID);


        if (dbSearchLoader == null) {
            loaderManager.initLoader(LOADER_ID, null, this);
        } else {
            loaderManager.restartLoader(LOADER_ID, null, this);
        }

    }





    @Override
    public Loader<String[]> onCreateLoader(int id, final Bundle args)
    {
       return new AsyncTaskLoader<String []>(this)
       {
//           There is no need for the onStartLoading function since there is no bundle arguments
           @Override
           public String[] loadInBackground()
           {
               DatabaseActivities db = new DatabaseActivities();
               results = db.queryResult();
               return results;
           }

       };

    }

    @Override
    public void onLoadFinished(Loader<String[]> loader, String data[])
    {

    }

    @Override
    public void onLoaderReset(Loader<String[]> loader)
    {

    }
}
