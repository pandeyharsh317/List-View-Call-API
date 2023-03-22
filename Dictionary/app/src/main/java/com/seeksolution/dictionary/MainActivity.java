package com.seeksolution.dictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView actv_word;
    TextView tv_meaning;
    DbManager dm;
    String query;
    SQLiteDatabase db;
    ArrayList<String> al=new ArrayList<String>();
    Cursor c;
    boolean res;
    ArrayAdapter ad;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actv_word=findViewById(R.id.active_word);
        tv_meaning=findViewById(R.id.tv_meaning);
        dm=new DbManager(MainActivity.this);
        db=dm.getWritableDatabase();
        query="select word from dict";
        c=db.rawQuery(query,null);
        res=c.moveToFirst();
        while (res)
        {
            al.add(c.getString(0));
            res=c.moveToNext();
        }
        ad=new ArrayAdapter(MainActivity.this, android.R.layout.simple_dropdown_item_1line,al);
        actv_word.setAdapter(ad);
        actv_word.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String word=ad.getItem(position).toString();
                query="select meaning from dict where word='"+word+"'";
                c=db.rawQuery(query,null);
                res=c.moveToFirst();
                if (res)
                {
                    tv_meaning.setText(c.getString(0));
                }
            }
        });
    }

    public void addWord (View v)
    {
        Intent i=new Intent(MainActivity.this,Login.class);
        startActivity(i);
        finish();
    }
}