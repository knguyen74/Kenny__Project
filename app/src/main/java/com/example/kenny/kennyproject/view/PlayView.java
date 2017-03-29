package com.example.kenny.kennyproject.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.kenny.kennyproject.MatchingGameActivity;
import com.example.kenny.kennyproject.R;
import com.example.kenny.kennyproject.audio.BaseAudioOb;
import com.example.kenny.kennyproject.audio.MusicController;
import com.example.kenny.kennyproject.util.UtilLog;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
//import edu.gsu.httpscs.yanaudioplayer.AudioOb;
//import edu.gsu.httpscs.yanaudioplayer.MainActivity;
//import edu.gsu.httpscs.yanaudioplayer.R;
//import edu.gsu.httpscs.yanaudioplayer.audio.BaseAudioOb;
//import edu.gsu.httpscs.yanaudioplayer.audio.MusicController;
//import edu.gsu.httpscs.yanaudioplayer.util.UtilLog;
//import edu.gsu.httpscs.yanaudioplayer.util.UtilTime;

/**
 * Created by Yan on 3/16/17.
 */

public class PlayView extends LinearLayout implements MusicController.IPlayerStatus {

    private final View view;
    private final MusicController controller;
    private MatchingGameActivity mContext;


    @BindView(R.id.main_play_play) ImageView playBt;
    @BindView (R.id.pb_play_loading) ProgressBar progressBar;




    @OnClick(R.id.main_play_play)
    public void play(){
        if(!controller.isPlaying){
            UtilLog.logD("Music","Play");
            mContext.toastShort("Play");
            controller.play();
        }else {
            controller.pause();
        }
    }


    public PlayView(Context context) {
        super(context);
        this.mContext = (MatchingGameActivity) context;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.activity_matching_game, this);
        ButterKnife.bind(this,view);
        controller = MusicController.getInstance(mContext);
        controller.setPlayList(mContext.getContent());
        controller.addListener("PlayView", this);




    }

    public void update(){

    }

    @Override
    public void onLoading() {
       prepareStatus();

    }

    private void prepareStatus() {

        playBt.setBackgroundResource(R.drawable.playscreen_play_pause);
        playBt.setVisibility(INVISIBLE);
        progressBar.setVisibility(VISIBLE);

    }

    private void pauseStatus() {

        playBt.setBackgroundResource(R.drawable.playscreen_play_pause);
        playBt.setVisibility(VISIBLE);
        progressBar.setVisibility(INVISIBLE);

    }

    private void startStatus() {

        playBt.setBackgroundResource(R.drawable.playscreen_play_play);

    }

    @Override
    public void onProgress(int i) {
    }

    @Override
    public void onError(String error) {

        mContext.toastShort(error);
    }

    @Override
    public void onPrepared() {

    }

    @Override
    public void onSeekComplete() {

    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onUpdateCache(int i) {

    }

    @Override
    public void onPause() {

        startStatus();

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onStart(int i) {

        mContext.toastShort("started");
        pauseStatus();

    }

    @Override
    public void onInitComplete() {

    }
}
