package com.example.will.achieve;

import android.app.Fragment;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

public class FriendsListActivity extends AppCompatActivity {

    RecyclerView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_list);
    }

    public void addFriend()
    {
        EditText et = (EditText) findViewById(R.id.addFriend);
        String friendToAdd = et.getText().toString();

        //TODO ERICA NEEDS THIS
    }

    public void toHomeActivity()
    {
        Intent toHomeIntent = new Intent(this, HomeActivity.class);
        startActivity(toHomeIntent);
    }

    public void toProfileFragment()
    {
        Intent toProfileIntent = new Intent(this, ProfileActivity.class);
        startActivity(toProfileIntent);
    }
}
