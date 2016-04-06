package com.example.ziyu16901.com.Activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ziyu16901.com.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class OnlineChat extends AppCompatActivity {

    EditText ip;
    EditText editText;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_chat);

        ip = (EditText) findViewById(R.id.ip);
        editText = (EditText) findViewById(R.id.edit);
        text = (TextView) findViewById(R.id.text);

        findViewById(R.id.connect).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                connect();

            }
        });

        findViewById(R.id.send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                send();
            }
        });
    }

//  ------------------------------  ---------------------------------------

    Socket socket = null;
    BufferedWriter writer = null;
    BufferedReader reader = null;

    public void connect() {
        final String str = ip.getText().toString();
        AsyncTask<Void, String, Void> read = new AsyncTask<Void, String, Void>() {

            @Override
            protected Void doInBackground(Void... arg0) {

                try {
                    socket = new Socket(str, 12345);
                    writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    publishProgress("@success");
                } catch (UnknownHostException e1) {
                    Toast.makeText(OnlineChat.this, "无法建立链接", Toast.LENGTH_SHORT).show();
                } catch (IOException e1) {
                    Toast.makeText(OnlineChat.this, "无法建立链接", Toast.LENGTH_SHORT).show();
                }
                try {
                    String line;
                    while ((line = reader.readLine())!= null) {
                        publishProgress(line);
                    }
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onProgressUpdate(String... values) {
                if (values[0].equals("@success")) {

                    Toast.makeText(OnlineChat.this, "链接成功", Toast.LENGTH_SHORT).show();
                }
                text.append("曾玲超说:" + values[0] + "\n");
                super.onProgressUpdate(values);
            }
        };

        read.execute();

    }
    public void send() {
        try {
            text.append("我说:" + editText.getText().toString() + "\n");
            writer.write(editText.getText().toString() + "\n");
            writer.flush();
            editText.setText(" ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
