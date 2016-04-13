package com.example.ziyu16901.com;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.ziyu16901.com.Activity.LoginActivity;
import com.example.ziyu16901.com.Activity.MainActivity;

import cn.bmob.v3.Bmob;

@SuppressWarnings("unused")
public class SplashScreen extends Activity {

    private static final String APPID="ee11d73ae5e6214af7941ab825504e09";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // 初始化 Bmob SDK
        // 使用时请将第二个参数Application ID替换成你在Bmob服务器端创建的Application ID
        Bmob.initialize(this, APPID);
        setContentView(R.layout.content_splash_screen);
        mHandler.sendEmptyMessageDelayed(GO_LOGIN, 3000);
    }
//        PackageManager pm = getPackageManager();
//        try {
//            PackageInfo pi = pm.getPackageInfo("com.example.ziyu16901.com", 0);
//            TextView versionNumber = (TextView) findViewById(R.id.versionNumber);
//            versionNumber.setText("Version " + pi.versionName);
//        } catch (PackageManager.NameNotFoundException e) {
//            e.printStackTrace();
//        }
//无需登录直接跳转到主页
//        new Handler().postDelayed(new Runnable() {
//            public void run() {
//                /* Create an Intent that will start the Main WordPress Activity. */
//                Intent mainIntent = new Intent(SplashScreen.this, MainActivity.class);
//                SplashScreen.this.startActivity(mainIntent);
//                SplashScreen.this.finish();
//            }
//        }, 2900); //2900 for release


    private static final int GO_HOME = 100;
    private static final int GO_LOGIN = 200;

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case GO_HOME:
                    break;
                case GO_LOGIN:
                    Intent intent = new Intent(SplashScreen.this,
                            LoginActivity.class);
                    startActivity(intent);
                    finish();
                    break;
            }
        }
    };
}

