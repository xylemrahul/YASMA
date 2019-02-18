package com.example.yasma.viewmodel;

import android.content.Context;

import com.example.yasma.model.PostDetailsResponse;

import java.util.Observable;

public class ItemPostDetailsViewModel extends Observable {

    private PostDetailsResponse postDetailsResponse;
    private Context mContext;

    public ItemPostDetailsViewModel(PostDetailsResponse postDetailsResponse, Context context) {
        this.postDetailsResponse = postDetailsResponse;
        this.mContext = context;
    }

    public void setPostsCommentsResponse(PostDetailsResponse postDetailsResponse) {
        this.postDetailsResponse = postDetailsResponse;
    }

    public String getName(){
        return "Title is : " + postDetailsResponse.getName();
    }

    public String getBody(){
        return "Body is : " + postDetailsResponse.getBody();
    }

    public String getEmail(){
        return "Email is : " + postDetailsResponse.getEmail();
    }
}
