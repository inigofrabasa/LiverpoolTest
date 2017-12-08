package com.inigoflores.liverpooltest.application;

import android.app.Application;
import android.content.Context;

/**
 * Created by inigo on 06/12/17.
 */

public class LiverpoolApplication extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        this.context = getApplicationContext();
    }
}
