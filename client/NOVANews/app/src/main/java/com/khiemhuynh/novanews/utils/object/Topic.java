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

public class Topic extends AsyncTask<Void, Void, Void> {
    @Override
    protected Void doInBackground(Void... params) {
        String url = "https://novanews-91a18.firebaseio.com/topics.json";
        String content = Utils.getURLContent(url);
        try {
            JSONObject jsonObject = new JSONObject(content);
            JSONArray arrays = jsonObject.getJSONArray("-KVHFgB1SJC7xerCOL_X");
            for (int i = 0; i < arrays.length(); ++i) {
                Core.getInstance().addCategory((String) arrays.get(i));
            }
        } catch (JSONException e) {
        }
        return null;
    }
}