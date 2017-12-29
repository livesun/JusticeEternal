package livesun.justiceeternal.base;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.util.Log;

import com.tencent.smtt.sdk.QbSdk;

/**
 * Created by 29028 on 2017/8/11.
 */

public class JEApp extends Application {
    // 线程通信
    private static Handler handler;
    // 主线程
    private static Thread mainThread;
    // 主线程id
    private static int mainThreadId;
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this.getApplicationContext();
        handler = new Handler();
        mainThread = Thread.currentThread();
        mainThreadId = android.os.Process.myTid();

        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {

            @Override
            public void onViewInitFinished(boolean arg0) {
                // TODO Auto-generated method stub
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
                Log.d("app", " onViewInitFinished is " + arg0);
            }

            @Override
            public void onCoreInitFinished() {
                // TODO Auto-generated method stub
            }
        };
        //x5内核初始化接口
        QbSdk.initX5Environment(getApplicationContext(),  cb);
    }

    public static Context getContext(){
        return context;
    }
    public static Handler getHandler() {
        return handler;
    }

    public static Thread getMainThread() {
        return mainThread;
    }
    public static int getMainThreadId() {
        return mainThreadId;
    }
}
