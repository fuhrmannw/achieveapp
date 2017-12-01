package com.example.will.achieve.AsyncTasks;

import android.os.AsyncTask;
import android.util.Log;

import com.example.will.achieve.Post;
import com.example.will.achieve.PostListFragment;
import com.example.will.achieve.ServerRequest;

import org.json.JSONObject;

/**
 * Created by enclark on 11/30/17.
 */

public class CreatePostAsync extends AsyncTask<Void, Void, JSONObject> {

    private JSONObject body;
    private PostListFragment postList;
    private int userId;

    public CreatePostAsync(Post post, int userId, PostListFragment postList) {
        JSONObject json = new JSONObject();
        this.postList = postList;
        this.userId = userId;
        try {
            json.put("post", post.toJSONObject());
            json.put("author", userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.body = json;
    }

    @Override
    protected JSONObject doInBackground(Void... params) {
        Log.i("CreatePostAsync", "Creating post");
        ServerRequest req = new ServerRequest(body, "/post/create", false);
        return req.sendRequest();
    }

    @Override
    protected void onPostExecute(JSONObject jsonObject) {
        new GetFeedAsync(userId, postList).execute();
    }
}
