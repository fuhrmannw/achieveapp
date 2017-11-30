package com.example.will.achieve;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONObject;

import java.util.ArrayList;

public class Post {

    public int id;
    public String poster;
    public String post;
    public int likes;
    public int numComments;
    public ArrayList<String> comments;

    public Post(int id, String poster, String post, int likes, int comments)
    {
        this.id = id;
        this.poster = poster;
        this.post = post;
        this.likes = likes;
        this.numComments = comments;
    }

    public Post(JSONObject json){
        try {
            this.id = json.getInt("id");
            this.poster = json.getString("title");
            this.post = json.getString("content");
            this.likes = json.getInt("likes");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public String getPoster()
    {
        return poster;
    }

    public String getPost()
    {
        return post;
    }

    public int getLikes()
    {
        return likes;
    }

    public int getNumComments()
    {
        return numComments;
    }

    public JSONObject toJSONObject() {
        JSONObject json = new JSONObject();

        try {
            json.put("title", poster);
            json.put("content", post);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }
}
