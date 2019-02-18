package com.example.yasma.view.adapters;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.yasma.R;
import com.example.yasma.databinding.ItemPostDetailsBinding;
import com.example.yasma.model.AlbumDetailsResponse;
import com.example.yasma.model.PostDetailsResponse;
import com.example.yasma.viewmodel.ItemPostDetailsViewModel;

import java.util.Collections;
import java.util.List;

public class PostDetailsAdapter extends RecyclerView.Adapter<PostDetailsAdapter.PostDetailsAdapterViewHolder> {


    private List<PostDetailsResponse> postDetailsResponseList = Collections.emptyList();


    @Override
    public void onBindViewHolder(@NonNull PostDetailsAdapterViewHolder postDetailsAdapterViewHolder, int i) {

        postDetailsAdapterViewHolder.bindAlbums( postDetailsResponseList.get( i ) );
    }

    @NonNull
    @Override
    public PostDetailsAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        ItemPostDetailsBinding postDetailsBinding = DataBindingUtil.inflate( LayoutInflater.from( parent.getContext() ),
                R.layout.item_post_details,
                parent, false );
        return new PostDetailsAdapter.PostDetailsAdapterViewHolder( postDetailsBinding );
    }

    @Override
    public int getItemCount()
    {
        return postDetailsResponseList.size();
    }

    public void setPostDetailsResponseList(List<PostDetailsResponse> postDetailsResponseList) {
        this.postDetailsResponseList = postDetailsResponseList;
        notifyDataSetChanged();
    }

    static class PostDetailsAdapterViewHolder extends RecyclerView.ViewHolder{

        ItemPostDetailsBinding itemPostDetailsBinding;
        public PostDetailsAdapterViewHolder( ItemPostDetailsBinding itemPostDetailsBinding ) {
            super(itemPostDetailsBinding.rvRecycler);
            this.itemPostDetailsBinding = itemPostDetailsBinding;
        }

        void bindAlbums(PostDetailsResponse postDetailsResponse) {
            if (itemPostDetailsBinding.getItempostdetailsviewmodel() == null) {
                itemPostDetailsBinding.setItempostdetailsviewmodel(
                        new ItemPostDetailsViewModel( postDetailsResponse, itemView.getContext()));
            } else {
                itemPostDetailsBinding.getItempostdetailsviewmodel().setPostsCommentsResponse(postDetailsResponse);
            }
        }
    }
}
