package com.example.will.achieve;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONObject;

public class Comment {

    public int id;
    public String poster;
    public String comment;

    public Comment(int id, String poster, String comment)
    {
        this.id = id;
        this.poster = poster;
        this.comment = comment;
    }

    public Comment(JSONObject json)
    {
        try {
            this.id = json.getInt("id");
            this.poster = json.getString("title");
            this.comment = json.getString("comment");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public int getId() { return id; }

    public String getPoster() { return poster; }

    public String getComment() { return comment; }


}
