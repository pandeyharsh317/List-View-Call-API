package com.seeksolution.dictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddWordActivity extends AppCompatActivity {
    EditText et_word , et_meaning;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);

        et_word = findViewById(R.id.et_word);
        et_meaning = findViewById(R.id.et_meaning);
    }
    public void add(View v)
    {
        if (et_word.getText().toString().isEmpty())
        {
            et_word.setError("Empty");
            et_word.requestFocus();
        }
        else
        {
            if (et_meaning.getText().toString().isEmpty())
            {
                et_meaning.setError("Empty");
                et_meaning.requestFocus();
            }
            else
            {
                //Code to insert Word Meaning
                String word=et_word.getText().toString().trim();
                String meaning=et_meaning.getText().toString().trim();
                DbManager dm=new DbManager(AddWordActivity.this);
                SQLiteDatabase db=dm.getWritableDatabase();
                String query="insert into dict values('"+word+"','"+meaning+"')";
                db.execSQL(query);
                Toast.makeText(this, "Word and meaning are added", Toast.LENGTH_SHORT).show();
                et_meaning.setText("");
                et_word.setText("");
            }
        }
    }
}