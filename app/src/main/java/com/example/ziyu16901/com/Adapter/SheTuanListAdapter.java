package com.example.ziyu16901.com.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ziyu16901.com.Bean.SheTuan;
import com.example.ziyu16901.com.Bean.User;
import com.example.ziyu16901.com.R;

import java.util.ArrayList;

/**
 * Created by yan on 16/5/9.
 */
public class SheTuanListAdapter extends BaseAdapter {


    @SuppressWarnings("unused")
    private Context mContext;

    private LayoutInflater mInflater = null;
    private ArrayList<SheTuan> mSheTuanList = null; // 所选分类下的所有社团
    private String mLeibie; // 商店的分类

    public SheTuanListAdapter(Context context, ArrayList<SheTuan> shetuanList,
                              String leibie) {
        mContext = context;
        mSheTuanList = shetuanList;
        mLeibie = leibie;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mSheTuanList.size();
    }

    @Override
    public Object getItem(int position) {
        return mSheTuanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // 刷新列表中的数据
    public void refresh(ArrayList<SheTuan> list) {
        mSheTuanList = list;
        //将数字的类型编号转换为文字
//        exchangeType(mType);
        notifyDataSetChanged();
    }
//
//    /**
//     * 根据当前的type类型, 转换成相应的文字
//     * @date 2014-4-29
//     * @param typeString
//     */
//    private void exchangeType(String typeString) {
//
//        int type = Integer.parseInt(typeString);
//        int fatherType = type / 10; //父类型编号
//        int sonType = type % 10;	//子类型编号
//
//        Iterator<Shop> iterator = mShopList.iterator();
//        while (iterator.hasNext()) {
//            switch (fatherType) {
//                case 1:
//                    iterator.next().setType(
//                            TypeDef.typeDadList[fatherType-1] + "/"
//                                    + TypeDef.typeSonList1[sonType-1]);
//                    break;
//                case 2:
//                    iterator.next().setType(
//                            TypeDef.typeDadList[fatherType-1] + "/"
//                                    + TypeDef.typeSonList2[sonType-1]);
//                    break;
//                case 3:
//                    iterator.next().setType(
//                            TypeDef.typeDadList[fatherType-1] + "/"
//                                    + TypeDef.typeSonList3[sonType-1]);
//                    break;
//                case 4:
//                    iterator.next().setType(
//                            TypeDef.typeDadList[fatherType-1] + "/"
//                                    + TypeDef.typeSonList4[sonType-1]);
//                    break;
//                default:
//                    break;
//            }
//
//        }
//    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SheTuanHolder sheTuanHodler;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.fenlei_all_list_item, null);
            sheTuanHodler = new SheTuanHolder();
            sheTuanHodler.tvSheTuanName = (TextView) convertView
                    .findViewById(R.id.tv_shetuan_name);
            sheTuanHodler.tvShopType = (TextView) convertView
                    .findViewById(R.id.tv_shetuan_leibie);
            sheTuanHodler.tvShopLoc = (TextView) convertView
                    .findViewById(R.id.tv_shetuan_guakao);
            convertView.setTag(sheTuanHodler);
        } else {
            sheTuanHodler = (SheTuanHolder) convertView.getTag();
        }
        sheTuanHodler.tvSheTuanName.setText(mSheTuanList.get(position).getName());
        // 商店的类型需要单独处理
        sheTuanHodler.tvShopType.setText(mSheTuanList.get(position).getLeibie());
        sheTuanHodler.tvShopLoc.setText(mSheTuanList.get(position).getGuakao());
        return convertView;
    }

    public class SheTuanHolder {

        public TextView tvSheTuanName;
        public TextView tvShopType;
        public TextView tvShopLoc;

    }

}