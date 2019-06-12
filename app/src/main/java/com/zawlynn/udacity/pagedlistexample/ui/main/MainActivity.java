package com.zawlynn.udacity.pagedlistexample.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.zawlynn.udacity.pagedlistexample.R;
import com.zawlynn.udacity.pagedlistexample.ui.main.adapters.ArticleNewsAdapter;
import com.zawlynn.udacity.pagedlistexample.ui.main.viewmodel.MainActivityViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    MainActivityViewModel viewModel;
    @BindView(R.id.recArticle)
    RecyclerView recArticle;
    ArticleNewsAdapter adapter;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        viewModel= ViewModelProviders.of(this).get(MainActivityViewModel.class);
        viewModel.getArticleLiveData().observe(this, articles -> {
            if(articles!=null){
                adapter.submitList(articles);
            }
        });
        init();
    }
    public void init(){
        adapter = new ArticleNewsAdapter();
        recArticle.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recArticle.setAdapter(adapter);

    }
}
