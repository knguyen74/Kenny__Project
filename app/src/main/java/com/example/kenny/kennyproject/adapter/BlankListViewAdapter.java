package com.example.kenny.kennyproject.adapter;
import com.example.kenny.kennyproject.R;
import com.example.kenny.kennyproject.util.UtilDensity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;


import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Kenny on 1/25/2017.
 */

public class BlankListViewAdapter extends BaseAdapter {

    private Context mContext;
    private final LayoutInflater mInflater;
    private final ArrayList<String> listResult;

    public BlankListViewAdapter(Context context, ArrayList<String> listResult) {
        mContext = context;
        this.listResult=listResult;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return listResult.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            convertView= mInflater.inflate(R.layout.list_item,parent,false);

        }else{
        }

        return convertView;
    }
}
