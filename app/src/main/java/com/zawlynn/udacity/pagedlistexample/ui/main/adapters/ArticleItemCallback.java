package com.zawlynn.udacity.pagedlistexample.ui.main.adapters;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import com.zawlynn.udacity.pagedlistexample.data.model.Article;

public class ArticleItemCallback extends  DiffUtil.ItemCallback<Article>{
    public boolean areItemsTheSame(@NonNull Article oldItem, @NonNull Article newItem) {
        return oldItem.getId() == newItem.getId();
    }

    @Override
    public boolean areContentsTheSame(@NonNull Article oldItem, @NonNull Article newItem) {
        return oldItem.equals(newItem);
    }
}
