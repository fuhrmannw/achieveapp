package com.example.will.achieve.AsyncTasks;

import android.os.AsyncTask;
import android.util.Log;

import com.example.will.achieve.ServerRequest;

import org.json.JSONObject;

/**
 * Created by enclark on 11/30/17.
 */

public class GetFriendListAsync extends AsyncTask<Void, Void, JSONObject> {

    private int userId;

    private FriendResultHandler handler;

    public GetFriendListAsync(FriendResultHandler handler, int userId) {
        this.userId = userId;
        this.handler = handler;
    }

    @Override
    protected JSONObject doInBackground(Void... params) {
        Log.i("GetFriendListAsync", "Getting Friends List for user " + userId);
        ServerRequest req = new ServerRequest(null, "/user/friends/" + userId, true);
        return req.sendRequest();
    }

    public interface FriendResultHandler {
        void handleFriendListResult();
    }

}
