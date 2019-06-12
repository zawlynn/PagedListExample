package com.zawlynn.udacity.pagedlistexample.ui.main.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.ListAdapter;

import com.zawlynn.udacity.pagedlistexample.R;
import com.zawlynn.udacity.pagedlistexample.data.model.Article;


public class ArticleNewsAdapter extends PagedListAdapter<Article,ArticleViewHolder> {
    public ArticleNewsAdapter() {
        super(new ArticleItemCallback());
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemLayoutView =LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed, parent, false);
        return new ArticleViewHolder(itemLayoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ArticleViewHolder holder, int i) {
        holder.bind(getItem(i));
    }
}
