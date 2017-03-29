package com.example.kenny.kennyproject;

import com.example.kenny.kennyproject.audio.BaseAudioOb;

import java.util.ArrayList;

/**
 * Created by Kenny on 3/29/2017.
 */

public class MusicSetup {
    private ArrayList<BaseAudioOb> contentList = new ArrayList<BaseAudioOb>();

    private void initInfo() {
        BaseAudioOb m1 = new BaseAudioOb();
        m1.setURL("http://other.web.rh01.sycdn.kuwo.cn/resource/n3/77/1/1061700123.mp3");
        contentList.add(m1);
    }

    public ArrayList<BaseAudioOb> getContent(){
        return contentList;
    }


    public MusicSetup() {
        initInfo();
    }
}
