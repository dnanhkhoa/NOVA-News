package com.khiemhuynh.novanews.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.khiemhuynh.novanews.tab.TabHotNews;
import com.khiemhuynh.novanews.tab.TabSubject;

/**
 * Created by Administrator on 10/29/2016.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                TabHotNews tabHotNews = new TabHotNews();
                return tabHotNews;
            case 1:
                TabSubject tabSubject = new TabSubject();
                return tabSubject;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}