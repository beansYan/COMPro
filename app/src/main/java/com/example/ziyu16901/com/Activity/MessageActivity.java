package com.example.ziyu16901.com.Activity;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.os.Handler;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ziyu16901.com.Bean.Message;
import com.example.ziyu16901.com.R;

public class MessageActivity extends AppCompatActivity implements OnClickListener{
    EditText et_tony_message;
    Button but_tony_send;

    EditText et_hill_message;
    Button but_hill_send;

    ListView lv_message;
    List<Message> list;
    MessageAdapter adapter;
    Handler handler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        init();
    }

    private void init() {
        et_tony_message=(EditText) findViewById(R.id.et_tony_message);
        but_tony_send=(Button) findViewById(R.id.but_tony_send);
        but_tony_send.setOnClickListener(this);

        et_hill_message=(EditText) findViewById(R.id.et_hill_message);
        but_hill_send=(Button) findViewById(R.id.but_hill_send);
        but_hill_send.setOnClickListener(this);

        list=new ArrayList<Message>();
        lv_message=(ListView) findViewById(R.id.lv_message);
        adapter=new MessageAdapter();
        lv_message.setAdapter(adapter);
    }


    @Override
    public void onClick(View v) {
		/*Tony发送消息*/
        if(v==but_tony_send){
			/*验证*/
            if(et_tony_message.getText()==null||et_tony_message.getText().toString().equals("")){
                // Toast.makeText(this, "消息不能为空", 0).show();
                return ;
            }
            Message m=new Message();
            m.setFrom_username("子渝");
            m.setCreate_time(System.currentTimeMillis());
            m.setText(et_tony_message.getText().toString());
            sendMessage(m);
            et_tony_message.setText("");
        }
		/*Hill发送消息*/
        if(v==but_hill_send){
			/*验证*/
            if(et_hill_message.getText()==null||et_hill_message.getText().toString().equals("")){
                //Toast.makeText(this, "消息不能为空",0 ).show();
                return ;
            }
            Message m=new Message();
            m.setFrom_username("厌氧菌");
            m.setCreate_time(System.currentTimeMillis());
            m.setText(et_hill_message.getText().toString());
            sendMessage(m);
            et_hill_message.setText("");
        }
    }
    private void sendMessage(Message m) {
        list.add(m);
        adapter.notifyDataSetChanged();
//		lv_message.f
        lv_message.setSelection(list.size()+1);
    }
    class MessageAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Message message=list.get(position);
            ViewHolder viewHolder=null;
//		if(convertView==null){
            if("子渝".equalsIgnoreCase(message.getFrom_username())){
                convertView=parent.inflate(MessageActivity.this, R.layout.item_leftmessage, null);
            }else{
                convertView=parent.inflate(MessageActivity.this, R.layout.item_rightmessage, null);
            }
            viewHolder=new ViewHolder();
            viewHolder.iv_userhead=(ImageView) convertView.findViewById(R.id.iv_userhead);
            viewHolder.tv_chatcontent=(TextView) convertView.findViewById(R.id.tv_chatcontent);
            viewHolder.tv_sendtime=(TextView) convertView.findViewById(R.id.tv_sendtime);
            viewHolder.tv_username=(TextView) convertView.findViewById(R.id.tv_username);
//			convertView.setTag(viewHolder);
//		}else{
//			viewHolder=(ViewHolder) convertView.getTag();
//		}

            viewHolder.tv_chatcontent.setText(message.getText());
            viewHolder.tv_sendtime.setText(new SimpleDateFormat("HH:mm:ss").format(new Date(message.getCreate_time())));
            viewHolder.tv_username.setText(message.getFrom_username());
            return convertView;
        }
        class ViewHolder{
            public ImageView iv_userhead;
            public TextView tv_username;
            public TextView tv_chatcontent;
            public TextView tv_sendtime;
        }
    }
}
