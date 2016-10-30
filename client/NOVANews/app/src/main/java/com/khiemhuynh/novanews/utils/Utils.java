package com.khiemhuynh.novanews.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by Administrator on 10/30/2016.
 */

public class Utils {

    public static final int[] COLORS = {
            0xffba68c8, 0xff64b5f6, 0xff4dd0e1, 0xffaed581, 0xffffd54f, 0xffdce775, 0xff90a4ae, 0xffa1887f
    };

    public static String getURLContent(String url) {
        InputStreamReader isr = null;
        BufferedReader in = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            isr = new InputStreamReader(new URL(url).openStream());
            in = new BufferedReader(isr);
            String line;
            while ((line = in.readLine()) != null)
                stringBuilder.append(line);
        } catch (Exception e) {
        } finally {
            try {
                in.close();
                isr.close();
            } catch (IOException e) {
            }
        }
        return stringBuilder.toString();
    }
}
