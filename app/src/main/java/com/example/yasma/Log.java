package com.example.yasma;

import static android.util.Log.e;

public class Log {
    public static void logThrowable(Throwable throwable) {
        if (BuildConfig.DEBUG)
            e("", "Rx Error", throwable);
    }
}
