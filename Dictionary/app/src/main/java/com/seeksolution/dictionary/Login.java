package com.seeksolution.dictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText et_userid, et_password;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_userid = (EditText) findViewById(R.id.et_userid);
        et_password = (EditText) findViewById(R.id.et_password);
    }
    public void login(View v)
    {
        if (et_userid.getText().toString().isEmpty()){
            et_userid.setError("empty");
            et_userid.requestFocus();
        }
        else
        {
            if (et_password.getText().toString().isEmpty())
            {
               et_password.setError("empty");
               et_password.requestFocus();
            }
            else
            {
                //Code for login
                String userid=et_userid.getText().toString().trim();
                String password = et_password.getText().toString().trim();
                if (userid.equals("admin") && password.equals("admin@123"))
                {
                    //Toast.makeText(this, "Valid User", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Login.this,AddWordActivity.class);
                    startActivity(i);
                    finish();
                }
                else
                {
                    Toast.makeText(this, "Invalid User", Toast.LENGTH_SHORT).show();
                    et_userid.setText("");
                    et_password.setText("");
                }
            }
        }
    }

}