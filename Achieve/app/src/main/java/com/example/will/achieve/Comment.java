package com.example.will.achieve;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONObject;

public class Comment {

    public int id;
    public String poster;
    public int authorId;
    public String comment;

    public Comment(String poster, int authorId, String comment)
    {
        this.poster = poster;
        this.authorId = authorId;
        this.comment = comment;
    }

    public Comment(JSONObject json)
    {
        try {
            this.id = json.getInt("id");
            this.poster = json.getString("authorId");//TODO
            this.comment = json.getString("content");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public int getId() { return id; }

    public String getPoster() { return poster; }

    public String getComment() { return comment; }

    public JSONObject toJSONObject() {
        JSONObject json = new JSONObject();
        try {
            json.put("authorId", authorId);
            json.put("content", comment);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }

}
