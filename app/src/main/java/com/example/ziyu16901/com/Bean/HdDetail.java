package com.example.ziyu16901.com.Bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HdDetail
{
    // 定义一个内部类，作为系统的业务对象
    public static class HDdetail
    {
        public Integer id;
        public String title;
        public String desc;
        public HDdetail(Integer id, String title, String desc)
        {
            this.id = id;
            this.title = title;
            this.desc = desc;
        }
        @Override
        public String toString()
        {
            return title;
        }
    }
    // 使用List集合记录系统所包含的Book对象
    public static List<HDdetail> ITEMS = new ArrayList<HDdetail>();
    // 使用Map集合记录系统所包含的Book对象
    public static Map<Integer, HDdetail> ITEM_MAP
            = new HashMap<Integer, HDdetail>();
    static
    {
        // 使用静态初始化代码，将Book对象添加到List集合、Map集合中
        addItem(new HDdetail(1, "青春开讲啦1"
                , "活动简介"));
        addItem(new HDdetail(2, "青春开讲啦2"
                , "活动简介 "
                + "活动简介"));
        addItem(new HDdetail(3, "青春开奖啦3"
                , "活动简介"));
    }
    private static void addItem(HDdetail detail)
    {
        ITEMS.add(detail);
        ITEM_MAP.put(detail.id, detail);
    }
}
