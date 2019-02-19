package com.example.yasma.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.yasma.R;
import com.example.yasma.model.AlbumsResponse;
import com.example.yasma.model.PostsResponse;
import com.example.yasma.view.fragments.AlbumDetailsFragment;
import com.example.yasma.view.fragments.PostDetailsFragment;

import static com.example.yasma.Utils.ALBUMS_EXTRA;
import static com.example.yasma.Utils.POSTS_EXTRA;

public class DetailsActivity extends AppCompatActivity
{

    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView(R.layout.activity_details);

        Bundle extras = getIntent().getExtras();
        if( extras.get(POSTS_EXTRA) != null)
        {
            getSupportFragmentManager().beginTransaction().add(R.id.frame_container,
                    PostDetailsFragment.newInstance(getIntent().getExtras())).commit();
        }else {
            getSupportFragmentManager().beginTransaction().add(R.id.frame_container,
                    AlbumDetailsFragment.newInstance(getIntent().getExtras())).commit();
        }

        displayHomeAsUpEnabled();

    }

    private void displayHomeAsUpEnabled() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static Intent launchPostDetails(Context context, PostsResponse postsResponse) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(POSTS_EXTRA, postsResponse);
        return intent;
    }

    public static Intent launchAlbumDetails(Context context, AlbumsResponse albumsResponse){

        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(ALBUMS_EXTRA, albumsResponse);
        return intent;
    }
}
