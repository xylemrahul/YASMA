package com.example.yasma;

import static android.util.Log.e;

public class Utils {

    public static String POSTS_EXTRA = "EXTRA_POSTS_DETAILS";
    public static String ALBUMS_EXTRA = "EXTRA_ALBUMS_DETAILS";
    public static void logThrowable(Throwable throwable) {
        if (BuildConfig.DEBUG)
            e("", "Rx Error", throwable);
    }
}
