package com.zawlynn.udacity.pagedlistexample.data.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.zawlynn.udacity.pagedlistexample.data.database.dao.ArticleDao;
import com.zawlynn.udacity.pagedlistexample.data.model.Article;

@Database(entities = {Article.class},version = 2,exportSchema = false)
public abstract class  ArticleDatabase extends RoomDatabase {
    public abstract ArticleDao getArticleDao();
}
