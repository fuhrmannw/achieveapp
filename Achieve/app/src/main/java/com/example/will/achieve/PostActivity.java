package com.example.will.achieve;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.will.achieve.AsyncTasks.CreateCommentAsync;
import com.example.will.achieve.AsyncTasks.GetPostAsync;
import com.example.will.achieve.AsyncTasks.LikePostAsync;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class PostActivity extends AppCompatActivity implements CommentListFragment.OnListFragmentInteractionListener, GetPostAsync.PostHandler {

    private Post post;
    private TextView postContent;
    private TextView poster;
    private Button newCommentBtn;
    private TextView newCommentContent;
    private int postId;
    private Button likeBtn;
    private TextView likes;

    private CommentListFragment commentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post2);

        postContent = (TextView) findViewById(R.id.post);
        poster = (TextView) findViewById(R.id.poster);
        newCommentBtn = (Button) findViewById(R.id.submit);
        newCommentContent = (EditText) findViewById(R.id.newComment);
        likeBtn = (Button) findViewById(R.id.likeButton);
        likes = (TextView) findViewById(R.id.likes);

        final GetPostAsync.PostHandler self = this;

        commentList = (CommentListFragment) getSupportFragmentManager().findFragmentById(R.id.comment_list_fragment);

        postId = getIntent().getExtras().getInt("PostId");

        new GetPostAsync(postId, this).execute();

        newCommentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = Global.getInstance().firstName + " " + Global.getInstance().getLastName();
                int authorId = Global.getInstance().userId;
                Comment comment = new Comment(name, authorId, newCommentContent.getText().toString());
                newCommentContent.setText("");
                new CreateCommentAsync(comment, postId, self).execute();
            }
        });

        likeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                post.likes += 1;
                likes.setText("Likes: " + post.getLikes());
                new LikePostAsync(post.id).execute();
            }
        });
    }


    @Override
    public void onListFragmentInteraction(Comment item) {
        // Nothing
    }

    @Override
    public void handlePostResult(JSONObject result) {
        if(result != null) {
            Log.i("Result", result.toString());
            try {
                JSONObject postJson = result.getJSONObject("post");
                postContent.setText(postJson.getString("content"));
                poster.setText(postJson.getString("title"));
                post = new Post(postJson);

                likes.setText("Likes: " + post.getLikes());

                JSONArray arr = result.getJSONArray("comments");
                List<Comment> comments = new ArrayList<>();
                for (int i = 0; i < arr.length(); i++) {
                    JSONObject json = arr.getJSONObject(i);
                    comments.add(new Comment(json));
                }
                commentList.setData(comments);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
