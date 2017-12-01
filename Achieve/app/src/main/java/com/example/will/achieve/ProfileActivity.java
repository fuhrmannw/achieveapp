package com.example.will.achieve;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class ProfileActivity extends AppCompatActivity implements PostListFragment.OnListFragmentInteractionListener {

    RecyclerView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    public void toFriendsActivity(View v)
    {
        Intent toFriendsIntent = new Intent(this, FriendsListActivity.class);
        startActivity(toFriendsIntent);
    }

    public void toHomeActivity(View v)
    {
        Intent toHomeIntent = new Intent(this, HomeActivity.class);
        startActivity(toHomeIntent);
    }

    @Override
    public void onListFragmentInteraction(Post item) {
        Intent toHomeIntent = new Intent(this, HomeActivity.class);
        toHomeIntent.putExtra("PostId", item.getId());
        startActivity(toHomeIntent);
    }







}