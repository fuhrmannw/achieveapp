package com.example.will.achieve.AsyncTasks;

import android.os.AsyncTask;
import android.util.Log;

import com.example.will.achieve.AsyncTasks.GetPostAsync.PostHandler;
import com.example.will.achieve.Comment;
import com.example.will.achieve.CommentListFragment;
import com.example.will.achieve.ServerRequest;

import org.json.JSONObject;

/**
 * Created by enclark on 11/30/17.
 */

public class CreateCommentAsync extends AsyncTask<Void, Void, Void> {

    private JSONObject body;

    private int postId;

    private PostHandler postHandler;

    public CreateCommentAsync(Comment comment, int postId, PostHandler handler) {
        body = new JSONObject();
        try {
            body.put("comment", comment.toJSONObject());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.postId = postId;
        this.postHandler = handler;
    }

    @Override
    protected Void doInBackground(Void... params) {
        Log.i("CreateCommentAsync", "Creating Comment");
        ServerRequest req = new ServerRequest(body, "/post/comment/" + postId, false);
        req.sendRequest();
        return null;
    }

    @Override
    protected void onPostExecute(Void params) {
        new GetPostAsync(postId, postHandler).execute();
    }
}
