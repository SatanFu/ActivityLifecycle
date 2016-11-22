package com.satanfu.library;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/**
 * 4.0以上系统Activity生命周期回调接口
 * Created by SatanFu on 2016/11/21.
 */

@SuppressLint("NewApi")
public class MyActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    @Override
    public void onActivityCreated(Activity activity,
                                  Bundle savedInstanceState) {
        ActivityLifeManager.getInstance().onActivityCreated(activity,
                savedInstanceState);
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {
        ActivityLifeManager.getInstance().onActivityResumed(activity);
    }

    @Override
    public void onActivityPaused(Activity activity) {
        ActivityLifeManager.getInstance().onActivityPaused(activity);
    }

    @Override
    public void onActivityStopped(Activity activity) {
        ActivityLifeManager.getInstance().onActivityStoped(activity);
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity,
                                            Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        ActivityLifeManager.getInstance().onActivityDestroyed(activity);
    }
}
