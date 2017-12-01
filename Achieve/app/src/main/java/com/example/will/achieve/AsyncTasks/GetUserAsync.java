package com.example.will.achieve.AsyncTasks;

import android.os.AsyncTask;

import com.example.will.achieve.ServerRequest;

import org.json.JSONObject;

/**
 * Created by enclark on 11/30/17.
 */

public class GetUserAsync extends AsyncTask<Void, Void, JSONObject> {
    private int userId;
    private UserHandler handler;

    public GetUserAsync(int userId, UserHandler handler) {
        this.userId = userId;
        this.handler = handler;
    }

    @Override
    protected JSONObject doInBackground(Void... params) {
        ServerRequest req = new ServerRequest(null, "/user/" + userId, true);
        return req.sendRequest();
    }

    @Override
    protected void onPostExecute(JSONObject result) {
        handler.handleUserResult(result);
    }

    public interface UserHandler {
        void handleUserResult(JSONObject result);
    }
}
