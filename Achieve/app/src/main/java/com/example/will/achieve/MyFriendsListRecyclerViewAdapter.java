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

public class MyFriendsListRecyclerViewAdapter extends RecyclerView.Adapter<MyFriendsListRecyclerViewAdapter.FriendHolder> {

    private final List<Friend> mValues;
    private final FriendsListFragment.OnListFragmentInteractionListener mListener;

    public MyFriendsListRecyclerViewAdapter(List<Friend> items, FriendsListFragment.OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public MyFriendsListRecyclerViewAdapter.FriendHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_friend, parent, false);
        return new MyFriendsListRecyclerViewAdapter.FriendHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyFriendsListRecyclerViewAdapter.FriendHolder holder, int position) {
        Friend friend = mValues.get(position);
        holder.mFriend = friend;
        holder.friend = friend.getFriendName();

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    // TODO get this to compile  mListener.onListFragmentInteraction(holder.mFriend);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class FriendHolder extends RecyclerView.ViewHolder {
        public final View mView;
        //public final TextView friend;

        public Friend mFriend;
        public String friend;

        public FriendHolder(View view) {
            super(view);
            mView = view;
            //TODO friend = (TextView)view.findViewById(R.id.friendName);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + friend + "'";
        }
    }
}
