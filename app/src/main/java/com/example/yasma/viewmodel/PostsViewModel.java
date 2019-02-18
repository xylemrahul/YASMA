package com.example.yasma.viewmodel;

import com.example.yasma.Utils;
import com.example.yasma.data.RetrofitService;
import com.example.yasma.model.PostsResponse;
import com.example.yasma.view.MyApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PostsViewModel extends Observable {

    private List<PostsResponse> mPostResponse = new ArrayList<>();
    String TAG = PostsViewModel.class.getSimpleName();

    public PostsViewModel(){
        fetchPosts();
    }

    public void fetchPosts(){

        RetrofitService mApiService = MyApplication.getInstance().mAPIService;
        Disposable disposable = mApiService.fetchPosts().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(this::updatePostsDataSet, Utils::logThrowable);
    }

    private void updatePostsDataSet(List<PostsResponse> postsResponses) {
        mPostResponse.addAll(postsResponses);
        setChanged();
        notifyObservers();
    }

    public List<PostsResponse> getmPostResponse() {
        return mPostResponse;
    }
}
