package com.example.yasma.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.view.View;

import com.example.yasma.model.AlbumsResponse;
import com.example.yasma.view.DetailsActivity;

public class AlbumItemsViewModel extends BaseObservable
{

    private AlbumsResponse albumsResponse;
    private Context mContext;

    public AlbumItemsViewModel(AlbumsResponse albumsResponse, Context context) {
        this.albumsResponse = albumsResponse;
        this.mContext = context;
    }

    public void setAlbumsResponse(AlbumsResponse albumsResponse) {
        this.albumsResponse = albumsResponse;
    }

    public String getTitle(){
        return "Title is : " +albumsResponse.getTitle();
    }

    public void onItemClick(View view) {

        mContext.startActivity( DetailsActivity.launchAlbumDetails( view.getContext(), albumsResponse));
    }
}
