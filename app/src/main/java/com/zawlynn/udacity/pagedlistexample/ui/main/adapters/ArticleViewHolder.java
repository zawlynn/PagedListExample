package com.zawlynn.udacity.pagedlistexample.ui.main.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.zawlynn.udacity.pagedlistexample.R;
import com.zawlynn.udacity.pagedlistexample.data.model.Article;

import butterknife.BindView;
import butterknife.ButterKnife;


class ArticleViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.item_title)
    TextView item_title;
    @BindView(R.id.item_image)
    ImageView item_image;
    private Context context;
    ArticleViewHolder(View itemLayoutView) {
        super(itemLayoutView);
        ButterKnife.bind(this, itemLayoutView);
        context=itemLayoutView.getContext();
    }

    void bind(Article movie) {
        item_title.setText(movie.getTitle());
        Glide.with(context).load(movie.getUrlToImage()).into(item_image);
    }
}
