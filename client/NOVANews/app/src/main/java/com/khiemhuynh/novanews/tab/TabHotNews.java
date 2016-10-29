package com.khiemhuynh.novanews.tab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.khiemhuynh.novanews.R;
import com.khiemhuynh.novanews.adapter.ColorAdapter;
import com.khiemhuynh.novanews.adapter.ViewElementsAdapter;
import com.khiemhuynh.novanews.adapter.ViewElements;

import java.util.ArrayList;

/**
 * Created by Administrator on 10/29/2016.
 */

public class TabHotNews extends Fragment {

    GridView gridView;
    ViewElementsAdapter cus_adapter;
    ArrayList<ViewElements> viewElementsList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.tab_hotnews, container, false);

        gridView = (GridView) view.findViewById(R.id.gridview);
        gridView.setAdapter(new ColorAdapter(getContext()));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        return view;
        //return inflater.inflate(R.layout.tab_hotnews, container, false);
    }




}