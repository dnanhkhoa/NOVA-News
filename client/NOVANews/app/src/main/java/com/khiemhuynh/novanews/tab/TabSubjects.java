package com.khiemhuynh.novanews.tab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.khiemhuynh.novanews.R;
import com.khiemhuynh.novanews.TitleActivity;
import com.khiemhuynh.novanews.adapter.ColorAdapter;

/**
 * Created by Administrator on 10/29/2016.
 */

public class TabSubjects extends Fragment {


    GridView subjectGridView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_subjects, container, false);

        subjectGridView = (GridView) v.findViewById(R.id.subgridview);
        subjectGridView.setAdapter(new ColorAdapter(getContext()));
        subjectGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent newsContent = new Intent(view.getContext(), TitleActivity.class);
                view.getContext().startActivity(newsContent);
            }
        });



        return v;
    }



}