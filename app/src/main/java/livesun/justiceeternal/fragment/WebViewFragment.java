package livesun.justiceeternal.fragment;

import android.graphics.Bitmap;
import android.graphics.PixelFormat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import livesun.justiceeternal.R;
import livesun.justiceeternal.base.BaseFragment;
import livesun.justiceeternal.view.X5WebView;

/**
 * 类描述：
 * 创建人：livesun
 * 创建时间：2017/12/25.
 * 修改人：
 * 修改时间：
 * github：https://github.com/livesun
 */
public class WebViewFragment extends BaseFragment{
    private X5WebView mWebView;
    private ProgressBar mProgressBar;

    //http://jefun.top/#/recommond

    @Override
    public int getResourcesId() {
        return R.layout.fragment_web;
    }

    @Override
    public void initView() {
        getActivity().getWindow().setFormat(PixelFormat.TRANSLUCENT);
        mWebView = findView(R.id.webview);
        WebSettings webSetting = mWebView.getSettings();
        webSetting.setAppCacheEnabled(true);
        webSetting.setAppCachePath(getActivity().getDir("appcache", 0).getPath());
        webSetting.setDatabasePath(getActivity().getDir("databases", 0).getPath());
        webSetting.setGeolocationDatabasePath(getActivity().getDir("geolocation", 0)
                        .getPath());

        mWebView.loadUrl("http://jefun.top/#/recommond");
        mProgressBar = findView(R.id.progress_bar);
        mWebView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageStarted(WebView webView, String s, Bitmap bitmap) {
                super.onPageStarted(webView, s, bitmap);
                mProgressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                mProgressBar.setVisibility(View.GONE);
            }

        });

        mWebView.setWebChromeClient(new WebChromeClient() {

            @Override
            public boolean onJsConfirm(WebView arg0, String arg1, String arg2,
                                       JsResult arg3) {
                return super.onJsConfirm(arg0, arg1, arg2, arg3);
            }

            @Override
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                mProgressBar.setProgress(i);
            }

            View myVideoView;
            View myNormalView;
            IX5WebChromeClient.CustomViewCallback callback;

            // /////////////////////////////////////////////////////////
            //
            /**
             * 全屏播放配置
             */
            @Override
            public void onShowCustomView(View view,
                                         IX5WebChromeClient.CustomViewCallback customViewCallback) {
                FrameLayout normalView =  findView(R.id.webview);
                ViewGroup viewGroup = (ViewGroup) normalView.getParent();
                viewGroup.removeView(normalView);
                viewGroup.addView(view);
                myVideoView = view;
                myNormalView = normalView;
                callback = customViewCallback;
            }

            @Override
            public void onHideCustomView() {
                if (callback != null) {
                    callback.onCustomViewHidden();
                    callback = null;
                }
                if (myVideoView != null) {
                    ViewGroup viewGroup = (ViewGroup) myVideoView.getParent();
                    viewGroup.removeView(myVideoView);
                    viewGroup.addView(myNormalView);
                }
            }

            @Override
            public boolean onJsAlert(WebView arg0, String arg1, String arg2,
                                     JsResult arg3) {
                /**
                 * 这里写入你自定义的window alert
                 */
                return super.onJsAlert(null, arg1, arg2, arg3);
            }
        });



    }

    @Override
    public void initListener() {

    }

    @Override
    public void onClick(View v, int id) {

    }

    public boolean goBack() {
        boolean flag=false;

        if(mWebView.canGoBack()){
            mWebView.goBack();
            flag=true;
        }

        return flag;
    }
}
