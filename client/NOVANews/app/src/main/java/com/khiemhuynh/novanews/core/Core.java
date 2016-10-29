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
        Category cat1 = new Category("TIN NÓNG");
        cat1.addItem(new Item("Không khởi tố vụ nam hành khách đánh nữ nhân viên hàng không", "Sự việc hai nam hành khách đánh nữ nhân viên hàng không tại sân bay Nội Bài diễn ra ngày 18/10. Đến ngày 20/10, Thủ tướng yêu cầu Chủ tịch UBND thành phố Hà Nội chỉ đạo các cơ quan chức năng khẩn trương làm rõ và báo cáo kết quả lên Thủ tướng trong tháng 10."));
        cat1.addItem(new Item("Hành khách kể về phút hoảng loạn trên phi cơ bốc cháy Mỹ ", "Chiếc phi cơ chở 161 hành khách và tổ bay 9 người khởi hành từ sân bay O'Hare, Chicago, bang Illinois, đến Miami, bang Florida, bốc cháy trên đường băng khi chuẩn bị cất cánh. 20 người bị thương nhẹ đang được điều trị trong bệnh viện. "));
        cat1.addItem(new Item("Bai 3", "Noi dung 3"));
        cat1.addItem(new Item("Bai 3", "Noi dung 1"));
        cat1.addItem(new Item("Bai 5", "Noi dung 2"));
        cat1.addItem(new Item("Bai 6", "Noi dung 3"));
        cat1.addItem(new Item("Bai 7", "Noi dung 1"));
        cat1.addItem(new Item("Bai 8", "Noi dung 2"));
        cat1.addItem(new Item("Bai 9", "Noi dung 3"));
        categories.add(cat1);

        Category cat2 = new Category("TIN CHÍNH TRỊ");
        cat2.addItem(new Item("Bai 1", "Noi dung 1"));
        cat2.addItem(new Item("Bai 2", "Noi dung 2"));
        cat2.addItem(new Item("Bai 3", "Noi dung 3"));
        categories.add(cat2);

        Category cat3 = new Category("TIN THỂ THAO");
        cat3.addItem(new Item("Bai 1", "Noi dung 1"));
        cat3.addItem(new Item("Bai 2", "Noi dung 2"));
        cat3.addItem(new Item("Bai 3", "Noi dung 3"));
        categories.add(cat3);
    }
}
