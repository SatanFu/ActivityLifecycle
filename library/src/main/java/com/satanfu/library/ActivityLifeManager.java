package com.satanfu.library;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

/**
 * 生命周期管理类
 * Created by SatanFu on 2016/11/21.
 */

public class ActivityLifeManager implements IActivityLifecycleCallbacks {

    private static ActivityLifeManager manager;
    private List<IActivityLifecycleCallbacks> lifeChanges = new ArrayList<IActivityLifecycleCallbacks>();

    public static synchronized ActivityLifeManager getInstance() {
        if (manager == null) {
            manager = new ActivityLifeManager();
        }
        return manager;
    }

    private ActivityLifeManager() {
    }

    public void addIActivityLifeChange(IActivityLifecycleCallbacks lis) {
        lifeChanges.add(lis);
    }

    @Override
    public void onActivityStarted(Activity activity) {
        for (IActivityLifecycleCallbacks lis : lifeChanges) {
            lis.onActivityStarted(activity);
        }
    }

    @Override
    public void onActivityResumed(Activity activity) {
        for (IActivityLifecycleCallbacks lis : lifeChanges) {
            lis.onActivityResumed(activity);
        }
    }

    @Override
    public void onActivityPaused(Activity activity) {
        for (IActivityLifecycleCallbacks lis : lifeChanges) {
            lis.onActivityPaused(activity);
        }
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        for (IActivityLifecycleCallbacks lis : lifeChanges) {
            lis.onActivityDestroyed(activity);
        }
    }

    @Override
    public void onActivityCreated(Activity activity,
                                  Bundle savedInstanceState) {
        for (IActivityLifecycleCallbacks lis : lifeChanges) {
            lis.onActivityCreated(activity, savedInstanceState);
        }
    }

    @Override
    public void onActivityStoped(Activity activity) {
        for (IActivityLifecycleCallbacks lis : lifeChanges) {
            lis.onActivityStoped(activity);
        }

    }
}
