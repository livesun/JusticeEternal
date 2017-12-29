package livesun.justiceeternal.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import livesun.justiceeternal.R;

/**
 * Created by 29028 on 2017/8/10.
 */

public abstract class BaseFragment extends Fragment implements IUIOperation{

    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if(rootView==null){
            rootView = inflater.inflate(getResourcesId(), container, false);
            initView();
            initListener();
        }
        return rootView;

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_back:
                getActivity().finish();
                break;
            default:
//                其它点击事件
                onClick(view,view.getId());
                break;
        }
    }


    public String getChars(View name){

        if(name instanceof TextView){
            return ((TextView) name).getText().toString().trim();
        }
        else if(name instanceof EditText){
            return((EditText) name).getText().toString().trim();
        }else {
            return null;
        }

    }

    protected <Z extends View> Z findView(int id) {
        //return返回view时,加上泛型T
        return (Z)rootView.findViewById(id);
    }
}
