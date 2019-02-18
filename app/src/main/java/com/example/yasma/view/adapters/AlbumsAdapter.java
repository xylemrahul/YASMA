package com.example.yasma.view.adapters;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.yasma.R;
import com.example.yasma.databinding.ItemAlbumBinding;
import com.example.yasma.model.AlbumsResponse;
import com.example.yasma.viewmodel.AlbumItemsViewModel;

import java.util.Collections;
import java.util.List;

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.AlbumsAdapterViewHolder>
{
    private List<AlbumsResponse> albumsResponseList = Collections.emptyList();

    @NonNull
    @Override
    public AlbumsAdapterViewHolder onCreateViewHolder( @NonNull ViewGroup parent, int viewType )
    {
        ItemAlbumBinding albumBinding = DataBindingUtil.inflate( LayoutInflater.from( parent.getContext() ),
                                                                     R.layout.item_album,
                                                                parent, false );
        return new AlbumsAdapterViewHolder( albumBinding );
    }

    @Override
    public void onBindViewHolder( @NonNull AlbumsAdapterViewHolder albumsAdapterViewHolder, int i )
    {
        albumsAdapterViewHolder.bindAlbums( albumsResponseList.get( i ) );
    }

    @Override
    public int getItemCount()
    {
        return albumsResponseList.size();
    }

    public void setAlbumsResponseList(List<AlbumsResponse> albumsResponseList) {
        this.albumsResponseList = albumsResponseList;
        notifyDataSetChanged();
    }

    static class AlbumsAdapterViewHolder extends RecyclerView.ViewHolder{

        ItemAlbumBinding itemAlbumBinding;
        public AlbumsAdapterViewHolder( ItemAlbumBinding itemAlbumBinding ) {
            super(itemAlbumBinding.rvAlbum);
            this.itemAlbumBinding = itemAlbumBinding;
        }

        void bindAlbums(AlbumsResponse albumsResponse) {
            if (itemAlbumBinding.getAlbumitemsviewmodel() == null) {
                itemAlbumBinding.setAlbumitemsviewmodel(
                        new AlbumItemsViewModel( albumsResponse, itemView.getContext()));
            } else {
                itemAlbumBinding.getAlbumitemsviewmodel().setAlbumsResponse(albumsResponse);
            }
        }
    }
}
