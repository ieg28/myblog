package com.ieg.myblog.activitys;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.ieg.myblog.R;
import com.ieg.myblog.models.PostImage;

import java.io.FileNotFoundException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewPostImageActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.anpi_ed_title)
    EditText title;

    @BindView(R.id.anpi_ed_body)
    EditText body;

    @BindView(R.id.anpi_img_image)
    ImageView image;

    @BindView(R.id.anpi_btn_push)
    FloatingActionButton push;

    private int SELECT_IMAGE = 123;

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
        image.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.anpi_btn_push: {
                PostImage postImage = new PostImage();
                postImage.setTitle(title.getText().toString());
                postImage.setBody(body.getText().toString());
                postImage.setUser(userName);

                if (MainActivity.mdata != null) {
                    MainActivity.mdata.add(postImage);
                }

                finish();
                break;
            }
            case R.id.anpi_img_image: {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_IMAGE);

                break;
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_IMAGE) {
                // currImageURI is the global variable I'm using to hold the content:// URI of the image
                if (data != null) {
                    Toast.makeText(NewPostImageActivity.this, "url:" + data.getData(), Toast.LENGTH_SHORT).show();
                    try {
                        final Uri imageUri = data.getData();
                        final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                        final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                        image.setImageBitmap(selectedImage);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                } else
                    Toast.makeText(NewPostImageActivity.this, "url null", Toast.LENGTH_SHORT).show();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
