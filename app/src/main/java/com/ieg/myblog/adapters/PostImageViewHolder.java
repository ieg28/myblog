package com.ieg.myblog.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.ieg.myblog.R;

public class PostImageViewHolder extends RecyclerView.ViewHolder {

    public ImageButton profile;
    public ImageButton fav;

    public TextView title;
    public TextView body;

    public ImageView image;

    public PostImageViewHolder(View itemView) {
        super(itemView);
        profile = itemView.findViewById(R.id.vpi_img_profile);
        fav = itemView.findViewById(R.id.vpi_img_fav);
        title = itemView.findViewById(R.id.vpi_txt_title);
        body = itemView.findViewById(R.id.vpi_txt_body);
        image = itemView.findViewById(R.id.vpi_img_image);
    }
}
