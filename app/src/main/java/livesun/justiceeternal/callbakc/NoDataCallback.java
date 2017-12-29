package livesun.justiceeternal.callbakc;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.Window;

import com.google.gson.stream.JsonReader;
import com.lzy.okgo.callback.AbsCallback;
import com.lzy.okgo.request.BaseRequest;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import livesun.justiceeternal.utils.Convert;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/1/10.
 */

public abstract class NoDataCallback<T> extends AbsCallback<T> {

    public ProgressDialog dialog;

    private void initDialog(Context context, String message) {
        dialog = new ProgressDialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(false);//不可取消
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage(message);
    }

    public NoDataCallback(Context context, String message) {
        super();
        initDialog(context,message);
    }

    @Override
    public T convertSuccess(Response response) throws Exception {
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        Type type = params[0];
        JsonReader jsonReader = new JsonReader(response.body().charStream());
        T data = Convert.fromJson(jsonReader, type);
        response.close();


        return data;
    }
    @Override
    public void onBefore(BaseRequest request) {
        super.onBefore(request);
        //网络请求前显示对话框
        if (dialog != null && !dialog.isShowing()) {
            dialog.show();
        }
    }

    @Override
    public void onAfter(@Nullable T t, @Nullable Exception e) {
        super.onAfter(t, e);
        //网络请求结束后关闭对话框
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

}
