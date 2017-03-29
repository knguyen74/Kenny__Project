package com.example.kenny.kennyproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kenny.kennyproject.adapter.ListViewAdapter;

import java.util.ArrayList;

public class LeaderboardActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView listView;
    private ArrayList<String> listResultName;
    private ArrayList<String> listResultNum;

    String[][] leaderboard=new String[18][2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);

        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        Entry entry=(Entry) bundle.getSerializable("entry") ;


        listResultName=new ArrayList<String>();
        listResultNum=new ArrayList<String>();
        createFakeResult(entry.getName(),entry.getScore());
        initialView();
    }

    private void createFakeResult(String name,String score){
        leaderboard[0][0]="Brian";leaderboard[0][1]="11";//2
        leaderboard[1][0]="Nicole";leaderboard[1][1]="20";
        leaderboard[2][0]="Irene";leaderboard[2][1]="25";
        leaderboard[3][0]="Anne";leaderboard[3][1]="22";
        leaderboard[4][0]="Andrew";leaderboard[4][1]="26";
        leaderboard[5][0]="Julia";leaderboard[5][1]="19";
        leaderboard[6][0]="Dennis";leaderboard[6][1]="15";
        leaderboard[7][0]="Craig";leaderboard[7][1]="9";//1
        leaderboard[8][0]="Brandon";leaderboard[8][1]="17";
        leaderboard[9][0]="Harry";leaderboard[9][1]="26";
        leaderboard[10][0]="Jonathan";leaderboard[10][1]="21";
        leaderboard[11][0]="Joe";leaderboard[11][1]="28";//last
        leaderboard[12][0]="Susan";leaderboard[12][1]="13";//3
        leaderboard[13][0]="Lois";leaderboard[13][1]="20";
        leaderboard[14][0]="Bonnie";leaderboard[14][1]="23";
        leaderboard[15][0]="Nicholas";leaderboard[15][1]="22";
        leaderboard[16][0]="Elizabeth";leaderboard[16][1]="19";
        leaderboard[17][0]=name;leaderboard[17][1]=score;

        sort();
        listResultName.add("Name");
        listResultNum.add("Score");
        for(int a=0;a<18;a++){
            listResultName.add(leaderboard[a][0]);
            listResultNum.add(leaderboard[a][1]);
        }

    }
    private void initialView() {
        listView = (ListView) findViewById(R.id.list_view);
        ListViewAdapter listViewAdapter = new ListViewAdapter(this,listResultName,listResultNum);



        View view= getLayoutInflater().inflate(R.layout.lb_header,null);
        LinearLayout listViewHeader=(LinearLayout) view.findViewById(R.id.lb_header);
        listView.addHeaderView(listViewHeader);



        TextView tv = new TextView(this);
        tv.setText("Bottom of the LeaderBoard");
        tv.setTextSize(28);
        tv.setGravity(Gravity.CENTER);
        listView.addFooterView(tv);

        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,"listView was created at posiion: "+position,Toast.LENGTH_LONG).show();
        Log.d("textListViewActivity",String.valueOf(position));

    }

    @Override
    public void onBackPressed() {
        Intent intent =new Intent();
        intent.putExtra("message","ListView");
        setResult(RESULT_OK,intent);
        super.onBackPressed();
    }
    public void sort() {
        int n = 18;
        String temp1 = "";
        String temp2 = "";
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (Integer.parseInt(leaderboard[j - 1][1]) > Integer.parseInt(leaderboard[j][1])) {
                    //swap elements
                    temp1 = leaderboard[j - 1][1];
                    leaderboard[j - 1][1] = leaderboard[j][1];
                    leaderboard[j][1] = temp1;

                    temp2 = leaderboard[j - 1][0];
                    leaderboard[j - 1][0] = leaderboard[j][0];
                    leaderboard[j][0] = temp2;
                }

            }
        }
    }
}
