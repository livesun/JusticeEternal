package livesun.justiceeternal.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gesangdianzi on 2016/9/5.
 */
public abstract class GMBaseAdapter<T> extends BaseAdapter {
    protected List<T> list=new ArrayList<T>();



    //添加多条数据，集合数据
    public void addDatas(List<T> datas){
        list=datas;
        notifyDataSetChanged();
    }
    //添加单条数据
    public void addData(T data){
        list.add(data);
        notifyDataSetChanged();
    }

    //清除所有数据，清除集合数据
    public void clear(){
        list.clear();
        notifyDataSetChanged();
    }

    //取得某条数据
    public T getData(int position){
        return list.get(position);
    }
    //取得所有数据，取得集合的数据
    public List<T> getDatas(){
        return list;
    }

    @Override
    public int getCount() {
        return list==null?0:list.size();

    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    /**
     * 取得当前要展示的列表条目的视图
     * 1. 装配列表项的视图
     * 2. 填充数据到列表项子控件中
     */
    @Override
    public abstract View getView(int position, View convertView, ViewGroup parent);


}
