package com.satanfu.library;

import android.app.Activity;
import android.app.Instrumentation;
import android.os.Bundle;

/**
 * 自定义Instrumentation
 * Created by SatanFu on 2016/11/21.
 */

public class MyInstrumentation extends Instrumentation {

    @Override
    public void callActivityOnCreate(Activity activity, Bundle icicle) {
        super.callActivityOnCreate(activity, icicle);
        ActivityLifeManager.getInstance().onActivityCreated(activity, icicle);
    }

    @Override
    public void callActivityOnPause(Activity activity) {
        super.callActivityOnPause(activity);
        ActivityLifeManager.getInstance().onActivityPaused(activity);
    }

    @Override
    public void callActivityOnDestroy(Activity activity) {
        super.callActivityOnDestroy(activity);
        ActivityLifeManager.getInstance().onActivityDestroyed(activity);
    }

    @Override
    public void callActivityOnResume(Activity activity) {
        super.callActivityOnResume(activity);
        ActivityLifeManager.getInstance().onActivityResumed(activity);
    }

    @Override
    public void callActivityOnStart(Activity activity) {
        super.callActivityOnStart(activity);
        ActivityLifeManager.getInstance().onActivityStarted(activity);
    }

    @Override
    public void callActivityOnStop(Activity activity) {
        super.callActivityOnStop(activity);
        ActivityLifeManager.getInstance().onActivityStoped(activity);
    }

}
