package livesun.justiceeternal.base;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import livesun.justiceeternal.R;

/**
 * Created by Administrator on 2017/2/7.
 */

public  abstract class BaseActivity extends AppCompatActivity implements IUIOperation {
    private TextView tvTitle;
    boolean isToDeletStatus=false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(deleteStatus()){
            if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.KITKAT
                    && Build.VERSION.SDK_INT< Build.VERSION_CODES.LOLLIPOP
                    ){
                //删除状态栏
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            }
        }
            setContentView(getResourcesId());
            initView();
            initListener();
    }

    /**
     * 钩子方法 删除状态栏
     * @return
     */
    protected boolean deleteStatus(){
        return isToDeletStatus;
    }
    /**
     * 设置Activity界面标题
     *
     * @param title
     */
    public void setPageTitle(String title) {
        tvTitle= findView(R.id.tv_title);
        findViewId(R.id.iv_back).setOnClickListener(this);

        if (tvTitle != null) {
            tvTitle.setText(title);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_back:
                onBackPressed();
                break;
            default:
//                其它点击事件
                onClick(view,view.getId());
                break;
        }
    }



    /** 查找子控件，可以省略强转操作 */
    public <T> T findView(int id) {
        T view = (T) findViewById(id);
        return view;
    }


    protected <Z extends View> Z findViewId(int id) {
        //return返回view时,加上泛型T
        return (Z)findViewById(id);
    }

}
