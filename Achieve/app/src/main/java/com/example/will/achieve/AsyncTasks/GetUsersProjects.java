package com.example.will.achieve.AsyncTasks;

import android.os.AsyncTask;
import android.util.Log;

import com.example.will.achieve.ServerRequest;

import org.json.JSONObject;

/**
 * Created by enclark on 11/30/17.
 */

public class GetUsersProjects extends AsyncTask<Void, Void, JSONObject> {

    private int userId;

    private PostHandler handler;

    public GetUsersProjects(int userId, PostHandler handler) {
        this.userId = userId;
        this.handler = handler;
    }
    @Override
    protected JSONObject doInBackground(Void... params) {
        Log.i("GetUsersProjects", "Finding projects for " + userId);
        ServerRequest req = new ServerRequest(null, "/post/user/" + userId, true);
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
