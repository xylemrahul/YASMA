package com.example.yasma.view.fragments;

import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModelProvider;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yasma.R;
import com.example.yasma.databinding.FragmentPostsBinding;
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
        postDataBinding.listPeople.setLayoutManager(new LinearLayoutManager(getContext()));
        postDataBinding.listPeople.setAdapter(new PostsAdapter());
        return postDataBinding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        postsViewModel = new PostsViewModel();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupObserver(postsViewModel);
    }

    public void setupObserver(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object arg) {

        PostsAdapter adapter = (PostsAdapter) postDataBinding.listPeople.getAdapter();
        PostsViewModel postsViewModel = (PostsViewModel) observable;
        adapter.setPostsResponsesList(postsViewModel.getmPostResponse());
    }
}
