package com.example.will.achieve;

import android.app.Fragment;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.will.achieve.AsyncTasks.CreatePostAsync;
import com.example.will.achieve.AsyncTasks.GetFeedAsync;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements PostListFragment.OnListFragmentInteractionListener {

    RecyclerView view;

    PostListFragment postListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        postListFragment = (PostListFragment) getSupportFragmentManager().findFragmentById(R.id.post_list_fragment);
    }

    public void createPost(View v)
    {
        Log.i("CreatePost", "Creating post");
        EditText et = (EditText) findViewById(R.id.inputGoalText);
        Post post = new Post(Global.getInstance().getFirstName(), Global.getInstance().getLastName(), et.getText().toString());
        //TODO ERICA NEEDS THIS FOR SOMETHING
        new CreatePostAsync(post, Global.getInstance().userId, postListFragment).execute(); //TODO Refresh the page - add postlist as a handler
    }

    public void toFriendsActivity(View v)
    {
        Intent toFriendsIntent = new Intent(this, FriendsListActivity.class);
        startActivity(toFriendsIntent);
    }

    public void toProfileActivity(View v)
    {
        Intent toProfileIntent = new Intent(this, ProfileActivity.class);
        startActivity(toProfileIntent);
    }

    @Override
    public void onListFragmentInteraction(Post item) {
        Intent toPostIntent = new Intent(this, PostActivity.class);
        toPostIntent.putExtra("PostId", item.getId());
        startActivity(toPostIntent);
    }
}
