package com.example.yasma.view;

import android.app.Application;

import com.example.yasma.data.RetrofitAdapter;
import com.example.yasma.data.RetrofitService;

public class MyApplication extends Application {

    private static MyApplication  app;
    public RetrofitService mAPIService;

    public static MyApplication getInstance ()
    {
        if (app == null)
        {
            app = new MyApplication();
        }

        return app;
    }

    @Override
    public void onCreate ()
    {
        super.onCreate();

        app = this;
        mAPIService = RetrofitAdapter.create();
    }
}
