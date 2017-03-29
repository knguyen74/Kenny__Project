package com.example.kenny.kennyproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.kenny.kennyproject.dialog.GamesListDialog;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.kenny.kennyproject.R.style.dialog;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

//    @OnClick(R.id.TTT_bt)
//    public void game1Bt(){
//        toActivity(TicTacToeActivity.class);
//    }
//
//    @OnClick(R.id.matching_bt)
//    public void game2Bt(){
//        toActivity(MatchingGameActivity.class);
//    }

    @OnClick(R.id.timer_bt)
    public void timerBt(){
        toActivity(TimerActivity.class);
    }


    @OnClick(R.id.calc_bt)
    public void calc_bt(){
        //toActivity(LeaderboardActivity.class);
    }

    @OnClick(R.id.games_bt)
    public void games(){
        final GamesListDialog gamesListDialog=new GamesListDialog(this, new GamesListDialog.ICustomDialogEventListener() {
            @Override
            public void onClickListener() {
                toActivity(TicTacToeActivity.class);
            }

            @Override
            public void onClick2Listener() {
                toActivity(MatchingGameActivity.class);
            }
        });
    gamesListDialog.show();
    }
}
