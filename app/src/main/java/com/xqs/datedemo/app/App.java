package com.xqs.datedemo.app;

import android.app.Application;



public class App extends Application {
    private static App instance;
    public static int sScreenHeight, sScreenWidth;

    @Override
    public void onCreate() {
        super.onCreate();
        setInstance(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public void setInstance(App application) {
        instance = application;
    }

    public static App getContext() {
        return instance;
    }


}
