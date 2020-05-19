package com.qvqol.mtube.ui.FirstItem;


import android.graphics.drawable.Drawable;
import android.util.LruCache;

public final class CacheHelper {

    public static LruCache<String, Drawable> sLruCache;

    static {
        sLruCache = new LruCache<String, Drawable>((int) Runtime.getRuntime().maxMemory() / 4) {


        };
    }

}