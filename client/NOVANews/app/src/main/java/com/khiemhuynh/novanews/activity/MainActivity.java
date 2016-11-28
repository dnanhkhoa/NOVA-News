package com.khiemhuynh.novanews.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.khiemhuynh.novanews.R;
import com.khiemhuynh.novanews.adapter.PagerAdapter;
import com.khiemhuynh.novanews.core.Core;
import com.khiemhuynh.novanews.utils.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        int appcolor = 0xff4caf50;
        tabLayout.setTabTextColors(appcolor, appcolor);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);

        Core.getInstance().clearCategories();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String url = "https://novanews-91a18.firebaseio.com/topics.json";
                String content = Utils.getURLContent(url);
                try {
                    JSONObject jsonObject = new JSONObject(content);
                    JSONArray arrays = jsonObject.getJSONArray("-KVHFgB1SJC7xerCOL_X");
                    for (int i = 0; i < arrays.length(); ++i) {
                        Core.getInstance().addCategory((String) arrays.get(i));
                    }
                } catch (JSONException e) {
                }

                url = "https://novanews-91a18.firebaseio.com/news.json";
                content = Utils.getURLContent(url);
                try {
                    JSONObject jsonObject = new JSONObject(content);
                    JSONArray jsonArray = jsonObject.names();

                    for (int i = 0; i < jsonArray.length(); ++i) {
                        JSONObject obj = ((JSONObject)jsonObject.get((String)jsonArray.get(i)));
                        String title = obj.getString("title");
                        String postContent = obj.getString("content");
                        String category = obj.getString("category");

                        Core.getInstance().addItem(title, postContent, category);
                    }
                } catch (JSONException e) {
                }
            }
        });

        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
        }


        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout);
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

