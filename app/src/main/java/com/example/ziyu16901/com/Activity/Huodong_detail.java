package com.example.ziyu16901.com.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import com.example.ziyu16901.com.Adapter.ViewpageAdapter;
import com.example.ziyu16901.com.Bean.CardData;
import com.example.ziyu16901.com.Fragement.Fenlei;
import com.example.ziyu16901.com.Fragement.Huodong;
import com.example.ziyu16901.com.R;


public class Huodong_detail extends AppCompatActivity  {

    public static final String EXTRA_NAME = "活动名称";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huodong_detail);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        if (viewPager != null) {
            setupViewPager(viewPager);
        }

        Intent intent = getIntent();
        final String cheeseName = intent.getStringExtra(EXTRA_NAME);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(cheeseName);
        loadBackdrop();
    }


    private void setupViewPager(ViewPager viewPager) {
        ViewpageAdapter.Adapter adapter = new ViewpageAdapter.Adapter(getSupportFragmentManager());
        //设配器及返回接口未完成暂代
        adapter.addFragment(new Huodong(), "详情");
        adapter.addFragment(new Fenlei(), "评论");


        viewPager.setAdapter(adapter);
    }

    private void loadBackdrop() {
        final ImageView imageView = (ImageView) findViewById(R.id.backdrop);
        Glide.with(this).load(CardData.getHuodongImage()).centerCrop().into(imageView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


}


