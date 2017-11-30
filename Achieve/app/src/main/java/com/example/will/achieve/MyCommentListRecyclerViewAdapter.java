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

public class MyCommentListRecyclerViewAdapter extends RecyclerView.Adapter<MyCommentListRecyclerViewAdapter.CommentHolder> {

    private final List<Comment> mValues;
    private final CommentListFragment.OnListFragmentInteractionListener mListener;

    public MyCommentListRecyclerViewAdapter(List<Comment> items, CommentListFragment.OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public MyCommentListRecyclerViewAdapter.CommentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_post, parent, false);
        return new MyCommentListRecyclerViewAdapter.CommentHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyCommentListRecyclerViewAdapter.CommentHolder holder, int position) {
        Comment comment = mValues.get(position);
        holder.comment = comment;

        holder.commentText.setText(comment.getComment());
        holder.commenter.setText(comment.getPoster());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.comment);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class CommentHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView commenter;
        public final TextView commentText;

        public Comment comment;

        public CommentHolder(View view) {
            super(view);
            mView = view;
            commenter = (TextView) view.findViewById(R.id.commenterName);
            commentText = (TextView) view.findViewById(R.id.commentText);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + comment.getComment() + "'";
        }
    }

}
