package com.example.yasma.viewmodel;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.yasma.model.AlbumDetailsResponse;

import java.util.Observable;

public class ItemAlbumDetailsViewModel extends Observable {

    private AlbumDetailsResponse mAlbumDetailsResponse;
    private Context mContext;

    public ItemAlbumDetailsViewModel(AlbumDetailsResponse albumDetailsResponse, Context context) {
        this.mAlbumDetailsResponse = albumDetailsResponse;
        this.mContext = context;
    }

    public void setAlbumsDetailsResponse(AlbumDetailsResponse albumDetailsResponse) {
        this.mAlbumDetailsResponse = albumDetailsResponse;
    }

    public String getTitle(){
        return "Title is : " +mAlbumDetailsResponse.getTitle();
    }

    public String getPictureProfile(){
        return mAlbumDetailsResponse.getThumbnailUrl();
    }

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext()).load(imageUrl).into(view);
    }

}
