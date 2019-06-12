package com.zawlynn.udacity.pagedlistexample.data;

import com.zawlynn.udacity.pagedlistexample.data.model.Feed;

import io.reactivex.Flowable;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("/v2/everything")
    Flowable<Response<Feed>> fetchFeed(@Query("q") String q,
                                      @Query("apiKey") String apiKey,
                                      @Query("page") long page,
                                      @Query("pageSize") int pageSize);
}
