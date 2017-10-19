package com.sy.customprogressbardemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private Button mBtn_add;
    private Button mBtn_sub;
    private CustomProgressBar mCpb_one;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtn_add = (Button) findViewById(R.id.add);
        mBtn_sub = (Button) findViewById(R.id.sub);
        mCpb_one = (CustomProgressBar) findViewById(R.id.cpb_one);
        mCpb_one.setCircle_num(7);
        mBtn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCpb_one.add();
            }
        });
        mBtn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCpb_one.sub();
                //222222222
            }
        });
    }
}
