package com.satanfu.library;

import android.app.Activity;
import android.os.Bundle;

/**
 * 4.0以下自定义Activity生命周期回调接口
 * Created by SatanFu on 2016/11/21.
 */

public interface IActivityLifecycleCallbacks {

    public void onActivityCreated(Activity activity, Bundle savedInstanceState);

    public void onActivityStarted(Activity activity);

    public void onActivityResumed(Activity activity);

    public void onActivityPaused(Activity activity);

    public void onActivityStoped(Activity activity);

    public void onActivityDestroyed(Activity activity);

}