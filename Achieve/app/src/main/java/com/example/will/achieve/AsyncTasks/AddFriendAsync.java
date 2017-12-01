package com.example.will.achieve.AsyncTasks;

import android.os.AsyncTask;
import android.util.Log;

import com.example.will.achieve.FriendsListFragment;
import com.example.will.achieve.Post;
import com.example.will.achieve.PostListFragment;
import com.example.will.achieve.ServerRequest;

import org.json.JSONObject;

/**
 * Created by enclark on 11/30/17.
 */

public class AddFriendAsync extends AsyncTask<Void, Void, Void>{

    private JSONObject body;
    private FriendsListFragment friendList;
    private int userId;

    public AddFriendAsync(String friendUsername, int userId, FriendsListFragment friendList) {
        JSONObject json = new JSONObject();
        this.friendList = friendList;
        this.userId = userId;
        try {
            json.put("id1", userId);
            json.put("username", friendUsername);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.body = json;
    }

    @Override
    protected Void doInBackground(Void... params) {
        Log.i("CreatePostAsync", "Creating post");
        ServerRequest req = new ServerRequest(body, "/post/create", false);
        req.sendRequest();
        return null;
    }

    @Override
    protected void onPostExecute(Void params) {
        new GetFriendListAsync(friendList, userId).execute();
    }
}
