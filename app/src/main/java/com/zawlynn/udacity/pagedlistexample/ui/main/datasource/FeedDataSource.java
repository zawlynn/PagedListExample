package com.zawlynn.udacity.pagedlistexample.ui.main.datasource;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.zawlynn.udacity.pagedlistexample.constants.Constants;
import com.zawlynn.udacity.pagedlistexample.data.ApiService;
import com.zawlynn.udacity.pagedlistexample.data.model.Article;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.schedulers.Schedulers;

public class FeedDataSource extends PageKeyedDataSource<Long, Article> implements Constants {
    private ApiService apiService;
    private static final String TAG = "FeedDataSource";
    private Disposable disposable=new CompositeDisposable();
    public FeedDataSource(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Long> params, @NonNull LoadInitialCallback<Long, Article> callback) {
        disposable= Flowable.defer(() -> apiService.fetchFeed(QUERY, API_KEY, 1, params.requestedLoadSize)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .onErrorReturn(throwable -> {
                    throw Exceptions.propagate(throwable);
                })).subscribe(response -> {
            callback.onResult(response.body().getArticles(), null, 2l);
        });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Long> params, @NonNull LoadCallback<Long, Article> callback) {

    }

    @Override
    public void loadAfter(@NonNull LoadParams<Long> params, @NonNull LoadCallback<Long, Article> callback) {

       disposable= Flowable.defer(() -> apiService.fetchFeed(QUERY, API_KEY, params.key, params.requestedLoadSize)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .onErrorReturn(throwable -> {
                    throw Exceptions.propagate(throwable);
                })).subscribe(response -> {
            long nextKey = params.key == response.body().getTotalResults() ? null : params.key + 1;
            callback.onResult(response.body().getArticles(), nextKey);
        });
    }
    void clear(){
        disposable.dispose();
    }
}
