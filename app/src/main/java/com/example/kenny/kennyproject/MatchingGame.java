package com.example.kenny.kennyproject;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.kenny.kennyproject.adapter.BlankListViewAdapter;
import com.example.kenny.kennyproject.adapter.ViewPagerAdapter;
import com.example.kenny.kennyproject.audio.BaseAudioOb;
import com.example.kenny.kennyproject.audio.MusicController;
import com.example.kenny.kennyproject.dialog.InputNameDialog;
import com.example.kenny.kennyproject.fragment.mg_credits;
import com.example.kenny.kennyproject.fragment.mg_rules;
import com.example.kenny.kennyproject.fragment.mg_title;
import com.example.kenny.kennyproject.util.UtilLog;

import java.util.ArrayList;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MatchingGame extends BaseActivity implements View.OnTouchListener{


    @BindView(R.id.bt1)
    ImageButton bt1;
    @BindView(R.id.bt2)
    ImageButton bt2;
    @BindView(R.id.bt3)
    ImageButton bt3;
    @BindView(R.id.bt4)
    ImageButton bt4;
    @BindView(R.id.bt5)
    ImageButton bt5;
    @BindView(R.id.bt6)
    ImageButton bt6;
    @BindView(R.id.bt7)
    ImageButton bt7;
    @BindView(R.id.bt8)
    ImageButton bt8;
    @BindView(R.id.bt9)
    ImageButton bt9;
    @BindView(R.id.bt10)
    ImageButton bt10;
    @BindView(R.id.bt11)
    ImageButton bt11;
    @BindView(R.id.bt12)
    ImageButton bt12;
    @BindView(R.id.bt13)
    ImageButton bt13;
    @BindView(R.id.bt14)
    ImageButton bt14;
    @BindView(R.id.bt15)
    ImageButton bt15;
    @BindView(R.id.bt16)
    ImageButton bt16;
    @BindView(R.id.container)
    ListView listView;

    @BindView(R.id.turn_tv)
    TextView turn_tv;

    @BindView(R.id.turnHS_tv)
    TextView turnHS_tv;

    @BindView(R.id.f1)
    FrameLayout f1;

    @OnClick(R.id.restart_bt)
    public void restart(){
        newImage(0);
        bt1.setImageResource(image);
        bt2.setImageResource(image);
        bt3.setImageResource(image);
        bt4.setImageResource(image);
        bt5.setImageResource(image);
        bt6.setImageResource(image);
        bt7.setImageResource(image);
        bt8.setImageResource(image);
        bt9.setImageResource(image);
        bt10.setImageResource(image);
        bt11.setImageResource(image);
        bt12.setImageResource(image);
        bt13.setImageResource(image);
        bt14.setImageResource(image);
        bt15.setImageResource(image);
        bt16.setImageResource(image);


        bt1.setEnabled(true);
        bt2.setEnabled(true);
        bt3.setEnabled(true);
        bt4.setEnabled(true);
        bt5.setEnabled(true);
        bt6.setEnabled(true);
        bt7.setEnabled(true);
        bt8.setEnabled(true);
        bt9.setEnabled(true);
        bt10.setEnabled(true);
        bt11.setEnabled(true);
        bt12.setEnabled(true);
        bt13.setEnabled(true);
        bt14.setEnabled(true);
        bt15.setEnabled(true);
        bt16.setEnabled(true);

        counter=0;
        turnCounter=0;
        turn_tv.setText("Turn: "+turnCounter);
        shuffleArray();
    }

    @OnClick(R.id.cheat_bt)
    public void cheat(){
        newImage(game[0]);
        bt1.setImageResource(image);
        newImage(game[1]);
        bt2.setImageResource(image);
        newImage(game[2]);
        bt3.setImageResource(image);
        newImage(game[3]);
        bt4.setImageResource(image);
        newImage(game[4]);
        bt5.setImageResource(image);
        newImage(game[5]);
        bt6.setImageResource(image);
        newImage(game[6]);
        bt7.setImageResource(image);
        newImage(game[7]);
        bt8.setImageResource(image);
        newImage(game[8]);
        bt9.setImageResource(image);
        newImage(game[9]);
        bt10.setImageResource(image);
        newImage(game[10]);
        bt11.setImageResource(image);
        newImage(game[11]);
        bt12.setImageResource(image);
        newImage(game[12]);
        bt13.setImageResource(image);
        newImage(game[13]);
        bt14.setImageResource(image);
        newImage(game[14]);
        bt15.setImageResource(image);
        newImage(game[15]);
        bt16.setImageResource(image);
    }

    ImageButton bt;
    int image;

    private int game[]={1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8};

    final Handler mHandler=new Handler();
    InputNameDialog inputNameDialog;
    String name;

    ImageButton firstBt;
    int firstVal;

    int counter=0;
    int completion=0;

    int turnCounter=0;
    int turnHighScore=9;

    private ViewPager viewPager;
    private ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();
    private ArrayList<String> listResult=new ArrayList<String>();
    private TabLayout tabLayout;

    private GestureDetector mGestureDetector;

    protected void MatchingGame() {
        setContentView(R.layout.activity_matching_game);
        ButterKnife.bind(this);
        shuffleArray();
        turnHS_tv.setText("High Score: "+turnHighScore);
        mGestureDetector=new GestureDetector(this,new SimpleGestureListener());
        f1.setOnTouchListener(this);


        BlankListViewAdapter listViewAdapter=new BlankListViewAdapter(this,listResult);
        View view= getLayoutInflater().inflate(R.layout.mg_header,null);
        LinearLayout listViewHeader=(LinearLayout) view.findViewById(R.id.mg_header);
        viewPager=(ViewPager) view.findViewById(R.id.pager_header);
        fragmentList.add(new mg_title());
        fragmentList.add(new mg_rules());
        fragmentList.add(new mg_credits());
        ViewPagerAdapter viewPagerAdapter= new ViewPagerAdapter(this.getSupportFragmentManager());
        viewPagerAdapter.setContent(fragmentList);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout = (TabLayout) view.findViewById(R.id.tab_Layout);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("Title");
        tabLayout.getTabAt(1).setText("Objective");
        tabLayout.getTabAt(2).setText("Credits");
        listView.addHeaderView(listViewHeader);
        listView.setAdapter(listViewAdapter);

    }



    public void buttonOnClick(View view)
    {
        switch(view.getId())
        {
            case R.id.bt1:
                bt1.setEnabled(false);
                bt=bt1;
                flip();
                newImage(game[0]);
                setImage();
                check(bt1,game[0]);
                break;
            case R.id.bt2:

                bt2.setEnabled(false);
                bt=bt2;
                flip();
                newImage(game[1]);
                setImage();
                check(bt2,game[1]);
                break;
            case R.id.bt3:
                bt3.setEnabled(false);
                bt=bt3;
                flip();
                newImage(game[2]);
                setImage();
                check(bt3,game[2]);
                break;
            case R.id.bt4:
                bt4.setEnabled(false);
                bt=bt4;
                flip();
                newImage(game[3]);
                setImage();
                check(bt4,game[3]);
                break;
            case R.id.bt5:
                bt5.setEnabled(false);
                bt=bt5;
                flip();
                newImage(game[4]);
                setImage();
                check(bt5,game[4]);
                break;
            case R.id.bt6:
                bt6.setEnabled(false);
                bt=bt6;
                flip();
                newImage(game[5]);
                setImage();
                check(bt6,game[5]);
                break;
            case R.id.bt7:
                bt7.setEnabled(false);
                bt=bt7;
                flip();
                newImage(game[6]);
                setImage();
                check(bt7,game[6]);
                break;
            case R.id.bt8:
                bt8.setEnabled(false);
                bt=bt8;
                flip();
                newImage(game[7]);
                setImage();
                check(bt8,game[7]);
                break;
            case R.id.bt9:
                bt9.setEnabled(false);
                bt=bt9;
                flip();
                newImage(game[8]);
                setImage();
                check(bt9,game[8]);
                break;
            case R.id.bt10:
                bt10.setEnabled(false);
                bt=bt10;
                flip();
                newImage(game[9]);
                setImage();
                check(bt10,game[9]);
                break;
            case R.id.bt11:
                bt11.setEnabled(false);
                bt=bt11;
                flip();
                newImage(game[10]);
                setImage();
                check(bt11,game[10]);
                break;
            case R.id.bt12:
                bt12.setEnabled(false);
                bt=bt12;
                flip();
                newImage(game[11]);
                setImage();
                check(bt12,game[11]);
                break;
            case R.id.bt13:
                bt13.setEnabled(false);
                bt=bt13;
                flip();
                newImage(game[12]);
                setImage();
                check(bt13,game[12]);
                break;
            case R.id.bt14:
                bt14.setEnabled(false);
                bt=bt14;
                flip();
                newImage(game[13]);
                setImage();
                check(bt14,game[13]);
                break;
            case R.id.bt15:
                bt15.setEnabled(false);
                bt=bt15;
                flip();
                newImage(game[14]);
                setImage();
                check(bt15,game[14]);
                break;
            case R.id.bt16:
                bt16.setEnabled(false);
                bt=bt16;
                flip();
                newImage(game[15]);
                setImage();
                check(bt16,game[15]);
                break;
        }
    }

    public void shuffleArray(){
        Random random=new Random();
        for(int i=game.length-1;i>0;i--){
            int index=random.nextInt(i+1);
            int temp=game[index];
            game[index]=game[i];
            game[i]=temp;
        }
    }

    public void newImage(int num){
        switch (num){
            case 1:
                image=R.mipmap.img1;
                break;
            case 2:
                image=R.mipmap.img2;
                break;
            case 3:
                image=R.mipmap.img3;
                break;
            case 4:
                image=R.mipmap.img4;
                break;
            case 5:
                image=R.mipmap.img5;
                break;
            case 6:
                image=R.mipmap.img6;
                break;
            case 7:
                image=R.mipmap.img7;
                break;
            case 8:
                image=R.mipmap.img8;
                break;
            case 0:
                image=R.mipmap.img0;
                break;
        }
    }
    public void setImage(){
        bt1.setClickable(false);
        bt2.setClickable(false);
        bt3.setClickable(false);
        bt4.setClickable(false);
        bt5.setClickable(false);
        bt6.setClickable(false);
        bt7.setClickable(false);
        bt8.setClickable(false);
        bt9.setClickable(false);
        bt10.setClickable(false);
        bt11.setClickable(false);
        bt12.setClickable(false);
        bt13.setClickable(false);
        bt14.setClickable(false);
        bt15.setClickable(false);
        bt16.setClickable(false);


        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                bt.setImageResource(image);
                if(counter==1){
                    setClickableTrue();
                }
            }
        }, 300);
    }
    public void rotate(ImageButton theBt){
        ObjectAnimator animator = ObjectAnimator.ofFloat(theBt,"rotation",0,360,360);//rotationX   rotationY
        animator.setDuration(1000);
        animator.start();
    }
    public void flip(){
        ObjectAnimator animator = ObjectAnimator.ofFloat(bt,"rotationY",0,180,180);//rotationX   rotationY
        animator.setDuration(1000);
        animator.start();
    }
    public void reverseFlip(){
        ObjectAnimator animator = ObjectAnimator.ofFloat(bt,"rotationY",180,0,0);//rotationX   rotationY
        animator.setDuration(1000);
        animator.start();
    }

    public void check(final ImageButton button, int val){
        if(counter==0){
            firstBt=button;
            firstVal=val;
            counter++;
        }else{
            counter=0;
            turnCounter++;
            turn_tv.setText("Turn: "+turnCounter);
            if(val==firstVal){
                //pair match
                rotate(firstBt);
                rotate(button);
                setClickableTrue();
                completion+=2;
                if(completion==16){
                    rotate(bt1);
                    rotate(bt2);
                    rotate(bt3);
                    rotate(bt4);
                    rotate(bt5);
                    rotate(bt6);
                    rotate(bt7);
                    rotate(bt8);
                    rotate(bt9);
                    rotate(bt10);
                    rotate(bt11);
                    rotate(bt12);
                    rotate(bt13);
                    rotate(bt14);
                    rotate(bt15);
                    rotate(bt16);
                    //game over
                    if(turnCounter<turnHighScore){
                        turnHighScore=turnCounter;
                        turnHS_tv.setText("High Score: "+turnCounter);
                    }
                    mHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                        }
                    }, 300);
                    inputNameDialog=new InputNameDialog(this, new InputNameDialog.ICustomDialogEventListener() {
                        @Override
                        public void onClickListener() {
                            mHandler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    name=inputNameDialog.getName();
                                    //toastShort(name);

                                    Intent intent = new Intent(MatchingGame.this,LeaderboardActivity.class);
                                    Bundle bundle = new Bundle();
                                    Entry entry = new Entry();
                                    entry.setName(name);
                                    entry.setScore(""+turnCounter);
                                    bundle.putSerializable("entry", entry);
                                    intent.putExtras(bundle);
                                    startActivity(intent);
                                }
                            }, 300);
                        }
                    });
                    inputNameDialog.show();
                }
            }else{

                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        bt=firstBt;
                        bt.setEnabled(true);
                        reverseFlip();
                        newImage(0);
                        setImage();
                        mHandler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                bt=button;
                                reverseFlip();
                                setImage();
                                bt.setEnabled(true);
                                mHandler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        setClickableTrue();
                                    }
                                }, 300);
                            }
                        }, 300);
                    }
                }, 1000);
            }
        }
    }

    public void setClickableTrue(){
        bt1.setClickable(true);
        bt2.setClickable(true);
        bt3.setClickable(true);
        bt4.setClickable(true);
        bt5.setClickable(true);
        bt6.setClickable(true);
        bt7.setClickable(true);
        bt8.setClickable(true);
        bt9.setClickable(true);
        bt10.setClickable(true);
        bt11.setClickable(true);
        bt12.setClickable(true);
        bt13.setClickable(true);
        bt14.setClickable(true);
        bt15.setClickable(true);
        bt16.setClickable(true);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }


    private class SimpleGestureListener extends GestureDetector.SimpleOnGestureListener {
        public boolean onDown(MotionEvent e){
            UtilLog.logD("MyGesture","onDown");
            //toastShort("onDown");
            return true;
        }
        public void onShowPress(MotionEvent e){
            UtilLog.logD("MyGesture","onShowPress");
            //toastShort("onShowPress");
        }
        public void onLongPress(MotionEvent e){
            UtilLog.logD("MyGesture","onLongPress");
            //toastShort("onLongPress");
        }
        public boolean onSingleTapUp(MotionEvent e){
            UtilLog.logD("MyGesture","onSingleTapUp");
            //toastShort("onSingleTapUp");
            return true;
        }
        public boolean onSingleTapConfirmed(MotionEvent e)
        {
            UtilLog.logD("MyGesture","onSingleTapConfirmed");
            //toastShort("onSingleTapConfirmed");
            return true;
        }
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,float distanceY){
            UtilLog.logD("MyGesture","onScroll:"+(e2.getX()-e1.getX())+" "+distanceX);
            //toastShort("onScroll");
            return true;
        }
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY){
            //toastShort("onFling");
            return true;
        }
        public boolean onDoubleTap(MotionEvent e){
            toastShort("onDoubleTap");
            if(counter==1){
                bt.setEnabled(true);

                reverseFlip();
                newImage(0);
                setImage();

                setClickableTrue();

                counter=0;
                turnCounter++;
                turn_tv.setText("Turn: "+turnCounter);
            }
            return true;
        }
        public boolean onDoubleTapEvent(MotionEvent e){
            //toastShort("onDoubleTapEvent");
            return true;
        }
    }

    @Override
    public void onDestroy(){
        MusicController controller=MusicController.getInstance(this);
        controller.destroy();
        super.onDestroy();
    }
}
