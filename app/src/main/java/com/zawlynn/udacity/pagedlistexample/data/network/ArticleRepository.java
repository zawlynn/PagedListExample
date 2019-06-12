package com.zawlynn.udacity.pagedlistexample.data.network;

import android.util.Log;

import com.zawlynn.udacity.pagedlistexample.data.ApiService;
import com.zawlynn.udacity.pagedlistexample.data.database.ArticleDatabase;

import javax.inject.Inject;

public class ArticleRepository {
    private static final String TAG = "ArticleRepository";
    @Inject
    ApiService apiService;
    @Inject
    ArticleDatabase database;
    private static ArticleRepository instance;
    public static ArticleRepository getInstance(ApiService apiService, ArticleDatabase database){
        if(instance==null){
            instance=new ArticleRepository(apiService,  database);
        }
        return instance;
    }

    public ArticleRepository(ApiService apiService, ArticleDatabase database) {
        this.apiService = apiService;
        this.database = database;
    }
}
