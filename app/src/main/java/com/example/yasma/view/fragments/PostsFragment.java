package com.example.yasma.view.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yasma.R;
import com.example.yasma.databinding.FragmentPostsBinding;
import com.example.yasma.view.adapters.PostsAdapter;
import com.example.yasma.viewmodel.PostsViewModel;

import java.util.Observable;
import java.util.Observer;

public class PostsFragment extends Fragment implements Observer {

    private PostsViewModel postsViewModel;
    FragmentPostsBinding postDataBinding;

    String TAG = PostsFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        postDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_posts, container, false);
        postDataBinding.listPosts.setLayoutManager(new LinearLayoutManager(getContext()));
        postDataBinding.listPosts.setAdapter(new PostsAdapter());
        return postDataBinding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        postsViewModel = new PostsViewModel();
        setupObserver(postsViewModel);
    }

    public void setupObserver(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object arg) {

        PostsAdapter adapter = (PostsAdapter) postDataBinding.listPosts.getAdapter();
        PostsViewModel postsViewModel = (PostsViewModel) observable;
        if (adapter != null) {
            adapter.setPostsResponsesList(postsViewModel.getmPostResponse());
        }
    }
}
