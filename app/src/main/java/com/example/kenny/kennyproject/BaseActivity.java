package com.example.kenny.kennyproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by Kenny on 3/3/2017.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void toActivity(Class name) {
        Intent intent = new Intent(this,name);
        startActivity(intent);
    }

    public void toastLong(String content) {
        Toast.makeText(this,content,Toast.LENGTH_LONG).show();
    }

    public void toastShort(String content) {
        Toast.makeText(this,content,Toast.LENGTH_SHORT).show();
    }
}