package com.example.will.achieve;

import android.app.Fragment;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.example.will.achieve.AsyncTasks.AddFriendAsync;

public class FriendsListActivity extends AppCompatActivity implements FriendsListFragment.OnListFragmentInteractionListener {

    RecyclerView view;

    private FriendsListFragment friendList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_list);

        friendList = (FriendsListFragment) getSupportFragmentManager().findFragmentById(R.id.friends_list_fragment);
    }

    public void addFriend(View v)
    {
        EditText et = (EditText) findViewById(R.id.addFriend);
        String friendToAdd = et.getText().toString();

        new AddFriendAsync(friendToAdd, Global.getInstance().userId, friendList).execute();
        et.setText("");

    }

    public void toHomeActivity(View v)
    {
        Intent toHomeIntent = new Intent(this, HomeActivity.class);
        startActivity(toHomeIntent);
    }

    public void toProfileActivity(View v)
    {
        Intent toProfileIntent = new Intent(this, ProfileActivity.class);
        startActivity(toProfileIntent);
    }

    @Override
    public void onListFragmentInteraction(Friend item) {
        // Do nothing
    }
}
