package com.khiemhuynh.novanews.core;

import com.khiemhuynh.novanews.core.data.Category;
import com.khiemhuynh.novanews.core.data.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 10/30/2016.
 */

public class Core {
    private static Core instance;

    private List<Category> categories;

    private Core() {
        categories = new ArrayList<>();
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
        // Logic

        // Fake data
        Category cat1 = new Category("HOT NEWS");
        cat1.addItem(new Item("Bai 1", "Noi dung 1"));
        cat1.addItem(new Item("Bai 2", "Noi dung 2"));
        cat1.addItem(new Item("Bai 3", "Noi dung 3"));
        cat1.addItem(new Item("Bai 3", "Noi dung 1"));
        cat1.addItem(new Item("Bai 5", "Noi dung 2"));
        cat1.addItem(new Item("Bai 6", "Noi dung 3"));
        cat1.addItem(new Item("Bai 7", "Noi dung 1"));
        cat1.addItem(new Item("Bai 8", "Noi dung 2"));
        cat1.addItem(new Item("Bai 9", "Noi dung 3"));
        categories.add(cat1);

        Category cat2 = new Category("CAT 2");
        cat2.addItem(new Item("Bai 1", "Noi dung 1"));
        cat2.addItem(new Item("Bai 2", "Noi dung 2"));
        cat2.addItem(new Item("Bai 3", "Noi dung 3"));
        categories.add(cat2);

        Category cat3 = new Category("CAT 3");
        cat3.addItem(new Item("Bai 1", "Noi dung 1"));
        cat3.addItem(new Item("Bai 2", "Noi dung 2"));
        cat3.addItem(new Item("Bai 3", "Noi dung 3"));
        categories.add(cat3);
    }
}
