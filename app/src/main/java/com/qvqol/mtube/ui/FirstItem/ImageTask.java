package com.qvqol.mtube.ui.FirstItem;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ImageTask extends AsyncTask<String,Void, Drawable> {
    private Listener mListener;

    public ImageTask(Listener listener) {
        mListener=listener;
    }

    @Override
    protected Drawable doInBackground(String... strings) {
        Drawable drawable = loadImageFromNetwork(strings[0],strings[1]);
        return drawable;
    }

    public interface Listener{
        void onSuccess(Drawable drawable);
    }

    @Override
    protected void onPostExecute(Drawable drawable) {
        mListener.onSuccess(drawable);
    }



    public static Drawable loadImageFromNetwork(String imageUrl,String key)
    {
        Drawable drawable = null;
        try {
            // 可以在这里通过文件名来判断，是否本地有此图片
            drawable = Drawable.createFromStream(new URL(imageUrl).openStream(),"itemsrc");
           // CacheHelper.sLruCache.put(key,drawable);
            Log.d("存入图片缓存：",key);
        } catch (IOException e) {
            Log.d("test", e.getMessage());
        }
        return drawable ;
    }

}
