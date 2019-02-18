package com.example.yasma.view.adapters;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.yasma.R;
import com.example.yasma.databinding.ItemAlbumDetailsBinding;
import com.example.yasma.model.AlbumDetailsResponse;
import com.example.yasma.viewmodel.ItemAlbumDetailsViewModel;

import java.util.Collections;
import java.util.List;

public class AlbumDetailsAdapter extends RecyclerView.Adapter<AlbumDetailsAdapter.AlbumsDetailsAdapterViewHolder>{

    private List<AlbumDetailsResponse> albumDetailsResponseList = Collections.emptyList();

    @NonNull
    @Override
    public AlbumDetailsAdapter.AlbumsDetailsAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType )
    {
        ItemAlbumDetailsBinding albumDetailsBinding = DataBindingUtil.inflate( LayoutInflater.from( parent.getContext() ),
                R.layout.item_album_details,
                parent, false );
        return new AlbumDetailsAdapter.AlbumsDetailsAdapterViewHolder( albumDetailsBinding );
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumsDetailsAdapterViewHolder albumsDetailsAdapterViewHolder, int i) {

        albumsDetailsAdapterViewHolder.bindAlbums( albumDetailsResponseList.get( i ) );
    }

    @Override
    public int getItemCount()
    {
        return albumDetailsResponseList.size();
    }

    public void setAlbumsResponseList(List<AlbumDetailsResponse> albumDetailsResponseList) {
        this.albumDetailsResponseList = albumDetailsResponseList;
        notifyDataSetChanged();
    }

    static class AlbumsDetailsAdapterViewHolder extends RecyclerView.ViewHolder{

        ItemAlbumDetailsBinding itemAlbumDetailsBinding;
        public AlbumsDetailsAdapterViewHolder( ItemAlbumDetailsBinding itemAlbumDetailsBinding ) {
            super(itemAlbumDetailsBinding.rvRecycler);
            this.itemAlbumDetailsBinding = itemAlbumDetailsBinding;
        }

        void bindAlbums(AlbumDetailsResponse albumDetailsResponse) {
            if (itemAlbumDetailsBinding.getItemalbumdetailsviewmodel() == null) {
                itemAlbumDetailsBinding.setItemalbumdetailsviewmodel(
                        new ItemAlbumDetailsViewModel( albumDetailsResponse, itemView.getContext()));
            } else {
                itemAlbumDetailsBinding.getItemalbumdetailsviewmodel().setAlbumsDetailsResponse(albumDetailsResponse);
            }
        }
    }
}
