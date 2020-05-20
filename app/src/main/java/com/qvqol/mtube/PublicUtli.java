package com.qvqol.mtube;

import android.content.Context;

import com.bumptech.glide.Glide;

public class PublicUtli {

    //清楚Glide的内存缓存和磁盘缓存
    public static void clearGlideCache(Context context){
        Glide.get(context).clearDiskCache();
        Glide.get(context).clearMemory();
    }


}
