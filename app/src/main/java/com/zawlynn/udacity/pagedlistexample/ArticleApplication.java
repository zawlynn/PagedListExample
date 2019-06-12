package com.zawlynn.udacity.pagedlistexample;

import android.app.Application;
import android.util.Log;
import com.zawlynn.udacity.pagedlistexample.di.component.DaggerDataComponent;
import com.zawlynn.udacity.pagedlistexample.di.component.DataComponent;
import com.zawlynn.udacity.pagedlistexample.di.module.ApplicationContextModule;

public class ArticleApplication extends Application {
    private static final String TAG = "ArticleApplication";

    static ArticleApplication instance;
    DataComponent component;
    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        component= DaggerDataComponent.builder().applicationContextModule(new ApplicationContextModule(this)).build();
    }
    public static ArticleApplication getInstance(){
        return instance;
    }
    public DataComponent getArticleComponent() {
        return component;
    }
}
