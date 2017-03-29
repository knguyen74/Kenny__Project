package com.example.kenny.kennyproject.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.RadioGroup;

import com.example.kenny.kennyproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by Kenny on 2/15/2017.
 */

public class GamesListDialog extends Dialog {


    private int checkedID;

    @BindView(R.id.rdg)
    RadioGroup radioGroup;

    @OnClick(R.id.dialog_ok)
    public void okClick(){
        if(checkedID==R.id.rb1){
            listener.onClickListener();
        }
        else if(checkedID==R.id.rb2){
            listener.onClick2Listener();
        }
        dismiss();
    }

    @OnClick(R.id.dialog_cancel)
    public void cancelClick(){
        dismiss();
    }

    private ICustomDialogEventListener listener;

    public interface ICustomDialogEventListener{
        public void onClickListener();
        public void onClick2Listener();
    }


    public GamesListDialog(@NonNull Context context, ICustomDialogEventListener listener) {
        super(context, R.style.dialog);
        this.listener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.games_list);
        ButterKnife.bind(this);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                checkedID = checkedId;
            }
        });
    }
}