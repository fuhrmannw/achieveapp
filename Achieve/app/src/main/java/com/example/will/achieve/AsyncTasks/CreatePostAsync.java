package com.example.will.achieve.AsyncTasks;

import android.os.AsyncTask;
import android.util.Log;

import com.example.will.achieve.Post;
import com.example.will.achieve.ServerRequest;

import org.json.JSONObject;

/**
 * Created by enclark on 11/30/17.
 */

public class CreatePostAsync extends AsyncTask<Void, Void, JSONObject> {

    private JSONObject body;

    public CreatePostAsync(Post post, int userId) {
        JSONObject json = new JSONObject();
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


}
