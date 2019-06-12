package com.zawlynn.udacity.pagedlistexample.ui.main.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.zawlynn.udacity.pagedlistexample.R;
import com.zawlynn.udacity.pagedlistexample.data.model.Article;
import com.zawlynn.udacity.pagedlistexample.utils.AppUtils;

import butterknife.BindView;
import butterknife.ButterKnife;


class ArticleViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.item_title)
    TextView item_title;
    @BindView(R.id.item_desc)
    TextView item_desc;
    @BindView(R.id.item_image)
    ImageView item_image;
    @BindView(R.id.item_time)
    TextView item_time;
    private Context context;
    ArticleViewHolder(View itemLayoutView) {
        super(itemLayoutView);
        ButterKnife.bind(this, itemLayoutView);
        context=itemLayoutView.getContext();
    }

    void bind(Article article) {
        item_desc.setText(article.getDescription());
        item_time.setText(String.format(context.getString(R.string.item_date), AppUtils.getInstance().getDate(article.getPublishedAt()), AppUtils.getInstance().getTime(article.getPublishedAt())));
        String author = article.getAuthor() == null || article.getAuthor().isEmpty() ? context.getString(R.string.author_name) : article.getAuthor();
        String titleString = String.format(context.getString(R.string.item_title), author, article.getTitle());
        SpannableString spannableString = new SpannableString(titleString);
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context.getApplicationContext(), R.color.secondary_text)),
                titleString.lastIndexOf(author) + author.length() + 1, titleString.lastIndexOf(article.getTitle()) - 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        item_title.setText(spannableString);
        Glide.with(context).load(article.getUrlToImage()).into(item_image);
    }
}
