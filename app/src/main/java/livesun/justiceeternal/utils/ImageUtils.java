package livesun.justiceeternal.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import livesun.justiceeternal.R;
import livesun.justiceeternal.view.CircleDrawable;

/**
 * Created by 29028 on 2017/8/11.
 */

public class ImageUtils {

    public static void setUesrIcon(String url,final ImageView userIcon) {
        //设置二维码
        SimpleTarget target = new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {

                CircleDrawable drawable=new CircleDrawable(UiUtils.getContext().getResources(),resource);
                userIcon.setImageDrawable(drawable);

            }

            @Override
            public void onLoadFailed(Exception e, Drawable errorDrawable) {
                super.onLoadFailed(e, errorDrawable);
                BitmapDrawable bd = (BitmapDrawable) errorDrawable;
                CircleDrawable drawable=new CircleDrawable(UiUtils.getContext().getResources(),bd.getBitmap());
                userIcon.setImageDrawable(drawable);
            }
        };
        Glide.with(UiUtils.getContext())
                .load(url)
                .asBitmap()
                .error(R.drawable.user_avater)
                .into(target);

    }


    public static void setImg(String url, ImageView imageView){
        Glide.with(UiUtils.getContext())
                .load(url)
                .error(R.drawable.user_avater)
                .into(imageView);

    }
}
