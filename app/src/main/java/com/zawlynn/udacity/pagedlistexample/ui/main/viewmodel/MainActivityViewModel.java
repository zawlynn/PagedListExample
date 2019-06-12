package com.zawlynn.udacity.pagedlistexample.ui.main.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.zawlynn.udacity.pagedlistexample.ArticleApplication;
import com.zawlynn.udacity.pagedlistexample.data.ApiService;
import com.zawlynn.udacity.pagedlistexample.data.database.dao.ArticleDao;
import com.zawlynn.udacity.pagedlistexample.data.model.Article;
import com.zawlynn.udacity.pagedlistexample.data.datasource.FeedDataFactory;


import javax.inject.Inject;


public class MainActivityViewModel extends AndroidViewModel {
    private static final String TAG = "MainActivityViewModel";
    @Inject
    public ApiService apiService;
    @Inject
    public ArticleDao articleDao;
    private LiveData  articleLiveData;
    private FeedDataFactory feedDataFactory;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        ArticleApplication.getInstance().getArticleComponent().inject(this);
        init();
    }
    private void init(){
        feedDataFactory = FeedDataFactory.getInstance(apiService);
        PagedList.Config pagedListConfig = new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(10)
                .setPageSize(20).build();
        articleLiveData=new LivePagedListBuilder(feedDataFactory, pagedListConfig).build();
    }

    public LiveData<PagedList<Article>> getArticleLiveData() {
        return articleLiveData;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        feedDataFactory.dispose();
    }
}
