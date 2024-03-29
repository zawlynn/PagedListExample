package com.zawlynn.udacity.pagedlistexample.data.datasource;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

import com.zawlynn.udacity.pagedlistexample.data.ApiService;

public class FeedDataFactory extends DataSource.Factory {

    private FeedDataSource feedDataSource;
    private ApiService apiService;

    private static FeedDataFactory instance;
    public static FeedDataFactory getInstance(ApiService apiService){
        if(instance==null){
            instance=new FeedDataFactory(apiService);
        }
        return instance;
    }
    private FeedDataFactory(ApiService apiService){
        this.apiService=apiService;
    }
    @Override
    public DataSource create() {
        feedDataSource = new FeedDataSource(apiService);
        return feedDataSource;
    }

    public void dispose(){
        feedDataSource.clear();
    }
}
