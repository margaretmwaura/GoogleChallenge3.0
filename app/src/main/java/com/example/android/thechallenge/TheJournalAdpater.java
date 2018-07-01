package com.example.android.thechallenge;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by TOSHIBA on 6/29/2018.
 */

//for this class I will have to deal with the string that is theJournalData and the bind method
public class TheJournalAdpater extends RecyclerView.Adapter<TheJournalAdpater.theJournalViewHolder>
{

    //this specifies the number
    private String[] theJournalData;
    @NonNull
    @Override
    public theJournalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {

        //        This code is for getting the context of the viewGroup
        Context context = parent.getContext();
//        this is for getting the id of the layout with the data textView
        int id = R.layout.the_journal_list;
//        This is for inflating of the layout
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = layoutInflater.inflate(id,parent,shouldAttachToParentImmediately);
        return new theJournalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull theJournalViewHolder holder, int position)
    {
//        to be properly implemented later

    }

    @Override
    public int getItemCount() {
        if(null == theJournalData)
        {
            return 0;
        }
//        This is the correct versio
//        return theJournalData.length;
        return 3;
    }

//    this is the inner class for the viewHolder

    class theJournalViewHolder extends RecyclerView.ViewHolder
    {

//        code for the three textViews
        TextView title;
        TextView date;
        TextView data;


        public theJournalViewHolder(View itemView)
        {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.the_journal_title);
//            date = (TextView) itemView.findViewById(R.id.the_journal_date);
//            data = (TextView) itemView.findViewById(R.id.the_journal_thoughts);

        }



    }
}
