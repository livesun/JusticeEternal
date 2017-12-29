package livesun.justiceeternal.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * 类描述：
 * 创建人：livesun
 * 创建时间：2017/12/25.
 * 修改人：
 * 修改时间：
 * github：https://github.com/livesun
 */
public class PictureBrowsingAdapter extends PagerAdapter {
        private List<View> list;
        private int thePosition;
        public PictureBrowsingAdapter(){

        }

        public PictureBrowsingAdapter(List<View> list,int thePosition) {
            this.list = list;
            this.thePosition=thePosition;
        }

        @Override
        public int getCount() {

            if (list != null && list.size() > 0) {
                return list.size();
            } else {
                return 0;
            }
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
        /*list.get(position);
        */
            container.addView(list.get(position ));
            return list.get(position);
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }

}
