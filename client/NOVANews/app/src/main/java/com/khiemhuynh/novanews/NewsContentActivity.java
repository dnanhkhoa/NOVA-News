package com.khiemhuynh.novanews;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.khiemhuynh.novanews.core.data.Item;
import com.khiemhuynh.novanews.utils.Utils;

import java.util.Random;

public class NewsContentActivity extends AppCompatActivity {

    private TextView newsContent;
    private Item item;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_content);

        newsContent = (TextView) findViewById(R.id.textContent);


        Random rnd = new Random();
        newsContent.setBackgroundColor(Utils.COLORS[rnd.nextInt(Utils.COLORS.length)]);

        newsContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        Bundle bd = getIntent().getExtras();
        if (bd != null) {
            String content = bd.getString("content");
            newsContent.setText(content);
        }

    }
}
