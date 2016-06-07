package com.blacktea.ztine.learnmyblog.utils;

import okhttp3.OkHttpClient;

/**
 * Created by ztine on 16/6/7.
 */
public class OkHttpUtils {
    private static OkHttpClient ourInstance = new OkHttpClient();

    public static OkHttpClient getInstance() {
        if (ourInstance == null)
        {
            ourInstance = new OkHttpClient();
        }
        return ourInstance;
    }


    private OkHttpUtils() {
    }
}
