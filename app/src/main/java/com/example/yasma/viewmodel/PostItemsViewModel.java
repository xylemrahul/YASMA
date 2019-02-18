package com.example.yasma.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.view.View;

import com.example.yasma.model.PostsResponse;
import com.example.yasma.view.DetailsActivity;

import java.util.Observable;

public class PostItemsViewModel extends Observable {

    private PostsResponse postsResponse;
    private Context mContext;

    public PostItemsViewModel(PostsResponse postsResponse, Context context) {
        this.postsResponse = postsResponse;
        this.mContext = context;
    }

    public void setPostsResponse(PostsResponse postsResponse) {
        this.postsResponse = postsResponse;
    }

    public String getTitle(){
        return "Title is : " +postsResponse.getTitle();
    }

    public void onItemClick(View view) {

        mContext.startActivity( DetailsActivity.launchPostDetails( view.getContext(), postsResponse));
    }
}
