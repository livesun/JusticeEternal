package livesun.justiceeternal.base;

import android.view.View;

/**
 * 界面操作方法封装
 */
public interface IUIOperation extends View.OnClickListener{

    /** 返回activity的布局文件 */
    int getResourcesId();

    /** 查找子控件 */
    void initView();

    /** 初始化监听器 */
    void initListener();

    /**
     * 子类处理点击事件
     * @param v
     * @param id 点击的控件id
     */
    void onClick(View v, int id);
}
