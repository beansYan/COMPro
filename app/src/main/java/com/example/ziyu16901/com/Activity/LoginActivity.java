package com.example.ziyu16901.com.Activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ziyu16901.com.Bean.User;
import com.example.ziyu16901.com.R;
import com.example.ziyu16901.com.util.Util;

import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.update.BmobUpdateAgent;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends Activity implements OnClickListener{

    @SuppressWarnings("unused")
    private static final String TAG = "LoginActicity";

    private Button btnLogin;
    private Button btnReg;
    private Button btnResetPsd;
    private EditText etUsername;
    private EditText etPassword;

    private String username;
    private String password;

    @SuppressWarnings("unused")
    private static final String APP_ID = "101080318";
    @SuppressWarnings("unused")
    private TextView backInfo;
//    @SuppressWarnings("unused")
//    private UserInfo mInfo;


    private TextView mUserInfo;
    private ImageView mUserLogo;
    private ImageView mNewLoginButton;


    //QQ登陆
//  private Tencent mTencent;
//	private QQAuth mQQAuth;
    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0) {
                mUserInfo.setVisibility(android.view.View.VISIBLE);
                mUserInfo.setText(msg.getData().getString("nickname"));
            } else if (msg.what == 1) {
                Bitmap bitmap = (Bitmap) msg.obj;
                mUserLogo.setImageBitmap(bitmap);
                mUserLogo.setVisibility(android.view.View.VISIBLE);
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Bmob自动更新组件
        BmobUpdateAgent.setUpdateOnlyWifi(true);
        BmobUpdateAgent.update(this);

        //QQ登陆, 获取实例
//		mQQAuth = QQAuth.createInstance(APP_ID, this.getApplicationContext());
//		mTencent = Tencent.createInstance(APP_ID, this.getApplicationContext());

        btnLogin = (Button) findViewById(R.id.btn_login);
        btnReg = (Button) findViewById(R.id.btn_register);
        btnResetPsd = (Button) findViewById(R.id.btn_reset_psd);

        etUsername = (EditText) findViewById(R.id.et_username);
        etPassword = (EditText) findViewById(R.id.et_password);

        btnLogin.setOnClickListener(this);
        btnReg.setOnClickListener(this);
        btnResetPsd.setOnClickListener(this);

//        mUserInfo = (TextView) findViewById(R.id.user_nickname);
//        mUserLogo = (ImageView) findViewById(R.id.user_logo);
//        mNewLoginButton = (ImageView) findViewById(R.id.new_login_btn);
//        mNewLoginButton.setOnClickListener(this);
//        backInfo = (TextView) findViewById(R.id.user_callback);

        getUserInfo();

    }

    private void getUserInfo() {
        SharedPreferences sp = getSharedPreferences("UserInfo", 0);
        etUsername.setText(sp.getString("username", null));
        etPassword.setText(sp.getString("password", null));
    }

    //保存用户的登陆记录
    private void saveUserInfo(String username, String password) {
        SharedPreferences sp = getSharedPreferences("UserInfo", 0);
        Editor editor = sp.edit();
        editor.putString("username", username);
        editor.putString("password", password);
        editor.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // 登陆
            case R.id.btn_login:
                username = etUsername.getText().toString();
                password = etPassword.getText().toString();

                if( !Util.isNetworkConnected(this) ){
                    toast("亲, 木有网络 ( ⊙ o ⊙ ) ");
                } else if (username.equals("") || password.equals("")) {
                    toast("亲, 请输入账号和密码");
                    break;
                } else {
                    User bu2 = new User();
                    bu2.setUsername(username);
                    bu2.setPassword(password);
                    bu2.login(this, new SaveListener() {
                        @Override
                        public void onSuccess() {
                            toast("登录成功~");
                            //保存用户信息
                            saveUserInfo(username, password);
                            // 跳转到主页
                            Intent toHome = new Intent(LoginActivity.this,
                                    MainActivity.class);
                            startActivity(toHome);
                            finish();
                        }

                        @Override
                        public void onFailure(int arg0, String msg) {
                            toast("亲, 用户名或密码错误");
                        }
                    });
                }
                break;

            case R.id.btn_reset_psd:
                Intent toResetPsdActivity = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(toResetPsdActivity);
                break;

            case R.id.btn_register:
                Intent toReg = new Intent(LoginActivity.this,
                        RegisterActivity.class);
                startActivity(toReg);
                break;
//		case R.id.new_login_btn:
//			onClickLogin();
//			break;
            default:
                break;

        }
    }

    public void toast(String toast) {
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
    }

}