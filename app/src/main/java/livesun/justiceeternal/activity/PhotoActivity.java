package livesun.justiceeternal.activity;

import android.graphics.Color;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import livesun.justiceeternal.R;
import livesun.justiceeternal.adapter.PictureBrowsingAdapter;
import livesun.justiceeternal.base.BaseActivity;
import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * 类描述：
 * 创建人：livesun
 * 创建时间：2017/12/25.
 * 修改人：
 * 修改时间：
 * github：https://github.com/livesun
 */
public class PhotoActivity extends BaseActivity implements PhotoViewAttacher.OnPhotoTapListener{
    private List<String> imges;
    private TextView tvNumber;
    private ViewPager mViewPager;
    private PhotoView mPhotoView;
    private List<View> listViews;
    private PictureBrowsingAdapter mAdapter;
    private int position;
    @Override
    public int getResourcesId() {
        imges = getIntent().getStringArrayListExtra("IMGES");
        position = getIntent().getIntExtra("position", -1);
        return R.layout.activity_picture_browsing;
    }

    @Override
    public void initView() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            getWindow().setStatusBarColor(Color.BLACK);
        }

        tvNumber = findView(R.id.tv_number);//下标
        mViewPager = findView(R.id.viewpager);
        listViews = new ArrayList<>();
        //数组走这个
        initPhotos();
    }

    @Override
    public void initListener() {

    }

    @Override
    public void onClick(View v, int id) {

    }

    /**
     * 集合
     */
    private void initPhotos() {
        for(int i=0;i<imges.size();i++){
            LinearLayout view=new LinearLayout(this);
            view.setBackgroundColor(Color.BLACK);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT
            );
            mPhotoView=new PhotoView(this);
            view.addView(mPhotoView);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) mPhotoView.getLayoutParams();
            layoutParams.height=LinearLayout.LayoutParams.MATCH_PARENT;
            layoutParams.weight=LinearLayout.LayoutParams.MATCH_PARENT;
            layoutParams.gravity= Gravity.CENTER;
            mPhotoView.setLayoutParams(layoutParams);
            mPhotoView.setOnPhotoTapListener(this);
            if(!TextUtils.isEmpty((imges.get(i)))){
                Glide.with(this)
                        .load((imges.get(i)))
                        .into(mPhotoView);

            }
            listViews.add(view);
        }
        if(position==-1){
            tvNumber.setText(String.valueOf(1) + "/" + String.valueOf(imges.size()));
        }else{
            tvNumber.setText(String.valueOf(position+1) + "/" + String.valueOf(imges.size()));
        }

        mAdapter = new PictureBrowsingAdapter(listViews,0);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOnPageChangeListener(new PageChangeListener());
        if(position!=-1){
            mViewPager.setCurrentItem(position);
        }

    }

    @Override
    public void onPhotoTap(View view, float x, float y) {
        finish();

    }

    @Override
    public void onOutsidePhotoTap() {

    }

    private class PageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageSelected(int arg0) {
            tvNumber.setText(String.valueOf(arg0 + 1) + "/" + String.valueOf(imges.size()));

        }

    }
}
