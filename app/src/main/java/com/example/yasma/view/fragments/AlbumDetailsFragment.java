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
import com.example.yasma.databinding.AlbumDetailsFragmentBinding;
import com.example.yasma.model.AlbumsResponse;
import com.example.yasma.view.adapters.AlbumDetailsAdapter;
import com.example.yasma.view.adapters.AlbumsAdapter;
import com.example.yasma.viewmodel.AlbumDetailsViewModel;
import com.example.yasma.viewmodel.AlbumsViewModel;

import java.util.Observable;
import java.util.Observer;

import static com.example.yasma.Utils.ALBUMS_EXTRA;

public class AlbumDetailsFragment extends Fragment implements Observer {

    private AlbumDetailsViewModel albumDetailsViewModel;
    AlbumsResponse mResponse;
    private AlbumDetailsFragmentBinding mAlbumsBinding;

    public static AlbumDetailsFragment newInstance(Bundle extras){
        AlbumDetailsFragment detailsFragment = new AlbumDetailsFragment();
        detailsFragment.setArguments(extras);
        return detailsFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mAlbumsBinding = DataBindingUtil.inflate(inflater, R.layout.album_details_fragment, container, false);
        mAlbumsBinding.listAlbumDetails.setLayoutManager(new LinearLayoutManager( getContext()));
        mAlbumsBinding.listAlbumDetails.setAdapter(new AlbumDetailsAdapter());

        return mAlbumsBinding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getActivity().getIntent().getExtras();
        if(bundle !=null) {
            mResponse = (AlbumsResponse) bundle.get(ALBUMS_EXTRA);
        }
        albumDetailsViewModel = new AlbumDetailsViewModel(mResponse.getId());
        setupObserver(albumDetailsViewModel);
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle("AlbumDetailsFragment");
    }

    public void setupObserver(Observable observable) {
        observable.addObserver(this);
    }


    @Override
    public void update(Observable observable, Object arg) {
        AlbumDetailsAdapter adapter = (AlbumDetailsAdapter) mAlbumsBinding.listAlbumDetails.getAdapter();
        AlbumDetailsViewModel albumDetailsViewModel = (AlbumDetailsViewModel) observable;
        if (adapter != null) {
            adapter.setAlbumsResponseList(albumDetailsViewModel.getmAlbumsResponse());
        }
    }
}
