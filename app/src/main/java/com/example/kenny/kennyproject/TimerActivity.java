package com.example.kenny.kennyproject;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TimerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        ButterKnife.bind(this);
        button.setOnClickListener(start);
    }

    private int time;

    @BindView(R.id.timer_et)
    EditText editText;

    @BindView(R.id.timer_bt)
    Button button;

    Handler mHandler=new Handler();

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            time--;
                    if(time>=0)
                    {
                        editText.setText(String.valueOf(time));
                        mHandler.postDelayed(this,1000);
                    }
        }
    };


    final View.OnClickListener start=new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            time=Integer.valueOf(editText.getText().toString());
            button.setText("Stop");
            button.setOnClickListener(stop);
            mHandler.postDelayed(runnable,1000);
            editText.setEnabled(false);
        }
    };
    final View.OnClickListener stop=new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            button.setText("reset");
            button.setOnClickListener(reset);
            mHandler.removeCallbacks(runnable);
        }
    };
    final View.OnClickListener reset=new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            button.setText("start");
            button.setOnClickListener(start);
            editText.setText("20");
            editText.setEnabled(true);
        }
    };
}
