package com.khiemhuynh.novanews.utils.object;

import android.os.AsyncTask;

import com.khiemhuynh.novanews.core.Core;
import com.khiemhuynh.novanews.utils.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 10/30/2016.
 */

public class Post extends AsyncTask<Void, Void, Void> {
    @Override
    protected Void doInBackground(Void... params) {
        String url = "https://novanews-91a18.firebaseio.com/news.json";
        String content = Utils.getURLContent(url);
        try {
            JSONObject jsonObject = new JSONObject(content);
            JSONArray jsonArray = jsonObject.names();

            for (int i = 0; i < jsonArray.length(); ++i) {
                JSONObject obj = ((JSONObject)jsonObject.get((String)jsonArray.get(i)));
                String title = obj.getString("title");
                String postContent = obj.getString("content");
                String category = obj.getString("category");

                Core.getInstance().addItem(title, postContent, category);
            }
        } catch (JSONException e) {
        }
        return null;
    }
}