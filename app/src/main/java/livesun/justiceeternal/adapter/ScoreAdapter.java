package livesun.justiceeternal.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import zlc.season.practicalrecyclerview.AbstractAdapter;
import zlc.season.practicalrecyclerview.AbstractViewHolder;

/**
 * Created by 29028 on 2017/8/10.
 */

public class ScoreAdapter extends AbstractAdapter<ItemsBean,AbstractViewHolder> {

    private Context context;
    private OnItemClickListener itemClickListener;

    public ScoreAdapter(Context context){

        this.context = context;
    }
    @Override
    protected AbstractViewHolder onNewCreateViewHolder(ViewGroup parent, int viewType) {
        return new ScoreViewHolder(parent,context);
    }

    @Override
    protected void onNewBindViewHolder(AbstractViewHolder holder, final int position) {
        holder.setData(get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(itemClickListener!=null){
                   itemClickListener.itemClick(position,get(position));
               }
            }
        });
    }

    public interface OnItemClickListener{
        void itemClick(int position,ItemsBean scoreBean);
    }

    public void setOnItemClickListener(OnItemClickListener itemClickListener){

        this.itemClickListener = itemClickListener;
    }
}
