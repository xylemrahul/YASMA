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

import com.example.yasma.databinding.FragmentAlbumsBinding;
import com.example.yasma.viewmodel.AlbumsViewModel;

import java.util.Observable;
import java.util.Observer;

public class AlbumsFragment extends Fragment implements Observer
{

    private AlbumsViewModel albumsViewModel;
    FragmentAlbumsBinding mAlbumsBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mAlbumsBinding = DataBindingUtil.inflate( inflater, R.layout.fragment_albums, container, false );
        mAlbumsBinding.listA.setLayoutManager(new LinearLayoutManager( getContext()));
        mAlbumsBinding.listA.setAdapter(new PostsAdapter());

        return mAlbumsBinding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        albumsViewModel = new AlbumsViewModel();
        setupObserver(albumsViewModel);
    }

    public void setupObserver(Observable observable) {
        observable.addObserver(this);
    }


    @Override
    public void update( Observable observable, Object o )
    {
        AlbumsAdapter adapter = (AlbumsAdapter) mAlbumsBinding.listA.getAdapter();
        AlbumsViewModel albumsViewModel = (AlbumsViewModel) observable;
        adapter.setAlbumsResponseList(albumsViewModel.getmAlbumsResponse());
    }
}
