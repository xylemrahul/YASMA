package com.example.yasma.viewmodel;

import com.example.yasma.Utils;
import com.example.yasma.data.RetrofitService;
import com.example.yasma.model.AlbumDetailsResponse;
import com.example.yasma.view.MyApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AlbumDetailsViewModel extends Observable {

    private List<AlbumDetailsResponse> mAlbumDetailsResponse = new ArrayList<>();
    private int id;

    public AlbumDetailsViewModel(int id) {
        this.id = id;
        fetchAlbums(id);
    }

    public void fetchAlbums(int id) {

        RetrofitService mApiService = MyApplication.getInstance().mAPIService;
        Disposable disposable = mApiService.fetchAlbumDetails(String.valueOf(id)).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(this::updateAlbumDataSet, Utils::logThrowable);
    }

    private void updateAlbumDataSet(List<AlbumDetailsResponse> albumsResponse) {
        mAlbumDetailsResponse.addAll(albumsResponse);
        setChanged();
        notifyObservers();
    }

    public List<AlbumDetailsResponse> getmAlbumsResponse() {
        return mAlbumDetailsResponse;
    }
}
