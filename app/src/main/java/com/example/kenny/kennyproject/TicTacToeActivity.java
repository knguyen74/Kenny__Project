package com.example.kenny.kennyproject;

import android.animation.ObjectAnimator;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.kenny.kennyproject.adapter.BlankListViewAdapter;
import com.example.kenny.kennyproject.adapter.ViewPagerAdapter;
import com.example.kenny.kennyproject.fragment.ttt_rules;
import com.example.kenny.kennyproject.fragment.ttt_title;

import org.w3c.dom.Text;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TicTacToeActivity extends BaseActivity {

    private int counter=0;
    private boolean gameEnd=false;
    private String endString="";
    private int p1=0;
    private int p2=0;
    private int tie=0;
    private ViewPager viewPager;
    private ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();
    private ArrayList<String> listResult=new ArrayList<String>();
    private TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);
        ButterKnife.bind(this);


        BlankListViewAdapter listViewAdapter=new BlankListViewAdapter(this,listResult);

        View view= getLayoutInflater().inflate(R.layout.ttt_header,null);
        LinearLayout listViewHeader=(LinearLayout) view.findViewById(R.id.ttt_header);



        viewPager=(ViewPager) view.findViewById(R.id.pager_header);
        fragmentList.add(new ttt_title());
        fragmentList.add(new ttt_rules());
        ViewPagerAdapter viewPagerAdapter= new ViewPagerAdapter(this.getSupportFragmentManager());
        viewPagerAdapter.setContent(fragmentList);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout = (TabLayout) view.findViewById(R.id.tab_Layout);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("Title");
        tabLayout.getTabAt(1).setText("Objective");

        listView.addHeaderView(listViewHeader);
        listView.setAdapter(listViewAdapter);

    }

    @BindView(R.id.tl_bt)
    Button tl_bt;

    @BindView(R.id.tm_bt)
    Button tm_bt;

    @BindView(R.id.tr_bt)
    Button tr_bt;

    @BindView(R.id.ml_bt)
    Button ml_bt;

    @BindView(R.id.mm_bt)
    Button mm_bt;

    @BindView(R.id.mr_bt)
    Button mr_bt;

    @BindView(R.id.bl_bt)
    Button bl_bt;

    @BindView(R.id.bm_bt)
    Button bm_bt;

    @BindView(R.id.br_bt)
    Button br_bt;

    @BindView(R.id.restart_bt)
    Button restart;

    @BindView(R.id.top_tv)
    TextView top_tv;

    @BindView(R.id.p1Score_tv)
    TextView p1Score_tv;

    @BindView(R.id.p2Score_tv)
    TextView p2Score_tv;

    @BindView(R.id.tie_tv)
    TextView tie_tv;

    @BindView(R.id.container)
    ListView listView;


    @OnClick(R.id.tl_bt)
    public void topLeftBT(){
        if(counter%2==0){
            tl_bt.setText("X");
        } else{
            tl_bt.setText("O");
        }
        tl_bt.setEnabled(false);
        checkWin();
        counter++;
        turnChange();
        gameEnd();

    }
    @OnClick(R.id.tm_bt)
    public void topMiddleBT(){
        if(counter%2==0){
            tm_bt.setText("X");
        } else{
            tm_bt.setText("O");
        }
        tm_bt.setEnabled(false);
        checkWin();
        counter++;
        turnChange();
        gameEnd();
    }
    @OnClick(R.id.tr_bt)
    public void topRightBT(){
        if(counter%2==0){
            tr_bt.setText("X");
        } else{
            tr_bt.setText("O");
        }
        tr_bt.setEnabled(false);
        checkWin();
        counter++;
        turnChange();
        gameEnd();
    }


    @OnClick(R.id.ml_bt)
    public void middleLeftBT(){
        if(counter%2==0){
            ml_bt.setText("X");
        } else{
            ml_bt.setText("O");
        }
        ml_bt.setEnabled(false);
        checkWin();
        counter++;
        turnChange();
        gameEnd();
    }
    @OnClick(R.id.mm_bt)
    public void middleMiddleBT(){
        if(counter%2==0){
            mm_bt.setText("X");
        } else{
            mm_bt.setText("O");
        }
        mm_bt.setEnabled(false);
        checkWin();
        counter++;
        turnChange();
        gameEnd();
    }
    @OnClick(R.id.mr_bt)
    public void middleRightBT(){
        if(counter%2==0){
            mr_bt.setText("X");
        } else{
            mr_bt.setText("O");
        }
        mr_bt.setEnabled(false);
        checkWin();
        counter++;
        turnChange();
        gameEnd();
    }

    @OnClick(R.id.bl_bt)
    public void bottomLeftBT(){
        if(counter%2==0){
            bl_bt.setText("X");
        } else{
            bl_bt.setText("O");
        }
        bl_bt.setEnabled(false);
        checkWin();
        counter++;
        turnChange();
        gameEnd();
    }
    @OnClick(R.id.bm_bt)
    public void bottomMiddleBT(){
        if(counter%2==0){
            bm_bt.setText("X");
        } else{
            bm_bt.setText("O");
        }
        bm_bt.setEnabled(false);
        checkWin();
        counter++;
        turnChange();
        gameEnd();
    }
    @OnClick(R.id.br_bt)
    public void bottomRightBT(){
        if(counter%2==0){
            br_bt.setText("X");
        } else{
            br_bt.setText("O");
        }
        br_bt.setEnabled(false);
        checkWin();
        counter++;
        turnChange();
        gameEnd();
    }

    @OnClick(R.id.restart_bt)
    public void restart(){
        counter=0;
        gameEnd=false;
        restart.setText("Restart");
        top_tv.setText("Player 1's turn");


        tl_bt.setText("");
        tl_bt.setEnabled(true);
        tm_bt.setText("");
        tm_bt.setEnabled(true);
        tr_bt.setText("");
        tr_bt.setEnabled(true);

        ml_bt.setText("");
        ml_bt.setEnabled(true);
        mm_bt.setText("");
        mm_bt.setEnabled(true);
        mr_bt.setText("");
        mr_bt.setEnabled(true);

        bl_bt.setText("");
        bl_bt.setEnabled(true);
        bm_bt.setText("");
        bm_bt.setEnabled(true);
        br_bt.setText("");
        br_bt.setEnabled(true);
    }
    public void checkWin(){
        //top row
        if((tl_bt.getText().toString().equals("X")||tl_bt.getText().toString().equals("O"))&&tl_bt.getText().toString().equals(tm_bt.getText().toString())&&tl_bt.getText().toString().equals(tr_bt.getText().toString())){
            gameEnd=true;
            animate(tl_bt);
            animate(tm_bt);
            animate(tr_bt);
        }
        //middle row
        if((ml_bt.getText().toString().equals("X")||ml_bt.getText().toString().equals("O"))&&ml_bt.getText().toString().equals(mm_bt.getText().toString())&&ml_bt.getText().toString().equals(mr_bt.getText().toString())){
            gameEnd=true;
            animate(ml_bt);
            animate(mm_bt);
            animate(mr_bt);
        }
        //bottom row
        if((bl_bt.getText().toString().equals("X")||bl_bt.getText().toString().equals("O"))&&bl_bt.getText().toString().equals(bm_bt.getText().toString())&&bl_bt.getText().toString().equals(br_bt.getText().toString())){
            gameEnd=true;
            animate(bl_bt);
            animate(bm_bt);
            animate(br_bt);
        }
        //left column
        if((tl_bt.getText().toString().equals("X")||tl_bt.getText().toString().equals("O"))&&tl_bt.getText().toString().equals(ml_bt.getText().toString())&&tl_bt.getText().toString().equals(bl_bt.getText().toString())){
            gameEnd=true;
            animate(tl_bt);
            animate(ml_bt);
            animate(bl_bt);
        }
        //middle column
        if((tm_bt.getText().toString().equals("X")||tm_bt.getText().toString().equals("O"))&&tm_bt.getText().toString().equals(mm_bt.getText().toString())&&tm_bt.getText().toString().equals(bm_bt.getText().toString())){
            gameEnd=true;
            animate(tm_bt);
            animate(mm_bt);
            animate(bm_bt);
        }
        //right column
        if((tr_bt.getText().toString().equals("X")||tr_bt.getText().toString().equals("O"))&&tr_bt.getText().toString().equals(mr_bt.getText().toString())&&br_bt.getText().toString().equals(tr_bt.getText().toString())){
            gameEnd=true;
            animate(tr_bt);
            animate(mr_bt);
            animate(br_bt);
        }
        //top down diagonal
        if((tl_bt.getText().toString().equals("X")||tl_bt.getText().toString().equals("O"))&&tl_bt.getText().toString().equals(mm_bt.getText().toString())&&tl_bt.getText().toString().equals(br_bt.getText().toString())){
            gameEnd=true;
            animate(tl_bt);
            animate(mm_bt);
            animate(br_bt);
        }
        //bottom up diagonal
        if((bl_bt.getText().toString().equals("X")||bl_bt.getText().toString().equals("O"))&&bl_bt.getText().toString().equals(mm_bt.getText().toString())&&bl_bt.getText().toString().equals(tr_bt.getText().toString())){
            gameEnd=true;
            animate(bl_bt);
            animate(mm_bt);
            animate(tr_bt);
        }
    }
    public void turnChange(){
        if(counter%2==0)
        {
            top_tv.setText("Player 1's turn");
        }
        else{
            top_tv.setText("Player 2's turn");
        }
    }
    public void gameEnd(){
        if(gameEnd==true){
            if((counter-1)%2==0)
            {
                endString="Player 1 wins!";
                p1++;
            }
            else{
                endString="Player 2 wins!";
                p2++;
            }
            top_tv.setText(endString);
            restart.setText("New Game");
            p1Score_tv.setText("Player 1: "+p1);
            p2Score_tv.setText("Player 2: "+p2);


            tl_bt.setEnabled(false);
            tm_bt.setEnabled(false);
            tr_bt.setEnabled(false);

            ml_bt.setEnabled(false);
            mm_bt.setEnabled(false);
            mr_bt.setEnabled(false);

            bl_bt.setEnabled(false);
            bm_bt.setEnabled(false);
            br_bt.setEnabled(false);
        }
        else if(counter==9){
            endString="Tie!";
            top_tv.setText(endString);
            restart.setText("New Game");
            tie++;
            tie_tv.setText("Tie: "+tie);
        }
    }
    public void animate(Button bt){
        ObjectAnimator animator = ObjectAnimator.ofFloat(bt,"rotation",0,360,0);//rotationX   rotationY
        animator.setDuration(2000);
        animator.start();
    }
}
