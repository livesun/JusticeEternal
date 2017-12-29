package livesun.justiceeternal.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.TextView;

import livesun.justiceeternal.R;

/**
 * Created by 29028 on 2017/8/10.
 */

public class CircleTextView extends TextView {

    private int mBackColor;
    private int mRaduis;
    private Paint mPaint;

    public CircleTextView(Context context) {
        this(context,null);
    }

    public CircleTextView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CircleTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray td = context.obtainStyledAttributes(attrs, R.styleable.CircleTextView);
        mBackColor = td.getColor(R.styleable.CircleTextView_backgroundColor, Color.BLACK);
        mRaduis = td.getDimensionPixelSize(R.styleable.CircleTextView_raduis, -1);
        td.recycle();

        mPaint = new Paint();
        mPaint.setColor(mBackColor);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        setGravity(Gravity.CENTER);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthmode = MeasureSpec.getMode(widthMeasureSpec);
        int heightmode = MeasureSpec.getMode(heightMeasureSpec);
        //都是包裹
        if(widthmode==MeasureSpec.AT_MOST&&heightmode==MeasureSpec.AT_MOST){
            String text = getText().toString();
            Rect rect=new Rect();
            getPaint().getTextBounds(text,0,text.length(),rect);
            int width = rect.width();
            int height = rect.height();
            mRaduis = Math.max(height, width) / 2+5;
        }


    }

    @Override
    protected void onDraw(Canvas canvas) {
        if(mRaduis==-1){
            mRaduis=Math.max(getWidth(),getHeight())/2;
        }
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, mRaduis, mPaint);


        super.onDraw(canvas);

    }
}
