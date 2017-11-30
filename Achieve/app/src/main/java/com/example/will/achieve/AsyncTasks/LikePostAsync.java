package com.example.will.achieve.AsyncTasks;

import android.os.AsyncTask;
import android.util.Log;

import com.example.will.achieve.ServerRequest;

import org.json.JSONObject;

/**
 * Created by enclark on 11/30/17.
 */

public class LikePostAsync extends AsyncTask<Void, Void, Void> {

    private int postId;

    public LikePostAsync(int postId) {
        this.postId = postId;
    }


    @Override
    protected Void doInBackground(Void... params) {
        Log.i("LikePostAsync", "Liking Post " + postId);
        ServerRequest req = new ServerRequest(null, "/post/like/" + postId, false);
        JSONObject json = req.sendRequest();
        try {
            if (json.getString("success").equals("true")) {
                Log.i("LikePostAsync", "Post successfully liked");
            } else {

                Log.i("LikePostAsync", "Post failed to like");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
