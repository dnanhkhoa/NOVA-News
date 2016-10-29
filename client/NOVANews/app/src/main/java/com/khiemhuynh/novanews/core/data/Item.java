package com.khiemhuynh.novanews.core.data;

/**
 * Created by Administrator on 10/30/2016.
 */

public class Item {
    String title;
    String content;

    public Item(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }
}
