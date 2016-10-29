package com.khiemhuynh.novanews.tab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.khiemhuynh.novanews.NewsContentActivity;
import com.khiemhuynh.novanews.R;
import com.khiemhuynh.novanews.adapter.ColorAdapter;
import com.khiemhuynh.novanews.core.data.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 10/29/2016.
 */

public class SingleTab extends Fragment {

    private GridView gridView;

    private List<Item> items;

    public SingleTab() {
        items = new ArrayList<>();
    }

    public void update(List<Item> items) {
        this.items = items;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.single_tab, container, false);

        gridView = (GridView) view.findViewById(R.id.gridview);

        gridView.setAdapter(new ColorAdapter(getContext(), items));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent newsContent = new Intent(view.getContext(), NewsContentActivity.class);
                newsContent.putExtra("content", items.get(position).getContent());
                view.getContext().startActivity(newsContent);
            }
        });
        return view;

    }




}