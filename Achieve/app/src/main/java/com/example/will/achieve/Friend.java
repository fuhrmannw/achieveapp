package com.example.will.achieve;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONObject;

import java.util.ArrayList;

public class Friend {

    public int id;
    public String friendName;

    public Friend(int id, String friendName)
    {
        this.id = id;
        this.friendName = friendName;
    }

    public Friend(JSONObject json){
        try {
            this.id = json.getInt("id");
            this.friendName = json.getString("friendName");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public String getFriendName() { return friendName; }

}
