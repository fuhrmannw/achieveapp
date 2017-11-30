package com.example.will.achieve.AsyncTasks;

import android.os.AsyncTask;

import com.example.will.achieve.ServerRequest;

import org.json.JSONObject;

/**
 * Created by enclark on 11/29/17.
 */

public class GetFeedAsync extends AsyncTask<Void, Void, JSONObject> {

    private String userId;

    private ResultHandler handler;

    public GetFeedAsync(String userId, ResultHandler resultHandler) {
        this.userId = userId;
        this.handler = resultHandler;
    }

    @Override
    protected JSONObject doInBackground(Void... params) {
        ServerRequest connection = new ServerRequest(null, "/post/feed/" + userId, true);
        return connection.sendRequest();
    }

    @Override
    protected void onPostExecute(JSONObject result){
        handler.handleResult(result);
    }

    public interface ResultHandler{
        public void handleResult(JSONObject result);
    }
}

