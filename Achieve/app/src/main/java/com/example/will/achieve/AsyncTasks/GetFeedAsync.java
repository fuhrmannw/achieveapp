package com.example.will.achieve.AsyncTasks;

import android.os.AsyncTask;
import android.util.Log;

import com.example.will.achieve.ServerRequest;

import org.json.JSONObject;

/**
 * Created by enclark on 11/29/17.
 */

public class GetFeedAsync extends AsyncTask<Void, Void, JSONObject> {

    private int userId;

    private FeedHandler handler;

    public GetFeedAsync(int userId, FeedHandler resultHandler) {
        this.userId = userId;
        this.handler = resultHandler;
    }

    @Override
    protected JSONObject doInBackground(Void... params) {
        Log.i("GetFeedAsync", "Getting Feed for user " + userId);
        ServerRequest connection = new ServerRequest(null, "/post/feed/" + userId, true);
        return connection.sendRequest();
    }

    @Override
    protected void onPostExecute(JSONObject result) {
        handler.handleFeedResult(result);
    }

    public interface FeedHandler {
        void handleFeedResult(JSONObject result);
    }
}

