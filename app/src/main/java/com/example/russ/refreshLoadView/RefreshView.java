package com.example.russ.refreshLoadView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by russ on 18-4-2.
 * 刷新的箭头 朝上
 */

public class RefreshView extends View {
    private int mWidth;
    private int mHeight;

    public RefreshView(Context context) {
        super(context);
    }

    public RefreshView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RefreshView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mHeight=getMeasuredHeight();
        mWidth=getMeasuredWidth();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //向上的箭头

        @SuppressLint("DrawAllocation") Paint paint=new Paint();
         paint.setStrokeWidth(5);
         paint.setStyle(Paint.Style.STROKE);
         paint.setColor(Color.parseColor("#E0E0E0"));
         canvas.drawLine(mWidth/2,0,mWidth/2,mHeight,paint);
         canvas.drawLine(0,mHeight,mWidth,mHeight,paint);
         canvas.drawLine(mWidth/2,mHeight, (float) (mWidth/2-mHeight/4),2*mHeight/3,paint);
         canvas.drawLine(mWidth/2,mHeight, (float) (mWidth/2+mHeight/4),2*mHeight/3,paint);




    }
}
