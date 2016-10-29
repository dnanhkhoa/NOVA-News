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
        mItems.add(new Item("Blue Grey", 0xff90a4ae));
        mItems.add(new Item("Pink", 0xfff06292));
        mItems.add(new Item("Brown", 0xffa1887f));
        mItems.add(new Item("Cyan", 0xff4dd0e1));
        mItems.add(new Item("Lime", 0xffdce775));
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


        final Item item = getItem(i);

        color.setBackgroundColor(item.colorNum);
        color.setText("Tui là ai?");
        color.setTextColor(item.colorNum);
        name.setText(item.name);

//        color.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent newsContent = new Intent(v.getContext(),NewsContentActivity.class);
//                v.getContext().startActivity(newsContent);
//            }
//        });


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