package com.example.yasma.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;

import com.example.yasma.model.AlbumsResponse;

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
        return albumsResponse.getTitle();
    }
}
