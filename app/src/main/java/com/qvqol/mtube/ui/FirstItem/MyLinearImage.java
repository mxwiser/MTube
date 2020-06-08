package com.qvqol.mtube.ui.FirstItem;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class MyLinearImage extends LinearLayout {
    public MyLinearImage(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //int widthMode=MeasureSpec.getMode(widthMeasureSpec);
        int width=MeasureSpec.getSize(widthMeasureSpec);
        int h= (int) (width*0.5625F);
        heightMeasureSpec=MeasureSpec.makeMeasureSpec(h,MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
