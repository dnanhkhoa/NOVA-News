package com.khiemhuynh.novanews.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.khiemhuynh.novanews.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 10/29/2016.
 */

public final class ColorAdapter extends BaseAdapter {
    private final List<Item> mItems = new ArrayList<Item>();
    private final LayoutInflater mInflater;

    public ColorAdapter(Context context) {
        mInflater = LayoutInflater.from(context);

        mItems.add(new Item("Purple",0xffba68c8));
        mItems.add(new Item("Pink", 0xfff06292));
//        mItems.add(new Item("Blue", 0xff64b5f6));
//        mItems.add(new Item("Cyan", 0xff4dd0e1));

    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Item getItem(int i) {
        return mItems.get(i);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        TextView color, color2,color3;
        TextView name;

        if (v == null) {
            v = mInflater.inflate(R.layout.grid_item, viewGroup, false);
            v.setTag(R.id.colorView, v.findViewById(R.id.colorView));

            v.setTag(R.id.text, v.findViewById(R.id.text));
        }

        color = (TextView) v.getTag(R.id.colorView);

        name = (TextView) v.getTag(R.id.text);


        Item item = getItem(i);

        color.setBackgroundColor(item.colorNum);
        color.setText("-Phim Học đường Là Anh là dự án phim dài tập của FAPtv trong năm 2016 - phim được chăm chút kĩ lưỡng , kịch bản được phát triển bởi Hi Team" +
                "Phim dự kiến phát sóng mỗi tuần 1 tập");
        color.setTextColor(item.colorNum);


        name.setText(item.name);

        return v;
    }

    class Item {
        public final String name;
        public final int colorNum;

        Item(String name, int colorNum) {
            this.name = name;
            this.colorNum = colorNum;
        }
    }
}