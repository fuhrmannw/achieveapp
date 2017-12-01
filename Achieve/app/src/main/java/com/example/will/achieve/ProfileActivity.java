package com.example.will.achieve;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.will.achieve.AsyncTasks.CreatePostAsync;
import com.example.will.achieve.AsyncTasks.GetUsersProjects;

public class ProfileActivity extends AppCompatActivity implements PostListFragment.OnListFragmentInteractionListener {

    RecyclerView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        TextView tv = (TextView) findViewById(R.id.profileUsername);
        tv.setText(Global.getInstance().getFirstName() + " " + Global.getInstance().getLastName());
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
        Intent toPostIntent = new Intent(this, PostActivity.class);
        toPostIntent.putExtra("PostId", item.getId());
        startActivity(toPostIntent);
    }

}