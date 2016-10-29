package com.khiemhuynh.novanews.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.khiemhuynh.novanews.R;

import java.util.List;

/**
 * Created by Administrator on 10/25/2016.
 */
public class ViewElementsAdapter extends ArrayAdapter<ViewElements> {

    public ViewElementsAdapter(Context context, int resource, List<ViewElements> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view =  inflater.inflate(R.layout.listview_row, null);
        }
        ViewElements p = getItem(position);
        if (p != null) {
            // Anh xa + Gan gia tri
            TextView title = (TextView) view.findViewById(R.id.textViewTitle);
            title.setText(p.title);
        }
        return view;
    }

}