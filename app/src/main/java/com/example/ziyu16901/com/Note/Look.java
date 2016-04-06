package com.example.ziyu16901.com.Note;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;

import com.example.ziyu16901.com.R;
import com.example.ziyu16901.com.SqlDB.SqliteDBConnect;

public class Look extends Activity {
    private EditText etName,etMain,etTime;
    private ActivityManager am;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.look);

        am=ActivityManager.getInstance();
        am.addActivity(this);

        Intent intent=getIntent();
        String noteId=intent.getStringExtra("noteId");

        etName=(EditText) findViewById(R.id.noteName2);
        etMain=(EditText) findViewById(R.id.noteMain2);
        etTime=(EditText) findViewById(R.id.noteTime2);
        SqliteDBConnect sd = new SqliteDBConnect(Look.this);
        SQLiteDatabase sdb = sd.getReadableDatabase();
        Cursor c = sdb.query("note", new String[] {"noteId", "noteName", "noteContent","noteTime" },
                "noteId=?", new String[]{noteId}, null, null,null);

        while(c.moveToNext()){
            etName.setText(c.getString(c.getColumnIndex("noteName")));
            etMain.setText(c.getString(c.getColumnIndex("noteContent")));
            etTime.setText(c.getString(c.getColumnIndex("noteTime")));
        }

    }

}
