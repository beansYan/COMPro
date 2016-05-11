package com.example.ziyu16901.com.Activity;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ziyu16901.com.Adapter.SheTuanListAdapter;
import com.example.ziyu16901.com.Bean.SheTuan;
import com.example.ziyu16901.com.R;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;

public class Fenlei_Detail extends AppCompatActivity implements OnItemClickListener {

    private  static final String TAG = "Fenlei_Detail";
    private static final int STATE_REFRESH = 0;// 下拉刷新
    @SuppressWarnings("unused")
    private static final int STATE_MORE = 1;// 加载更多
    private String leibie;
    private TextView tvtitle;
    private ListView lvshetuanAllList;
    private SheTuanListAdapter shetuanListAdapter;

//    //新页面接收数据
//    Bundle bundle = this.getIntent().getExtras();
//    //接收name值
//    String leibie = bundle.getString("leibie");
    private List<SheTuan> shetuanList = new ArrayList<SheTuan>();
    private SwipeRefreshLayout swipeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fenlei_detail);

        leibie = getIntent().getStringExtra("leibie");
        initView();
        getSheTuanDate();

    }

    public void initView() {
        //设置标题
        tvtitle = (TextView) findViewById(R.id.tv_title);
        tvtitle.setText(getIntent().getStringExtra("leibie"));
        lvshetuanAllList = (ListView) findViewById(R.id.lv_shetuan_all);
        shetuanListAdapter = new SheTuanListAdapter(this, (ArrayList<SheTuan>) shetuanList, leibie);
        lvshetuanAllList.setAdapter(shetuanListAdapter);
        lvshetuanAllList.setOnItemClickListener(this);
    }


//    private void queryData(final int page, final int actionType){
//        Log.i("bmob", "pageN:"+page+" limit:"+limit+" actionType:"+actionType);
//
//        BmobQuery<SheTuan> query = new BmobQuery<SheTuan>();
//        SheTuan sheTuan = new SheTuan();
//        sheTuan.setLeibie("leibie");
//        query.addWhereEqualTo("leibie", sheTuan.getLeibie());    // 查询当前类型的所有店铺
//        query.order("-createdAt");
//        query.setLimit(limit);			// 设置每页多少条数据
//        query.setSkip(page*limit);		// 从第几条数据开始，
//        query.findObjects(this, new FindListener<SheTuan>() {
//
//            @Override
//            public void onSuccess(List<SheTuan> arg0) {
//
//                if(arg0.size()>0){
//
//                    // 将本次查询的数据添加到bankCards中
//                    for (SheTuan sheTuan : arg0) {
//                        shopList.add(shop);
//                    }
//                    // 通知Adapter数据更新
//                    shopListAdapter.refresh((ArrayList<Shop>) shopList);
//                    shopListAdapter.notifyDataSetChanged();
//                    // 这里在每次加载完数据后，将当前页码+1，这样在上拉刷新的onPullUpToRefresh方法中就不需要操作curPage了
//                    curPage++;
//                    toast("第"+(page+1)+"页数据加载完成");
//                }else {
//                    if(page == 0)
//                    {
//                        tvEmptyBg.setVisibility(View.VISIBLE);
//                    }
//                    toast("没有更多数据了");
//                }
//            }

//            @Override
//            public void onError(int arg0, String arg1) {
//                toast("查询失败:"+arg1);
//            }
//        });
//    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        //toast("点击了： " + position);
        //将当前点击的Shop对象传递给下一个Activity
        Intent toSheTuanItem = new Intent(this, SheTuan_Detail.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("shetuan", shetuanList.get(position) );
        bundle.putString("shetuanName",shetuanList.get(position).getName());
        bundle.putString("shetuanID", shetuanList.get(position).getObjectId()); //商铺的ID需要单独传递,否则获取到的是null
        Log.i(TAG, ">>发出>>" + "shetuanID: "+shetuanList.get(position).getObjectId()+" shetuanName: "+shetuanList.get(position).getName());
        toSheTuanItem.putExtras(bundle);
        startActivity(toSheTuanItem);
    }

    /**
     * 加载当前分类的所有社团到ListView中
     */

    @SuppressWarnings("unused")
    private void getSheTuanDate() {
        BmobQuery<SheTuan> query = new BmobQuery<SheTuan>();
//根据社团类别显示数据
        query.addWhereEqualTo("leibie", leibie);
//返回50条数据，如果不加上这条语句，默认返回10条数据
        query.setLimit(50);
//执行查询方法
        query.findObjects(this, new FindListener<SheTuan>() {
            @Override
            public void onSuccess(List<SheTuan> object) {
                toast("查询成功：共" + object.size() + "条数据。");
                if (object.size() == 0)
                    toast("亲, 你来得太早了点哦");
                shetuanList = object;
                // 通知Adapter数据更新
                shetuanListAdapter.refresh((ArrayList<SheTuan>) shetuanList);
                shetuanListAdapter.notifyDataSetChanged();
            }

            @Override
            public void onError(int arg0, String msg) {
                toast("查询失败:" + msg);
            }

        });
    }

    private String display(String leibie, String id, String name) {
        String sendMessage = "类别： " + leibie;
        sendMessage = sendMessage + "\n社团ID： " + id;
        sendMessage = sendMessage + "\n社团名称： " + name + "\n";
        return sendMessage;
    }

    private void toast(String toast) {
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
    }
//    public void onRefresh() {
//        new Handler().postDelayed(new Runnable() {
//            public void run() {
//                swipeLayout.setRefreshing(false);
//                queryData(curPage, STATE_REFRESH);
//            }
//        }, 1000);
//    };
}
