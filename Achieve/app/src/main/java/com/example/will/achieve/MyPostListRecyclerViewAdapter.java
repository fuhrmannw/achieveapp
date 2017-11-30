package com.example.will.achieve;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.will.achieve.AsyncTasks.LikePostAsync;
import com.example.will.achieve.PostListFragment.OnListFragmentInteractionListener;
import com.example.will.achieve.dummy.DummyContent.DummyItem;

import java.util.List;

import static com.example.will.achieve.R.id.likes;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyPostListRecyclerViewAdapter extends RecyclerView.Adapter<MyPostListRecyclerViewAdapter.PostHolder> {

    private final List<Post> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyPostListRecyclerViewAdapter(List<Post> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public PostHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_post, parent, false);
        return new PostHolder(view);
    }

    @Override
    public void onBindViewHolder(final PostHolder holder, int position) {
        Post post = mValues.get(position);
        holder.post = post;
        holder.content.setText(post.getPost());
        holder.author.setText(post.getPoster());
        holder.likes.setText("Likes: " + post.getLikes());

        holder.likesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.post.likes += 1;
                holder.likes.setText("Likes: " + holder.post.getLikes());
                new LikePostAsync(holder.post.id).execute();
            }
        });

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.post);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class PostHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView content;
        public final TextView author;
        public final TextView likes;
        public final Button likesBtn;

        public Post post;

        public PostHolder(View view) {
            super(view);
            mView = view;
            content = (TextView) view.findViewById(R.id.post);
            author = (TextView) view.findViewById(R.id.poster);
            likes = (TextView) view.findViewById(R.id.likes);
            likesBtn = (Button) view.findViewById(R.id.likeButton);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + post.getPost() + "'";
        }
    }
}
