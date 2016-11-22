package com.sy.customprogressbardemo;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import static android.R.attr.id;

public class MainActivity extends Activity {

    private Button mBtn_add;
    private Button mBtn_sub;
    private CustomProgressBar mCpb_one;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtn_add = (Button) findViewById(R.id.add);
        mBtn_sub = (Button) findViewById(R.id.sub);
        mCpb_one = (CustomProgressBar) findViewById(R.id.cpb_one);

    }
}
