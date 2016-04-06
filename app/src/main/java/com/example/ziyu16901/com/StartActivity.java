package com.example.ziyu16901.com;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ziyu16901.com.Activity.Huodong_detail;
import com.example.ziyu16901.com.Activity.LoginActivity;
import com.example.ziyu16901.com.Activity.MainActivity;
import com.example.ziyu16901.com.Activity.MessageActivity;
import com.example.ziyu16901.com.Activity.PersonalCenterActivity;
import com.example.ziyu16901.com.Activity.PersonalMessageActivity;
import com.example.ziyu16901.com.Activity.TableActivity;
import com.example.ziyu16901.com.Note.MainShow;
import com.example.ziyu16901.com.Share.ShareToWeChat;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);


        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartActivity.this, LoginActivity.class));
                //startActivity(new Intent(ACTION_VIEW, Uri.parse("http://baidu.com")));
            }
        });

        findViewById(R.id.table).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartActivity.this, TableActivity.class));
            }
        });

        findViewById(R.id.personalmessage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartActivity.this, PersonalMessageActivity.class));
            }
        });

        findViewById(R.id.personalcenter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartActivity.this, PersonalCenterActivity.class));
            }
        });
        findViewById(R.id.message).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartActivity.this, MessageActivity.class));
            }
        });


        findViewById(R.id.main).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartActivity.this, MainActivity.class));
            }
        });

        findViewById(R.id.detail).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartActivity.this, Huodong_detail.class));
            }
        });

        findViewById(R.id.share).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartActivity.this, ShareToWeChat.class));
            }
        });

        findViewById(R.id.note).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartActivity.this, MainShow.class));
            }
        });
    }



}
