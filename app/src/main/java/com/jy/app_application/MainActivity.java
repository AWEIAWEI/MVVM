package com.jy.app_application;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.jy.app_application.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";

    public ActivityMainBinding mActivityMainBinding;
    private MainViewModel mViewModel;

    public NewsAdapter mNewsAdapter;
    public List<News> mNewsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 设置dataBinding、viewModel
        mActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mViewModel = new MainViewModel(this);
        mActivityMainBinding.setViewModel(mViewModel);
        // 初始化RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mActivityMainBinding.recyclerView.setLayoutManager(layoutManager);
        mNewsAdapter = new NewsAdapter(this, mNewsList);
        mActivityMainBinding.recyclerView.setAdapter(mNewsAdapter);
        // 加载数据
        mViewModel.loadNews();
    }


}
