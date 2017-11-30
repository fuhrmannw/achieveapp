package com.example.will.achieve;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Will3 on 11/30/2017.
 */

public class MyProfileListRecyclerViewAdapter extends RecyclerView.Adapter<MyProfileListRecyclerViewAdapter.PostHolder> {

    private final List<Post> mValues;
    private final PostListFragment.OnListFragmentInteractionListener mListener;

    public MyProfileListRecyclerViewAdapter(List<Post> items, PostListFragment.OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public MyProfileListRecyclerViewAdapter.PostHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_post, parent, false);
        return new MyProfileListRecyclerViewAdapter.PostHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyProfileListRecyclerViewAdapter.PostHolder holder, int position) {
        Post post = mValues.get(position);
        holder.post = post;
        holder.content.setText(post.getPost());
        holder.author.setText(post.getPoster());
        holder.likes.setText("Likes: " + post.getLikes());

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

        public Post post;

        public PostHolder(View view) {
            super(view);
            mView = view;
            content = (TextView) view.findViewById(R.id.post);
            author = (TextView) view.findViewById(R.id.poster);
            likes = (TextView) view.findViewById(R.id.likes);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + post.getPost() + "'";
        }
    }

}
