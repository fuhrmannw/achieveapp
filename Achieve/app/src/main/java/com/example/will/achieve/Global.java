package com.example.will.achieve;

import java.util.ArrayList;

/**
 * Created by Will3 on 11/29/2017.
 */

public class Global {

    public String username;

    private static Global instance = null;

    public ArrayList<Post> mPostArrayList = new ArrayList<Post>();

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

}
