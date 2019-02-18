package com.example.yasma.viewmodel;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.yasma.Utils;
import com.example.yasma.data.RetrofitService;
import com.example.yasma.model.PostDetailsResponse;
import com.example.yasma.view.MyApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PostDetailsViewModel extends Observable {

    private List<PostDetailsResponse> mPostComments = new ArrayList<>();
    private int id;

    public PostDetailsViewModel(int id){
        this.id = id;
        fetchPostsDetails(id);
    }

    public void fetchPostsDetails(int id){

        RetrofitService mApiService = MyApplication.getInstance().mAPIService;
        Disposable disposable = mApiService.fetchPostComments(String.valueOf(id)).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(this::updatePostsDataSet, Utils::logThrowable);
    }

    private void updatePostsDataSet(List<PostDetailsResponse> postComments) {
        mPostComments.addAll(postComments);
        setChanged();
        notifyObservers();
    }

    public List<PostDetailsResponse> getmPostComments() {
        return mPostComments;
    }
}
