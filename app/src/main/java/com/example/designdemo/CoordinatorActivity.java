package com.example.designdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

/**
 * 专门写协调器的场景其实不多
 *
 * 【主脑666】𝙇𝙤𝙡𝙡𝙞𝙥𝙤𝙥 2019/8/11 13:49:05
 * 更多的时候，是使用他的嵌套滑动的功能，还有就是系统组件自带了协调器
 */

public class CoordinatorActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);
        findViewById(R.id.coordinator_btn).setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        Snackbar.make(view,"Snackbar in CoordinatorLayout",Snackbar.LENGTH_LONG)
                .setAction("exit", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ActivityCompat.finishAffinity(CoordinatorActivity.this);
                    }
                })
                .show();
    }

}
