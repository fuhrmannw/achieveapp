package com.example.will.achieve;

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

public class HomeActivity extends AppCompatActivity implements PostListFragment.OnListFragmentInteractionListener, GetFeedAsync.ResultHandler {

    RecyclerView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    public void onListFragmentInteraction(Post item) {
        //TODO
    }

    @Override
    public void setRecyclerView(RecyclerView v){
        this.view = v;
    }

    @Override
    public void handleResult(JSONObject result) {
        Log.i("Result", result.toString());
        try {
            JSONArray arr = result.getJSONArray("posts");
            List<Post> posts = new ArrayList<>();
            for (int i = 0; i < arr.length(); i++) {
                JSONObject json = arr.getJSONObject(i);
                posts.add(new Post(json));
            }
            MyPostListRecyclerViewAdapter adapter = new MyPostListRecyclerViewAdapter(posts, this);
            view.setAdapter(adapter);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
