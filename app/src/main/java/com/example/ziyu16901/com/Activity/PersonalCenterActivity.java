package com.example.ziyu16901.com.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.CollapsingToolbarLayout;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;


import com.example.ziyu16901.com.Bean.MessageDef;
import com.example.ziyu16901.com.Bean.SheTuan;
import com.example.ziyu16901.com.Bean.User;
import com.example.ziyu16901.com.Note.NoteActivity;
import com.example.ziyu16901.com.R;


import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class PersonalCenterActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "个人主页";

    private static final int ONE_COMMENT_CODE = -1;
    private static final int TWO_COMMENT_CODE = 2;


    private TextView tvUsername;
    private TextView tvSchool;
    private TextView tvCademy;
    private TextView tvBelongCom;
    private TextView tvSex;
    private TextView tvPhone;
    private TextView tvQQ;

    private Intent intent;

    private User curUser ;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MessageDef.MINE_INFO_FINISH_FIND_USER:
                    initView();
                    break;
                default:
                    break;
            }
        }
    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_center);




        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(EXTRA_NAME);


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabedit);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                intent = new Intent(PersonalCenterActivity.this, PersonalInfoEditActivity.class);
//                startActivity(intent);
//
//            }
//        });

        getCurUser();
    }

    private void initView() {
        tvUsername = (TextView) findViewById(R.id.tv_mineinfo_username);
        tvSchool = (TextView) findViewById(R.id.tv_mineinfo_school);
        tvCademy = (TextView) findViewById(R.id.tv_mineinfo_cademy);
        tvBelongCom = (TextView) findViewById(R.id.tv_mineinfo_belongcom);
        tvSex = (TextView) findViewById(R.id.tv_mineinfo_sex);
        tvPhone = (TextView) findViewById(R.id.tv_mineinfo_phone);
        tvQQ = (TextView) findViewById(R.id.tv_mineinfo_qq);

        tvUsername.setText(curUser.getUsername());
        tvSchool.setText(curUser.getSchool());
        tvCademy.setText(curUser.getCademy());
        tvBelongCom.setText(curUser.getBelongCom());
        tvSex.setText(curUser.getSex());
        tvPhone.setText(curUser.getPhone());
        tvQQ.setText(curUser.getQQ());
    }

    private void getCurUser() {
        curUser = BmobUser.getCurrentUser(this, User.class);
        if(curUser!=null)
        {
            Message msg = new Message();
            msg.what = MessageDef.MINE_INFO_FINISH_FIND_USER;
            mHandler.sendMessage(msg);
        }
    }

    private void refresh()
    {
        getCurUser();
        initView();
    }

    public void fabedit(View v) {
        Intent toEditMineInfo = new Intent(PersonalCenterActivity.this, PersonalInfoEditActivity.class);
//		Bundle bundle = new Bundle();
//		bundle.putString("username", curUser.getUsername());
//		bundle.putString("school", curUser.getSchool());
//		bundle.putString("cademy", curUser.getCademy());
//		bundle.putString("dorpart", curUser.getDorPart());
//		bundle.putString("dornum", curUser.getDorNum());
//		bundle.putString("phone", curUser.getPhone());
//		bundle.putString("qq", curUser.getQQ());
//		toEditMineInfo.putExtras(bundle);
        startActivityForResult(toEditMineInfo, 200);
    }

public void setsj(View v){
    final SheTuan setsheTuan = new SheTuan();
//注意：不能调用gameScore.setObjectId("")方法
//    curSheTuan.setId("000");
//    curSheTuan.setName("瑶湖之声合唱团");
//    curSheTuan.setGuakao("校团委");
//    curSheTuan.setLeibie("文学艺术类");
//    curSheTuan.setUsername("yyj");
    setsheTuan.setJianjie("瑶湖之声合唱团，前身为江西师范大学大学生艺术合唱团，成立于1983年3月。" +
            "至今，已有30余年的历史。是江西师范大学大学生艺术团分团内历史最为悠久的艺术团体。" +
            "江西师范大学大学生合唱团于2014年夏天，正式更名为“瑶湖之声合唱团”。瑶湖之声合唱团的指导老师由省级著名青年歌唱家担任。" +
            "主要以偏美声唱法为主，集民族唱法和通俗唱法为辅的歌唱艺术团体。是江西师范大学大学生艺术团一份不可或缺的力量。");
//    curSheTuan.update(this,curSheTuan.getObjectId(), new UpdateListener() {
    setsheTuan.update(this,"4b787330ad", new UpdateListener() {

        @Override
        public void onSuccess() {
            // TODO Auto-generated method stub
            Log.i("bmob", "更新成功：");
            toast("更新成功");
        }

        @Override
        public void onFailure(int code, String msg) {
            // TODO Auto-generated method stub
            Log.i("bmob","更新失败："+msg);
        }
    });
}
    public void clickBack(View v) {
        finish();
    }

    @SuppressWarnings("unused")
    private void toast(String toast) {
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 200) {
            refresh();
        }
    }

 }


