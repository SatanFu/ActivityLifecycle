package com.satanfu.activitylifecycle;

import android.app.Application;

import com.satanfu.library.MobclickAgent;

/**
 * Created by SatanFu on 2016/11/21.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MobclickAgent.init(this);
    }
}
