package com.example.ziyu16901.com.Note;

/**
 * Created by yan on 16/1/5.
 */

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActivityManager {
    private static ActivityManager instance;
    private List<Activity> list;


    public static ActivityManager getInstance() {
        if (instance == null)
            instance = new ActivityManager();
        return instance;
    }

    public void addActivity(Activity av) {
        if(list==null)
            list=new ArrayList<Activity>();
        if (av != null) {
            list.add(av);
        }
    }


    public void exitAllProgress() {
        for (int i = 0; i < list.size(); i++) {
            Activity av = list.get(i);
            av.finish();
        }
    }
    //save
    public void saveNote(SQLiteDatabase sdb,String name,String content,String noteId,String time){
        ContentValues cv=new ContentValues();
        cv.put("noteName", name);
        cv.put("noteContent", content);
        cv.put("noteTime", time);
        sdb.update("note", cv, "noteId=?", new String[]{noteId});
        sdb.close();
    }
    //insert
    public void addNote(SQLiteDatabase sdb,String name,String content,String time){
        ContentValues cv=new ContentValues();
        cv.put("noteName", name);
        cv.put("noteContent", content);
        cv.put("noteTime", time);
        sdb.insert("note", null, cv);
        sdb.close();
    }
    public String returnTime(){
        Date d=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=sdf.format(d);
        return time;
    }
}
