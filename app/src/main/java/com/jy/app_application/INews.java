package com.jy.app_application;

import retrofit2.Call;
import retrofit2.http.GET;

public interface INews {
    @GET(".")
    Call<Feed> getFeed();
}