package com.example.study;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface PostGetInterfaceJson {



        @POST("/post/{new}.json")
        Call<Annonce> setAnnonce(@Path("new") String s1, @Body Annonce annonce);

        @GET("/post/users.json")
        Call<Annonce> getAnnonce();

//    @GET("/post/issam.json")
//    Call<List<Post>> getPosts();

}
