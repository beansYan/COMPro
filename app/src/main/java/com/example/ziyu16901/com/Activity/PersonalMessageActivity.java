package com.example.ziyu16901.com.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ziyu16901.com.Bean.Personal;
import com.example.ziyu16901.com.R;
import com.example.ziyu16901.com.SqlDB.SqliteDB;
import com.example.ziyu16901.com.StartActivity;


import java.util.ArrayList;
import java.util.List;

public class PersonalMessageActivity extends AppCompatActivity {


    private Button look;
    private Button add;
    private EditText username;
    private EditText sex1;
    private EditText age1;
    private EditText schoolid1;
    private EditText college1;
    private EditText email1;
    private EditText phone1;
    private TextView state;
    private List<Personal> PersonalList;
    private List<Personal> dataList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_message);


        findViewById(R.id.table).setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                startActivity(new Intent(PersonalMessageActivity.this, TableActivity.class));
            }
        });


        findViewById(R.id.message).setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                startActivity(new Intent(PersonalMessageActivity.this, MessageActivity.class));
            }
        });



        look = (Button) findViewById(R.id.look);
        add = (Button) findViewById(R.id.add);
        username = (EditText) findViewById(R.id.username);
        sex1 = (EditText) findViewById(R.id.sex);
        age1 = (EditText) findViewById(R.id.age);
        schoolid1 = (EditText) findViewById(R.id.schoolid);
        college1 = (EditText) findViewById(R.id.college);
        email1 = (EditText) findViewById(R.id.email);
        state = (TextView) findViewById(R.id.state);
        phone1 = (EditText) findViewById(R.id.phone);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = username.getText().toString().trim();
                String sex = sex1.getText().toString().trim();
                String age = age1.getText().toString().trim();
                String schoolid = schoolid1.getText().toString().trim();
                String college = college1.getText().toString().trim();
                String email = email1.getText().toString().trim();
                String phone = phone1.getText().toString().trim();

                //  String pass = pwd.getText().toString().trim();

                Personal personal = new Personal();
                personal.setUsername(name);
                personal.setSex(sex);
                personal.setAge(age);
                personal.setSchoolid(schoolid);
                personal.setCollege(college);
                personal.setEmail(email);
                personal.setPhone(phone);

                //user.setUserpwd(pass);

                int result = SqliteDB.getInstance(getApplicationContext()).savePersonal(personal);
                if (result == 1) {
                    state.setText("修改成功！");
                } else if (result == -1) {
                    state.setText("表为空");
                } else {
                    state.setText("！");
                }

            }
        });

        look.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = username.getText().toString().trim();

                Personal personal = new Personal();
                personal.setUsername(name);
                //userList=SqliteDB.getInstance(getApplicationContext()).loadUser();
                int result = SqliteDB.getInstance(getApplicationContext()).Quer2(personal);
                if (result == 1) {
                    state.setText("显示信息");
                    startActivity(new Intent(PersonalMessageActivity.this, StartActivity.class));
                    //  username.setText(count.getText().toString());
                } else if (result == 0) {
                    state.setText("用户资料未完善");

                } else if (result == -1) {
                    state.setText("！");
                }
            }


        });
    }
}