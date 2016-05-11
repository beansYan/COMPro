package com.example.ziyu16901.com.Activity;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.ziyu16901.com.Adapter.ViewpageAdapter;
import com.example.ziyu16901.com.Bean.CardData;
import com.example.ziyu16901.com.Bean.SheTuan;
import com.example.ziyu16901.com.Fragement.Fenlei;
import com.example.ziyu16901.com.Fragement.Huodong;
import com.example.ziyu16901.com.R;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.GetListener;

public class SheTuan_Detail extends AppCompatActivity {

//    public static final String EXTRA_NAME = "社团名称";
    // 从上级页面中传入的数据
    private SheTuan shetuan; // 当期选择的Shop
    private String shetuanID; // 当前选择的Shop的ID
    private String shetuanName;
    private TextView jianjie;  //社团简介内容
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shetuan__detail);

//        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
//        if (viewPager != null) {
//            setupViewPager(viewPager);
//        }

        shetuan = (SheTuan) getIntent().getSerializableExtra("shetuan");
        shetuanID = getIntent().getStringExtra("shetuanID");
        shetuanName= getIntent().getStringExtra("shetuanName");
        jianjie = (TextView) findViewById(R.id.shetuan_jianjie);


        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
//        tabLayout.setupWithViewPager(viewPager);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(shetuanName);
        loadBackdrop();

        getSheTuanJianjie();
    }


    private void getSheTuanJianjie(){
        BmobQuery<SheTuan> query = new BmobQuery<SheTuan>();
        query.getObject(this, shetuanID, new GetListener<SheTuan>() {

            @Override
            public void onSuccess(SheTuan object) {
                // TODO Auto-generated method stub
                toast("查询成功：");
                //获得playerName的信息
                object.getJianjie();
                jianjie.setText(object.getJianjie());
            }

            @Override
            public void onFailure(int code, String arg0) {
                // TODO Auto-generated method stub
                toast("查询失败："+arg0);
            }

        });
    }
//    private void setupViewPager(ViewPager viewPager) {
//        ViewpageAdapter.Adapter adapter = new ViewpageAdapter.Adapter(getSupportFragmentManager());
//        //设配器及返回接口未完成暂代
//        adapter.addFragment(new Huodong(), "详情");
//        adapter.addFragment(new Fenlei(), "评论");
//
//
//        viewPager.setAdapter(adapter);
//    }

    private void loadBackdrop() {
        final ImageView imageView = (ImageView) findViewById(R.id.backdrop);
        Glide.with(this).load(CardData.getHuodongImage()).centerCrop().into(imageView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void toast(String toast) {
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
    }


}


