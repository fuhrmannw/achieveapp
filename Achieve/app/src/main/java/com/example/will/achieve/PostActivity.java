package com.example.will.achieve;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PostActivity extends AppCompatActivity implements CommentListFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post2);
    }


    @Override
    public void onListFragmentInteraction(Comment item) {
        // Nothing
    }
}
