package com.ieg.myblog;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ieg.myblog.models.PostText;
import com.ieg.myblog.models.PostTextAdapter;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class PostAllFragment extends Fragment implements PostTextAdapter.ItemClickListener {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */

    private Context context;

    private ArrayList<PostText> posts = null;
    private PostTextAdapter adapter;

    public PostAllFragment() {
        // data to populate the RecyclerView with
        posts = new ArrayList<>();
        posts.add(new PostText("ieg", "test title", "test body", System.currentTimeMillis()));
        posts.add(new PostText("ieg", "test title", "test body", System.currentTimeMillis()));
        posts.add(new PostText("ieg", "test title", "test body", System.currentTimeMillis()));
        posts.add(new PostText("ieg", "test title", "test body", System.currentTimeMillis()));
        posts.add(new PostText("ieg", "test title", "test body", System.currentTimeMillis()));
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PostAllFragment newInstance() {
        PostAllFragment fragment = new PostAllFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        // set up the RecyclerView
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.post_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new PostTextAdapter(getActivity(), posts);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(getActivity(),
                "You clicked " + adapter.getItem(position).getBody() +
                        " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}

