package com.example.android.thechallenge;

import java.util.Date;

/**
 * Created by TOSHIBA on 6/29/2018.
 */

//this is the class that will be used for data binding
public class TheUser
{
    private String Title;
    private String Thoughts;;
    private String ID;
//This are the methods for setting data
    public void setTitle(String Title)
    {
        this.Title = Title;

    }
    public void setThoughts(String Thoughts)
    {
       this.Thoughts= Thoughts;
    }

    public void setID(String ID){this.ID = ID;}

//    This are the methods for retrieving the data

    public String getTitle()
    {
        return this.Title;
    }

    public String getThoughts()
    {
        return this.Thoughts;
    }
    public String getId()
    {
        return this.ID;
    }
}
