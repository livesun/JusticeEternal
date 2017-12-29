package livesun.justiceeternal.fragment;

import livesun.justiceeternal.base.BaseFragment;

/**
 * Created by 29028 on 2017/8/10.
 */

public abstract class VisibleHintFragment extends BaseFragment{
    /** Fragment当前状态是否可见 */
    protected boolean isVisible;

    //setUserVisibleHint  adapter中的每个fragment切换的时候都会被调用，如果是切换到当前页，那么isVisibleToUser==true，否则为false
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }


    /**
     * 可见
     */
    protected void onVisible() {
        initView();
    }


    /**
     * 不可见
     */
    protected void onInvisible() {


    }




}
