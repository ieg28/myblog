package com.ieg.myblog.activitys;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.ieg.myblog.R;
import com.ieg.myblog.models.PostImage;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewPostImageActivity extends AppCompatActivity implements FloatingActionButton.OnClickListener {

    @BindView(R.id.anpi_ed_title)
    EditText title;

    @BindView(R.id.anpi_ed_body)
    EditText body;

    @BindView(R.id.anpi_img_image)
    ImageView image;

    @BindView(R.id.anpi_btn_push)
    FloatingActionButton push;

    //TODO: fix me
    String userName = "john";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post_image);

        ButterKnife.bind(this);
        init();
    }

    private void init() {
        push.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        PostImage postImage = new PostImage();
        postImage.setTitle(title.getText().toString());
        postImage.setBody(body.getText().toString());
        postImage.setUser(userName);

        if (MainActivity.mdata != null) {
            MainActivity.mdata.add(postImage);
        }

        finish();
    }
}
