package com.example.yasma.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;

import com.example.yasma.model.PostsResponse;

public class PostItemsViewModel extends BaseObservable {

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
        return postsResponse.getTitle();
    }
}
