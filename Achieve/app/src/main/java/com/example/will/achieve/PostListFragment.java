package com.example.will.achieve;

import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PostListFragment} factory method to
 * create an instance of this fragment.
 */
public class PostListFragment extends ListFragment {

    public static final String SECTION = "Section";

    private ListView listView;
    private ArrayList<Post> posts;
    private PostListAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View displayView = inflater.inflate(R.layout.fragment_post_list, container, false);
        listView = (ListView) displayView.findViewById(android.R.id.list);

        return displayView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        int num = getArguments().getInt(SECTION);

        posts = Global.getInstance().getPostList();
        mAdapter = new PostListAdapter(getActivity(), android.R.id.list, posts);
        listView.setAdapter(mAdapter);
    }
}