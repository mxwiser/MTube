package com.qvqol.mtube.ui.FirstItem;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.qvqol.mtube.R;


public class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView textView;

    public MyLinearImage myLinearImage;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        textView=itemView.findViewById(R.id.textItem);
        myLinearImage=itemView.findViewById(R.id.limage);

    }
    public void OnBindUI(VItem vItem, int pos, Context context){
        textView.setText(vItem.title);
        glideLoadDrawload(context,vItem.imgUrl);
        //loadDrawload(pos,vItem.imgUrl);
    }


    public  void  glideLoadDrawload(Context context,String url){
        Glide.with(context).load(url).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                myLinearImage.setBackground(resource);
            }
        });
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
