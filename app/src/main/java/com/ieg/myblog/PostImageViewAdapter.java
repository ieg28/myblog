package com.ieg.myblog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ieg.myblog.models.PostImage;

import java.util.List;

public class PostImageViewAdapter extends RecyclerView.Adapter<PostImageViewHolder> {

    private List<PostImage> mData;
    private LayoutInflater inflater;

    public PostImageViewAdapter(Context context, List<PostImage> mData) {
        this.inflater = LayoutInflater.from(context);
        this.mData = mData;
    }

    @NonNull
    @Override
    public PostImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.view_post_image, parent, false);
        return new PostImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostImageViewHolder holder, int position) {
        holder.title.setText(mData.get(position).getTitle());
        holder.body.setText(mData.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
