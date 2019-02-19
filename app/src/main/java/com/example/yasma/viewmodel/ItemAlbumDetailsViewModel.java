package com.example.yasma.viewmodel;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.yasma.model.AlbumDetailsResponse;
import com.example.yasma.view.DetailsActivity;
import com.example.yasma.view.FullScreenImageActivity;

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

    public void onItemClick(View view) {

        mContext.startActivity( FullScreenImageActivity.launchFullScreenImage( view.getContext(), mAlbumDetailsResponse.getUrl()));
    }

}
