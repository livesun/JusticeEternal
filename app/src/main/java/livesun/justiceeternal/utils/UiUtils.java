package livesun.justiceeternal.utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;

import livesun.justiceeternal.base.JEApp;

/**
 * 与UI相关的工具类
 * Created by gesangdianzi on 2016/8/31.
 */
public class UiUtils {

    // 获取上下文
    public static Context getContext() {
        return JEApp.getContext();

    }

    // 把xml转化为View
    public static View inflate(int xmlResId) {
        return View.inflate(getContext(), xmlResId, null);

    }

    // 获取Hander
    public static Handler getHandler() {
        return JEApp.getHandler();

    }

    // 获取主线程
    public static Thread getThread() {
        return JEApp.getMainThread();

    }

    // 获取主线程ID

    public static int getMainThreadId() {
        return JEApp.getMainThreadId();

    }

    // 获取LayoutInflater对象
    public static LayoutInflater getInflater() {
        return LayoutInflater.from(getContext());

    }

    // 获取资源

    public static Resources getResources() {
        return getContext().getResources();

    }

    // 取得字符串资源
    public static String getString(int stringResId) {
        return getResources().getString(stringResId);
    }

    // 取得字符串数组资源
    public static String[] getStringArray(int stringArrayResId) {
        return getResources().getStringArray(stringArrayResId);
    }

    // dp转px
    public static int dp2px(int dp) {
        float density = getResources().getDisplayMetrics().density;
        return (int) (density * dp + 0.5);
    }

    // px转dp
    public static int px2dp(int px) {
        float density = getResources().getDisplayMetrics().density;
        return (int) (density / px + 0.5);
    }

    // 判断当前线程是否为主线程
    public static boolean isMainThread() {
        return getMainThreadId() == android.os.Process.myTid();

    }

    /**
     * 确保任务(语句)在主线程运行 当前的线程可能是主线程 或者是子线程，但是当前操作UI控件
     */
    public static void runOnMainThread(Runnable r) {
        if (isMainThread()) {
            // 直接执行
            r.run();
        } else {
            getHandler().post(r);
        }

    }

    // 延迟执行任务
    public static void executeTaskDelay(Runnable r, int delay_millis) {
        getHandler().postDelayed(r, delay_millis);
    }

    // 取消任务
    public static void cancelTask(Runnable r) {
        getHandler().removeCallbacks(r);
    }
}
