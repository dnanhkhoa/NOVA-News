package com.khiemhuynh.novanews.core.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 10/30/2016.
 */

public class Category {
    private String name;
    private List<Item> items;

    public Category(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }
}
