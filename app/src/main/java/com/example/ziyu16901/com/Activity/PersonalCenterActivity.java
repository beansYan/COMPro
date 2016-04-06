package com.example.ziyu16901.com.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.ziyu16901.com.Adapter.CommentAdapter;
import com.example.ziyu16901.com.Adapter.CommentReplyAdapter;
import com.example.ziyu16901.com.Bean.CardData;
import com.example.ziyu16901.com.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;


public class PersonalCenterActivity extends AppCompatActivity implements OnClickListener {

    public static final String EXTRA_NAME = "个人主页";
    private ListView lv_user_comments;
    private LinearLayout ll_comment;
    private FloatingActionButton btn_comment;
    private FloatingActionButton btn_reply;
    private EditText edt_comment_content, edt_reply;
    private TextView tv_reply;
    private ImageButton btn;
    private CommentAdapter commentAdapter;
    private CommentReplyAdapter commentReplyAdapter;

    private static final int ONE_COMMENT_CODE = -1;
    private static final int TWO_COMMENT_CODE = 2;

    private List<HashMap<String, Object>> list_comment; // 一级评论数据
    private List<List<HashMap<String, Object>>> list_comment_child; // 二级评论数据

    int flag = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_center);
        initList();
        initView();
        initCommentData();

       /* Intent intent = getIntent();*/
      /*  final String cheeseName = intent.getStringExtra(EXTRA_NAME);*/



        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(EXTRA_NAME);

        loadBackdrop();
    }

    private void initCommentData() {
        // TODO Auto-generated method stub
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("content", "helloWorld");
        list_comment.add(map);
        // list_comment_child.add(list_comment);
        // List<HashMap<String, Object>> list = new ArrayList<HashMap<String,
        // Object>>();
        // HashMap<String, Object> map2 = new HashMap<String, Object>();
        // map2.put("content", "测试2");
        // list.add(map2);
        // list_comment_child.add(list);
        list_comment_child.add(new ArrayList<HashMap<String, Object>>());
        commentReplyAdapter = null;
        commentAdapter = new CommentAdapter(this, list_comment,
                list_comment_child, myOnitemcListener, commentReplyAdapter);
        lv_user_comments.setAdapter(commentAdapter);
    }

    private void initList() {
        // TODO Auto-generated method stub
        list_comment = new ArrayList<HashMap<String, Object>>();
        list_comment_child = new ArrayList<List<HashMap<String, Object>>>();
    }

    private void initView() {
        // TODO Auto-generated method stub
        lv_user_comments = (ListView) this.findViewById(R.id.lv_comments);
        btn_comment = (FloatingActionButton) this.findViewById(R.id.btn_main_send);
        tv_reply = (TextView) this.findViewById(R.id.tv_user_reply);

        btn_comment.setOnClickListener(this);
       /* btn = (ImageButton) this.findViewById(R.id.dz);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (flag == 0) {

                    ((ImageButton) v).setImageDrawable(getResources().getDrawable(R.drawable.likeicon));
                    flag = 1;
                } else {
                    ((ImageButton) v).setImageDrawable(getResources().getDrawable(R.drawable.likeicon2));
                    flag = 0;
                }
            }
        });*/

    }
    private OnClickListener myOnitemcListener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            int position = (Integer) v.getTag();
            System.out.println("-----------" + position);
            showDialog(position);

        }
    };

    protected Dialog onCreateDialog(final int id) {
        final Dialog customDialog = new Dialog(this);
        LayoutInflater inflater = getLayoutInflater();
        View mView = inflater.inflate(R.layout.discuss_dialog_comment, null);
        edt_reply = (EditText) mView.findViewById(R.id.edt_comments);
        btn_reply = (FloatingActionButton) mView.findViewById(R.id.btn_send);

        customDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        customDialog.setContentView(mView);
        customDialog.show();

        btn_reply.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                switch (id) {
                    case ONE_COMMENT_CODE:
                        if (!edt_reply.getText().toString().equals("")) {
                            HashMap<String, Object> comment = new HashMap<String, Object>();
                            comment.put("content", edt_reply.getText().toString());
                            list_comment.add(comment);
                            list_comment_child
                                    .add(new ArrayList<HashMap<String, Object>>());
                            commentAdapter.clearList();
                            commentAdapter.updateList(list_comment,
                                    list_comment_child);
                            commentAdapter.notifyDataSetChanged();

                            customDialog.dismiss();
                            edt_reply.setText("");
                        }
                        break;
                    default:
                        if (!edt_reply.getText().toString().equals("")) {
                            HashMap<String, Object> comment = new HashMap<String, Object>();
                            comment.put("content", edt_reply.getText().toString());
                            // list_comment.add(comment);
                            list_comment_child.get(id).add(comment);

                            commentAdapter.clearList();
                            commentAdapter.updateList(list_comment,
                                    list_comment_child);
                            commentAdapter.notifyDataSetChanged();

                            customDialog.dismiss();
                            edt_reply.setText("");
                        }
                        break;
                }
            }
        });
        return customDialog;

    }

    private void loadBackdrop() {
        final ImageView imageView = (ImageView) findViewById(R.id.backdrop);
        Glide.with(this).load(CardData.getHuodongImage()).centerCrop().into(imageView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.personal, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.table:
                startActivity(new Intent(PersonalCenterActivity.this, TableActivity.class));
            case R.id.p_message:
                startActivity(new Intent(PersonalCenterActivity.this, PersonalMessageActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.btn_main_send:
                showDialog(ONE_COMMENT_CODE);
                break;

            default:
                break;
        }
    }
}

