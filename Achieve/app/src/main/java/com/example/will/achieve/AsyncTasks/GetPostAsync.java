package com.example.will.achieve.AsyncTasks;

import android.os.AsyncTask;

import com.example.will.achieve.ServerRequest;

import org.json.JSONObject;

/**
 * Created by enclark on 11/30/17.
 */

public class GetPostAsync extends AsyncTask<Void, Void, JSONObject> {

    private int postId;
    private PostHandler handler;

    public GetPostAsync(int postId, PostHandler handler) {
        this.postId = postId;
        this.handler = handler;
    }

    @Override
    protected JSONObject doInBackground(Void... params) {
        ServerRequest req = new ServerRequest(null, "/post/" + postId, true);
        return req.sendRequest();
    }

    @Override
    protected void onPostExecute(JSONObject result) {
        handler.handlePostResult(result);
    }

    public interface PostHandler {
        void handlePostResult(JSONObject result);
    }
}
