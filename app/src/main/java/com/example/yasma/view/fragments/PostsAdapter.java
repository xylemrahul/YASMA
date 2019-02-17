package com.example.yasma.view.fragments;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.yasma.R;
import com.example.yasma.databinding.ItemPostBinding;
import com.example.yasma.model.PostsResponse;
import com.example.yasma.viewmodel.PostItemsViewModel;

import java.util.Collections;
import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostsAdapterViewHolder> {

    private List<PostsResponse> postsResponses = Collections.emptyList();
    @NonNull
    @Override
    public PostsAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPostBinding itemPostBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_post,
                        parent, false);
        return new PostsAdapterViewHolder(itemPostBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PostsAdapterViewHolder postsAdapterViewHolder, int i) {
        postsAdapterViewHolder.bindPeople(postsResponses.get(i));
    }

    @Override
    public int getItemCount() {
        return postsResponses.size();
    }

    void setPostsResponsesList(List<PostsResponse> postsResponseList) {
        this.postsResponses = postsResponseList;
        notifyDataSetChanged();
    }

    static class PostsAdapterViewHolder extends RecyclerView.ViewHolder{

        ItemPostBinding itemPostBinding;
        public PostsAdapterViewHolder( ItemPostBinding itemPostBinding ) {
            super(itemPostBinding.itemPeople);
            this.itemPostBinding = itemPostBinding;
        }

        void bindPeople(PostsResponse postsResponse) {
            if (itemPostBinding.getPostitemsviewmodel() == null) {
                itemPostBinding.setPostitemsviewmodel(
                        new PostItemsViewModel(postsResponse, itemView.getContext()));
            } else {
                itemPostBinding.getPostitemsviewmodel().setPostsResponse(postsResponse);
            }
        }
    }
}
