package com.khiemhuynh.novanews.adapter;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.khiemhuynh.novanews.core.Core;
import com.khiemhuynh.novanews.core.data.Category;
import com.khiemhuynh.novanews.tab.SingleTab;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 10/29/2016.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {

    private List<SingleTab> singleTabs;
    private List<Category> categories;
    private TabLayout tabLayout;

    public PagerAdapter(FragmentManager fm, TabLayout tabLayout) {
        super(fm);

        categories = Core.getInstance().getCategories();

        this.singleTabs = new ArrayList<>();
        this.tabLayout = tabLayout;

        for (int i = 0; i < categories.size(); ++i) {
            this.tabLayout.addTab(this.tabLayout.newTab().setText(categories.get(i).getName()));
            SingleTab singleTab = new SingleTab();
            singleTab.update(categories.get(i).getItems());
            this.singleTabs.add(singleTab);
        }

        update();
    }

    public void update() {
        categories = Core.getInstance().getCategories();
        for (int i = 0; i < categories.size(); ++i) {
            singleTabs.get(i).update(categories.get(i).getItems());
        }
    }

    @Override
    public Fragment getItem(int position) {
        return singleTabs.get(position);
    }

    @Override
    public int getCount() {
        return categories.size();
    }
}
