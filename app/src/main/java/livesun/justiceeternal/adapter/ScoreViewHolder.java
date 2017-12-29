package livesun.justiceeternal.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import livesun.justiceeternal.R;
import livesun.justiceeternal.view.BadgeView;
import zlc.season.practicalrecyclerview.AbstractViewHolder;

/**
 * Created by 29028 on 2017/8/10.
 */

public class ScoreViewHolder extends AbstractViewHolder<ItemsBean> {

    private final TextView title;
    private final LinearLayout container;
    private final ViewGroup parent;
    private final Context context;

    public ScoreViewHolder(ViewGroup parent, Context context) {
        super(parent, R.layout.score_item_list);
        this.parent = parent;
        this.context = context;
        title = (TextView) itemView.findViewById(R.id.title);

        container = (LinearLayout) itemView.findViewById(R.id.container);
    }

    @Override
    public void setData(ItemsBean data) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(10,0,0,0);
        container.removeAllViews();

        title.setText(data.getTitle());
        container.addView(title);


        List<ScoreBean.LabelsBean> labels =
                data.getLabels();
        if(labels!=null){
            int size = labels.size();
            for(int i=0;i<size;i++){
                BadgeView  badgeView=new BadgeView(context);
                badgeView.setText(labels.get(i).getName());
                badgeView.setBadgeBackgroundColor(Color.parseColor("#"+labels.get(i).getColor()));
                badgeView.setLayoutParams(layoutParams);
                badgeView.setTextSize(12);
                badgeView.setTextColor(Color.parseColor("#232323"));
                container.addView(badgeView);
            }
        }

    }
}
