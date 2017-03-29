package com.example.kenny.kennyproject.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.kenny.kennyproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by Kenny on 2/15/2017.
 */

public class InputNameDialog extends Dialog {


    @BindView(R.id.editText)
    EditText editText;

    String name;

    @OnClick(R.id.dialog_ok)
    public void okClick(){
        listener.onClickListener();
        name=editText.getText().toString();
        dismiss();
    }

    @OnClick(R.id.dialog_cancel)
    public void cancelClick(){
        dismiss();
    }

    private ICustomDialogEventListener listener;

    public interface ICustomDialogEventListener{
        public void onClickListener();
    }

    public String getName(){
        return name;
    }


    public InputNameDialog(@NonNull Context context, ICustomDialogEventListener listener) {
        super(context, R.style.dialog);
        this.listener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_name);
        ButterKnife.bind(this);


    }
}