package com.qvqol.mtube.ui.FirstItem;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class MyLinearImageAd  extends LinearLayout {
    public MyLinearImageAd(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode= View.MeasureSpec.getMode(widthMeasureSpec);
        int width= View.MeasureSpec.getSize(widthMeasureSpec);
        int h= (int) (width*0.5625F);
        heightMeasureSpec= View.MeasureSpec.makeMeasureSpec(h, View.MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
