package com.example.ziyu16901.com.Activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ziyu16901.com.R;

public class TableActivity extends AppCompatActivity {
    private int colors[] = {
            Color.rgb(0xee,0xff,0xff),
            Color.rgb(0xf0,0x96,0x09),
            Color.rgb(0x8c,0xbf,0x26),
            Color.rgb(0x00,0xab,0xa9),
            Color.rgb(0x99,0x6c,0x33),
            Color.rgb(0x3b,0x92,0xbc),
            Color.rgb(0xd5,0x4d,0x34),
            Color.rgb(0xcc,0xcc,0xcc)
    };


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        //分别表示周一到周日
        LinearLayout ll1 = (LinearLayout)findViewById(R.id.ll1);
        LinearLayout ll2 = (LinearLayout)findViewById(R.id.ll2);
        LinearLayout ll3 = (LinearLayout)findViewById(R.id.ll3);
        LinearLayout ll4 = (LinearLayout)findViewById(R.id.ll4);
        LinearLayout ll5 = (LinearLayout)findViewById(R.id.ll5);
        LinearLayout ll6 = (LinearLayout)findViewById(R.id.ll6);
        LinearLayout ll7 = (LinearLayout)findViewById(R.id.ll7);
        //每天的课程设置
        setClass(ll1, "", "", "", "", 2, 0);
        setClass(ll1, "数据库原理与分析", "w2503", "王文乐", "9:40-11:25", 2, 1);
        setNoClass(ll1, 3, 0);
        setClass(ll1, "概率论与数理统计", "w4304", "王文乐", "14:40-17:25", 3, 2);
        setNoClass(ll1, 1, 0);
        setClass(ll1, "高等数学", "w2404", "王文乐", "19:00-20:30", 2, 4);
        setNoClass(ll1, 1, 0);

        setClass(ll2, "大学英语", "w3302", "王文乐", "8:00-9:35", 2, 3);
        setClass(ll2, "计算机组成原理", "w7305", "王文乐", "9:40-12:15", 3, 5);
        setNoClass(ll2, 3, 0);
        setClass(ll2, "人机交互设计", "w4204", "王文乐", "15:45-17:25", 2, 6);
        setNoClass(ll2, 1, 0);
        setClass(ll2, "中国近现代史纲要", "w2302", "王文乐", "19:00-21:25", 3, 1);

        setNoClass(ll3, 2, 0);
        setClass(ll3, "中国近现代史纲要", "w2402", "王文乐", "9:40-12:15", 3, 1);
        setNoClass(ll3, 1, 0);
        setClass(ll3, "体育（网球）", "c场", "王文乐", "14:00-15:40", 2, 2);
        setNoClass(ll3, 3, 0);
        setClass(ll3, "当代政治与经济", "w5306", "王文乐", "19:00-21:25", 3, 3);

        setClass(ll4, "计算机组织体系与结构", "w5204", "王文乐", "8:00-9:35", 2, 5);
        setClass(ll4, "数据结构与算法", "w2304", "王文乐", "9:40-12:15", 3, 4);
        setNoClass(ll4, 1, 0);
        setClass(ll4, "面向对象程序设计", "x3103", "王文乐", "14:00-16:30", 3, 5);
        setNoClass(ll4, 2, 0);
        setNoClass(ll4, 3, 0);

        setClass(ll5, "c#程序设计", "x3102", "王文乐", "8:00-9:35", 2, 6);
        setClass(ll5, "大学英语", "w4302", "王文乐", "9:40-11:25", 2, 3);
        setNoClass(ll5, 2, 0);
        setClass(ll5, "交互设计", "w2304", "王文乐", "14:00-16:30", 3, 1);
        setNoClass(ll5, 2, 0);
        setClass(ll5, "国粹中医学", "w5303", "王文乐", "19:00-21:2", 3, 2);

        setNoClass(ll6, 14, 0);

        setNoClass(ll7, 14, 0);

    }

    //设置课程方法
    void setClass(LinearLayout ll, String title, String place,
                  String last, String time, int classes, int color)
    {
        View view = LayoutInflater.from(this).inflate(R.layout.item_table, null);
        view.setMinimumHeight(dip2px(this,classes * 48));
        view.setBackgroundColor(colors[color]);
        ((TextView)view.findViewById(R.id.title)).setText(title);
        ((TextView)view.findViewById(R.id.place)).setText(place);
        ((TextView)view.findViewById(R.id.last)).setText(last);
        ((TextView)view.findViewById(R.id.time)).setText(time);
        //为课程View设置点击的监听器
        view.setOnClickListener(new OnClickClassListener());
        TextView blank1 = new TextView(this);
        TextView blank2 = new TextView(this);
        blank1.setHeight(dip2px(this,classes));
        blank2.setHeight(dip2px(this,classes));
        ll.addView(blank1);
        ll.addView(view);
        ll.addView(blank2);
    }
    /**
     * 设置无课（空百）
     * @param ll
     * @param classes 无课的节数（长度）
     * @param color
     */
    void setNoClass(LinearLayout ll,int classes, int color)
    {
        TextView blank = new TextView(this);
        if(color == 0)
            blank.setMinHeight(dip2px(this,classes * 50));
        blank.setBackgroundColor(colors[color]);
        ll.addView(blank);
    }
    //点击课程的监听器
    class OnClickClassListener implements OnClickListener{

        public void onClick(View v) {
            // TODO Auto-generated method stub
            String title;
            title = (String) ((TextView)v.findViewById(R.id.title)).getText();
            Toast.makeText(getApplicationContext(), "你点击的是:" + title,
                    Toast.LENGTH_SHORT).show();
        }
    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);} /** * 根据手机的分辨率从 px(像素) 的单位 转成为 dp */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);}
}