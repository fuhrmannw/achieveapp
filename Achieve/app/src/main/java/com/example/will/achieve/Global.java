package com.example.will.achieve;

import java.util.ArrayList;

/**
 * Created by Will3 on 11/29/2017.
 */

public class Global {

    public String username;

    private static Global instance = null;

    public ArrayList<Post> mPostArrayList = new ArrayList<Post>();

    public ArrayList<Post> mProfileArrayList = new ArrayList<Post>();

    public ArrayList<String> mFriendsList = new ArrayList<String>();

    public ArrayList<Comment> mCommentArrayList = new ArrayList<Comment>();

    private Global() {

    }

    public static Global getInstance() {
        if( instance == null ) {
            instance = new Global();
        }
        return instance;
    }



    public void addToPostList(Post post_)
    {
        mPostArrayList.add(post_);
    }


    public ArrayList<Post> getPostList()
    {
        return mPostArrayList;
    }

    public ArrayList<Post> getProfileList() { return mProfileArrayList; }

    public ArrayList<String> getFriendsList() { return mFriendsList; }

    public ArrayList<Comment> getCommentArrayList() { return mCommentArrayList; }

}
