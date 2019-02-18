package com.example.yasma.view.fragments;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
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
import com.example.yasma.databinding.PostDetailsFragmentBinding;
import com.example.yasma.model.AlbumsResponse;
import com.example.yasma.model.PostsResponse;
import com.example.yasma.view.adapters.AlbumsAdapter;
import com.example.yasma.view.adapters.PostDetailsAdapter;
import com.example.yasma.viewmodel.AlbumDetailsViewModel;
import com.example.yasma.viewmodel.PostDetailsViewModel;

import java.util.Observable;
import java.util.Observer;

import static com.example.yasma.Utils.ALBUMS_EXTRA;
import static com.example.yasma.Utils.POSTS_EXTRA;

public class PostDetailsFragment extends Fragment implements Observer {

    private PostDetailsViewModel postDetailsViewModel;
    PostsResponse mResponse;
    private PostDetailsFragmentBinding mPostBinding;

    public static PostDetailsFragment newInstance(Bundle extras){
        PostDetailsFragment detailsFragment = new PostDetailsFragment();
        detailsFragment.setArguments(extras);
        return detailsFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mPostBinding = DataBindingUtil.inflate(inflater, R.layout.post_details_fragment, container, false);
        mPostBinding.listPostDetails.setLayoutManager(new LinearLayoutManager( getContext()));
        mPostBinding.listPostDetails.setAdapter(new PostDetailsAdapter());

        return mPostBinding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getActivity().getIntent().getExtras();
        if(bundle !=null) {
            mResponse = (PostsResponse) bundle.get(POSTS_EXTRA);
        }
        postDetailsViewModel = new PostDetailsViewModel(mResponse.getId());
        setupObserver(postDetailsViewModel);
    }

    public void setupObserver(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle("PostDetailsFragment");
    }

    @Override
    public void update(Observable observable, Object arg) {
        PostDetailsAdapter adapter = (PostDetailsAdapter) mPostBinding.listPostDetails.getAdapter();
        PostDetailsViewModel postDetailsViewModel = (PostDetailsViewModel) observable;
        if (adapter != null) {
            adapter.setPostDetailsResponseList(postDetailsViewModel.getmPostComments());
        }
    }
}
