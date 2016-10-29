package com.khiemhuynh.novanews.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.khiemhuynh.novanews.tab.SingleTab;

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
                SingleTab tabOne = new SingleTab();
                return tabOne;
            case 1:
                SingleTab tabTwo = new SingleTab();
                return tabTwo;
            case 2:
                SingleTab tabTwo = new SingleTab();
                return tabTwo;
            case 3:
                SingleTab tabTwo = new SingleTab();
                return tabTwo;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
