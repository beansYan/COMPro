package com.example.ziyu16901.com.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.ziyu16901.com.R;

public class MyActivity extends AppCompatActivity {
    int flag = 0;
    //0表示第一张图  1表示第二张图
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);



        ImageButton btn = (ImageButton) findViewById(R.id.dz);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (flag == 0) {

                    ((ImageButton) v).setImageDrawable(getResources().getDrawable(R.drawable.finger_10));
                    flag = 1;
                } else {
                    ((ImageButton) v).setImageDrawable(getResources().getDrawable(R.drawable.finger_11));
                    flag = 0;
                }
            }
        });
    /*    ImageButton btn = (ImageButton) findViewById(R.id.dz);
        btn.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    //重新设置按下时的背景图片
                    ((ImageButton) v).setImageDrawable(getResources().getDrawable(R.drawable.finger_10));
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    //再修改为抬起时的正常图片
                    ((ImageButton) v).setImageDrawable(getResources().getDrawable(R.drawable.finger_11));
                }
                return false;
            }
        });

*/

}
}



