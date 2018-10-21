package com.ieg.myblog;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ieg.myblog.adapters.PostImageViewAdapter;
import com.ieg.myblog.models.PostImage;

import java.util.ArrayList;
import java.util.List;

import static com.ieg.myblog.activitys.MainActivity.mdata;

public class AllPostFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private PostImageViewAdapter adapter;

    public AllPostFragment() {
    }

    public static AllPostFragment newInstance(int sectionNumber) {
        AllPostFragment fragment = new AllPostFragment();

        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.all_post_list);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new PostImageViewAdapter(getActivity(), mdata);
        recyclerView.setAdapter(adapter);

        return rootView;
    }
}