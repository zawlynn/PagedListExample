package com.zawlynn.udacity.pagedlistexample.di.module;


import android.app.Application;

import androidx.room.Room;

import com.zawlynn.udacity.pagedlistexample.data.database.ArticleDatabase;
import com.zawlynn.udacity.pagedlistexample.data.database.dao.ArticleDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {

    @Provides
    @Singleton
    ArticleDao provideArticleDato(ArticleDatabase database){
        return database.getArticleDao();
    }

    @Provides
    @Singleton
    ArticleDatabase provideContactsAppDatabase(Application application){
        return Room.databaseBuilder(application, ArticleDatabase.class,"article_db").build();
    }

}
