package com.example.yasma.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.yasma.R;

public class FullScreenImageActivity extends AppCompatActivity {

    private static String IMAGE_EXTRA = "IMAGE_EXTRA";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        ImageView imageView = (ImageView) findViewById(R.id.image_full_screen);

        Bundle extras = getIntent().getExtras();
        if(extras.get(IMAGE_EXTRA) !=null){
            String url = extras.getString(IMAGE_EXTRA);
            Glide.with(this).load(url).into(imageView);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.setTitle("Full Screen Image");
    }

    public static Intent launchFullScreenImage(Context context, String imageUrl) {
        Intent intent = new Intent(context, FullScreenImageActivity.class);
        intent.putExtra(IMAGE_EXTRA, imageUrl);
        return intent;
    }
}
