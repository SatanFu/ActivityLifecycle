package com.satanfu.library;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by SatanFu on 2016/11/21.
 */

public class MobclickAgent {


    /**
     * 初始化
     * @param app
     */
    public static void init(Application app) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            //4.0以上使用系统自带的Activity生命周期监听方式
            app.registerActivityLifecycleCallbacks(
                    new MyActivityLifecycleCallbacks());
        } else {
            //4.0以下，替换Instrumentation，实现Activity生命周期监听
            replaceInstrumentation();
        }

        //最终两种方式生命周期统一回调
        ActivityLifeManager.getInstance()
                .addIActivityLifeChange(new IActivityLifecycleCallbacks() {

                    @Override
                    public void onActivityStarted(Activity activity) {

                    }

                    @Override
                    public void onActivityResumed(Activity activity) {

                    }

                    @Override
                    public void onActivityPaused(Activity activity) {

                    }

                    @Override
                    public void onActivityDestroyed(Activity activity) {

                    }

                    @Override
                    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

                    }

                    @Override
                    public void onActivityStoped(Activity activity) {

                    }
                });
    }


    /**
     * 替换系统默认的Instrumentation
     */
    public static void replaceInstrumentation() {
        Class<?> activityThreadClass;
        try {
            // 加载activity thread的class
            activityThreadClass = Class.forName("android.app.ActivityThread");

            // 找到方法currentActivityThread
            Method method = activityThreadClass
                    .getDeclaredMethod("currentActivityThread");
            // 由于这个方法是静态的，所以传入Null就行了
            Object currentActivityThread = method.invoke(null);

            // 把之前ActivityThread中的mInstrumentation替换成我们自己的
            Field field = activityThreadClass
                    .getDeclaredField("mInstrumentation");
            field.setAccessible(true);
            MyInstrumentation mInstrumentation = new MyInstrumentation();
            field.set(currentActivityThread, mInstrumentation);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


