package com.qvqol.mtube.ui.FirstItem;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.qvqol.mtube.R;


public class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView textView;

    public MyLinearImage myLinearImage;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        textView=itemView.findViewById(R.id.textItem);
        myLinearImage=itemView.findViewById(R.id.limage);

    }
    public void OnBindUI(VItem vItem,int pos){
        textView.setText(vItem.title);
        loadDrawload(pos,vItem.imgUrl);
    }
    public void  loadDrawload(final int position, String imgUrl){
        Drawable drawable=CacheHelper.sLruCache.get("ItemImage"+position);
        if (drawable==null){
            new ImageTask(new ImageTask.Listener() {
                @Override
                public void onSuccess(Drawable drawable) {
                   myLinearImage.setBackground(drawable);
                }
            }).execute(imgUrl,"ItemImage"+position);
        }else {

            Log.e("从缓存中找到图片","ItemImage"+position);
           myLinearImage.setBackground(drawable);
        }
    }
}
