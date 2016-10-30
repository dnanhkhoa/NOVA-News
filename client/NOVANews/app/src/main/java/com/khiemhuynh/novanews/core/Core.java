package com.khiemhuynh.novanews.core;

import com.khiemhuynh.novanews.core.data.Category;
import com.khiemhuynh.novanews.core.data.Item;
import com.khiemhuynh.novanews.utils.object.Post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 10/30/2016.
 */

public class Core {
    private static Core instance;

    private Map<String, Category> maps;
    private List<Category> categories;

    private Core() {
        categories = new ArrayList<>();
        maps = new HashMap<>();

        //new Topic().execute();
        addCategory("Tin nóng");
        addCategory("Khoa học");
        addCategory("Thời sự");
        loadData();
    }

    public static Core getInstance() {
        if (instance == null) {
            instance = new Core();
        }
        return instance;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void loadData() {
        new Post().execute();
    }

    public void addItem(String title, String content, String topic) {
        Category category = maps.get(topic);
        category.addItem(new Item(title, content));
    }

    public void addCategory(String name) {
        Category category = new Category(name);
        this.categories.add(category);
        this.maps.put(name, category);
    }
}
