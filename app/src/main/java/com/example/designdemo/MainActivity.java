package com.example.designdemo;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager pager=(ViewPager)findViewById(R.id.pager);
        TabLayout tab=(TabLayout)findViewById(R.id.tab);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        DrawerLayout drawer= (DrawerLayout)findViewById(R.id.drawer);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawer,toolbar,0,0);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        List<String> list=new ArrayList<>();
        for (int i=0;i<100;i++){
            list.add(String.format(Locale.CHINA,"第%02d页",i));
        }
        pager.setAdapter(new MyAdapter(getSupportFragmentManager(),list));
        tab.setupWithViewPager(pager);

        findViewById(R.id.btn).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Toast.makeText(getApplicationContext(),"您好！",Toast.LENGTH_LONG).show();

//        Snackbar.make(view,"Snackbar",Snackbar.LENGTH_LONG).show();
        Snackbar.make(view,"Snackbar",Snackbar.LENGTH_LONG)
                .setAction("undo",new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
//                        Toast.makeText(MainActivity.this, "undo", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, CoordinatorActivity.class));
                    }
                })
                .show();

    }
}
