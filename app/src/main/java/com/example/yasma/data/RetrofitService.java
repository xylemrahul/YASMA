package com.example.yasma.data;

import com.example.yasma.model.AlbumPhoto;
import com.example.yasma.model.AlbumsResponse;
import com.example.yasma.model.PostComments;
import com.example.yasma.model.PostsResponse;
import com.example.yasma.model.UsersResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitService {

    //Posts
    @GET("posts")
    Observable<List<PostsResponse>> fetchPosts();
    @GET("posts/{post_id}")
    Observable<PostsResponse> fetchPostDetails(@Path("post_id") String postId);
    @GET("post/{post_id}/comments")
    Observable<List<PostComments>> fetchPostComments(@Path("post_id") String postId);

    //Albums
    @GET("albums")
    Observable<List<AlbumsResponse>> fetchAlbums();
    @GET("albums/{album_id}")
    Observable<AlbumsResponse> fetchAlbumDetails(@Path("album_id") String albumId);
    @GET("albums/{album_id}/photos")
    Observable<List<AlbumPhoto>> fetchAlbumPhotos(@Path("album_id") String albumId);

    //Users
    @GET("users")
    Observable<List<UsersResponse>> fetchUsers();
    @GET("users/{user_id}")
    Observable<UsersResponse> fetchUserDetails(@Path("user_id") String userId);









}
