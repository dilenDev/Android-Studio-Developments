package com.mobdev.class_retrofit_with_rest_api;

import com.mobdev.class_retrofit_with_rest_api.Model.Comment;
import com.mobdev.class_retrofit_with_rest_api.Model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JsonPlaceHolderAPI {

    @GET("posts")
    Call<List<Post>> getPosts();

    //retrieve exact post value data

//    @GET("posts/4/comments")
//    Call<List<Comment>> getComments();

      @GET("posts/{id}/comments")
      Call<List<Comment>> getComments(@Path("id") int postId);
}
