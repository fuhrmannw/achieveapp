package com.example.will.achieve;

import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.will.achieve.AsyncTasks.GetFeedAsync;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements PostListFragment.OnListFragmentInteractionListener {

    RecyclerView view;

    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //fragment = new PostListFragment();
    }

    public void toHomeFragment()
    {
        //fragment = new PostListFragment();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        //transaction.replace(R.id.post_list_fragment, fragment);
        transaction.commit();
    }

    public void toFriendsFragment()
    {
        //fragment = new FriendsListFragment();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        //transaction.replace(R.id.friends_list_fragment, fragment);
        transaction.commit();
    }

    public void toProfileFragment()
    {
        //fragment = new ProfileListFragment();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        //transaction.replace(R.id.profile_list_fragment, fragment);
        transaction.commit();
    }

    @Override
    public void onListFragmentInteraction(Post item) {
        //TODO
    }
}
