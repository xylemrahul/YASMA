package com.example.yasma.view.fragments;

import android.annotation.SuppressLint;
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
import com.example.yasma.viewmodel.PostsViewModel;

import java.util.Observable;
import java.util.Observer;


public class PostsFragment extends Fragment implements Observer {

    private PostsViewModel postsViewModel;
    private RecyclerView recyclerView;

    String TAG = PostsFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewDataBinding postDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_posts, container, false);

        return postDataBinding.getRoot();
    }

    @SuppressLint("CheckResult")
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        postsViewModel = new PostsViewModel();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.list_people);
        setupListPosts(recyclerView);
//        setupObserver(postsViewModel);
    }

    public void setupObserver(Observable observable) {
        observable.addObserver(this);
    }

    private void setupListPosts(RecyclerView listPeople) {
        PostsAdapter adapter = new PostsAdapter();
        listPeople.setAdapter(adapter);
        listPeople.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void update(Observable observable, Object arg) {

        PostsAdapter adapter = (PostsAdapter) recyclerView.getAdapter();
        PostsViewModel postsViewModel = (PostsViewModel) observable;
        adapter.setPostsResponsesList(postsViewModel.getmPostResponse());
    }
}
