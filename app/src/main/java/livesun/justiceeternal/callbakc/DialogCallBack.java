package livesun.justiceeternal.callbakc;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.Window;

import com.lzy.okgo.callback.AbsCallback;
import com.lzy.okgo.request.BaseRequest;

import livesun.justiceeternal.utils.ToastUtil;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/1/7.
 */

public abstract class DialogCallBack <T> extends AbsCallback<T> {
    public ProgressDialog dialog;

    private void initDialog(Context context, String message) {
        dialog = new ProgressDialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(false);//不可取消
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage(message);
    }

    public DialogCallBack(Context context, String message) {
        super();
        initDialog(context,message);
    }

    public DialogCallBack(){

    }

    @Override
    public void onError(Call call, Response response, Exception e) {
        super.onError(call, response, e);
        if(e.getMessage()==null){
            ToastUtil.showShort("服务器链接超时");
            return;
        }
        if(e.getMessage().equals("-1000")){
            //获取token不
            getToken(dialog);
        }else if(e.getMessage().equals("-1001")){
            //判断有没有rembToken 没有调退出接口    有直接调登陆接口
            //退出登陆的接口
            loginAgain(dialog);

        }else if(e.getMessage().equals("6000")){
            //不展示
        }else if(e.getMessage().equals("-7001")){
            //订单轮询
        } else {
            ToastUtil.showShort(e.getMessage());
        }
    }

    protected abstract void loginAgain(ProgressDialog dialog) ;


    protected abstract void getToken(ProgressDialog dialog);

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
