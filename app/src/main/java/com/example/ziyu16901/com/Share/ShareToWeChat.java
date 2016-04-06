package com.example.ziyu16901.com.Share;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.ziyu16901.com.R;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.SendMessageToWX;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.tencent.mm.sdk.openapi.WXMediaMessage;
import com.tencent.mm.sdk.openapi.WXTextObject;


public class ShareToWeChat extends Activity {

    public static final String APP_ID = "wxf9d0f2a5410cff24";
    private IWXAPI api;
    private Button btnshare;
    private CheckBox mSharFriends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_to_we_chat);
        api = WXAPIFactory.createWXAPI(this, APP_ID);
        api.registerApp(APP_ID);
        btnshare = (Button)findViewById(R.id.button_send_text);
        btnshare.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                SendMessageToWX.Req req = new SendMessageToWX.Req();
                req.transaction = "text" + System.currentTimeMillis();
                //发送到好友
                req.scene = SendMessageToWX.Req.WXSceneSession;
                req.message = new WXMediaMessage();
                req.message.description = "江西师范大学女子军乐团";
                req.message.mediaObject = new WXTextObject("校女大学生军乐团创建于2000年3月1日，是我国高校第一支女大学生军乐团，也是江西省第一支女子军乐团。\n" +
                        "    军乐团团员全部是非音乐专业的女大学生，她们来自江西师大文、理科等22个学院。她们个个品学兼优，绝大多数都是三好学生、优秀学生干部、\n" +
                        "    奖学金获得者。在学校领导的关心和支持下，在全省一流的铜管、木管、打击乐演奏家的悉心指导下，全体团员从不懂乐理、不识简谱，\n" +
                        "    从未接触乐器开始，凭着对艺术的执着追求和顽强刻苦的精神，经过严格而科学的训练，现已能圆熟地演奏《中华人民共和国国歌》、\n" +
                        "    《国际歌》、《拉德茨基》等20多首中外名曲.");
                api.sendReq(req);
            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    protected void onDestroy() {

        api.unregisterApp();

        super.onDestroy();
    }
}
