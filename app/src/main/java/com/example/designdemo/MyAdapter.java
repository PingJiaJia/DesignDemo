package com.example.designdemo;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class MyAdapter extends FragmentPagerAdapter {

    private List<String> list;

    public MyAdapter(FragmentManager fm, List<String> list) {
        super(fm);
        this.list= list;
    }


    @Override
    public Fragment getItem(int position) {
        return BlankFragment.newInstance(list.get(position));
    }


    @Override
    public int getCount() {
        return list.size();
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }
}
