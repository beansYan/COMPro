package com.example.ziyu16901.com.Activity;



import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.ziyu16901.com.Adapter.ViewpageAdapter;
import com.example.ziyu16901.com.Fragement.Fenlei;
import com.example.ziyu16901.com.Fragement.Friends;
import com.example.ziyu16901.com.Fragement.Huodong;
import com.example.ziyu16901.com.Note.MainShow;
import com.example.ziyu16901.com.Note.NoteActivity;
import com.example.ziyu16901.com.R;
import com.example.ziyu16901.com.Share.ShareToWeChat;
import com.example.ziyu16901.com.StartActivity;

/**
 * TODO
 */
public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private com.example.ziyu16901.com.Note.ActivityManager am;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, LoginActivity.class));
//                //startActivity(new Intent(ACTION_VIEW, Uri.parse("http://baidu.com")));
//            }
//        });


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);


        setSupportActionBar(toolbar);

        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);

        ab.setDisplayHomeAsUpEnabled(true);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        if (viewPager != null) {
            setupViewPager(viewPager);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this,NoteActivity.class);
                startActivity(intent);

            }
        });

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.about:
                AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
                adb.setTitle("关于我们");
                adb.setMessage("江西师大软件学院\n\t X3505工作室－－颜扬君，曾玲超");
                adb.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "谢谢",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                adb.show();
                break;
            case R.id.note:
                intent = new Intent(MainActivity.this,MainShow.class);
                startActivity(intent);
                return true;
            case R.id.liebiao:
                intent = new Intent(MainActivity.this,StartActivity.class);
                startActivity(intent);
                return true;
            case R.id.exit:
                AlertDialog.Builder adb2 = new AlertDialog.Builder(MainActivity.this);
                adb2.setTitle("消息");
                adb2.setMessage("真的要退出吗？");
                adb2.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        am.exitAllProgress();
                    }
                });
                adb2.setNegativeButton("取消", null);
                adb2.show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewpageAdapter.Adapter adapter = new ViewpageAdapter.Adapter(getSupportFragmentManager());

        adapter.addFragment(new Huodong(), "活动");
        adapter.addFragment(new Fenlei(), "分类");
        adapter.addFragment(new Friends(), "朋友");


        viewPager.setAdapter(adapter);
    }



    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {

                        switch (menuItem.getItemId()) {
                            case R.id.nav_Login:
                                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                                break;
                            case R.id.nav_Persona_Center:
                                startActivity(new Intent(MainActivity.this, PersonalCenterActivity.class));
                                break;
                            case R.id.nav_My_Organization:
                                startActivity(new Intent(MainActivity.this, MyOrganization.class));
                                break;
                            case R.id.nav_My_Activity:
                                startActivity(new Intent(MainActivity.this, MyActivity.class));
                                break;
                            case R.id.nav_Chat:
                                startActivity(new Intent(MainActivity.this, OnlineChat.class));
                                break;
                        }

                        // menuItem.setChecked(true);
//                        startActivity(new Intent(MainActivity.this, LoginActivity.class));
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }


}

