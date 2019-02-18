package com.example.yasma.viewmodel;

import com.example.yasma.Log;
import com.example.yasma.data.RetrofitService;
import com.example.yasma.model.AlbumsResponse;
import com.example.yasma.view.MyApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AlbumsViewModel extends Observable
{

    private List<AlbumsResponse> mAlbumsResponse = new ArrayList<>();
    String TAG = PostsViewModel.class.getSimpleName();

    public AlbumsViewModel(){
        fetchAlbums();
    }

    public void fetchAlbums(){

        RetrofitService mApiService = MyApplication.getInstance().mAPIService;
        Disposable disposable = mApiService.fetchAlbums().subscribeOn( Schedulers.io())
                .observeOn( AndroidSchedulers.mainThread()).subscribe( this::updateAlbumDataSet, Log::logThrowable);
    }

    private void updateAlbumDataSet( List<AlbumsResponse> albumsResponse) {
        mAlbumsResponse.addAll(albumsResponse);
        setChanged();
        notifyObservers();
    }

    public List<AlbumsResponse> getmAlbumsResponse() {
        return mAlbumsResponse;
    }
}