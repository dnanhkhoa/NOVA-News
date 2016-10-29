package com.khiemhuynh.novanews.tab;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.khiemhuynh.novanews.R;

/**
 * Created by Administrator on 10/29/2016.
 */

public class TabSubject extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_subject, container, false);
    }
}