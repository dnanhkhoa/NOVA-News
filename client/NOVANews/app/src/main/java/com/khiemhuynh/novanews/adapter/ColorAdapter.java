package com.khiemhuynh.novanews.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.khiemhuynh.novanews.R;
import com.khiemhuynh.novanews.core.data.Item;
import com.khiemhuynh.novanews.utils.Utils;

import java.util.List;

/**
 * Created by Administrator on 10/29/2016.
 */

public final class ColorAdapter extends BaseAdapter {

    private final LayoutInflater mInflater;

    private final List<Item> items;

    public ColorAdapter(Context context, List<Item> items) {
        mInflater = LayoutInflater.from(context);
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Item getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        TextView color;
        TextView name;

        if (v == null) {
            v = mInflater.inflate(R.layout.grid_item, viewGroup, false);
            v.setTag(R.id.colorView, v.findViewById(R.id.colorView));
            v.setTag(R.id.text, v.findViewById(R.id.text));
        }

        color = (TextView) v.getTag(R.id.colorView);
        name = (TextView) v.getTag(R.id.text);

        final Item item = getItem(i);

        int colorValue = Utils.COLORS[i % Utils.COLORS.length];

        color.setBackgroundColor(colorValue);
        color.setText(item.getTitle());
        color.setTextColor(colorValue);

        return v;
    }
}