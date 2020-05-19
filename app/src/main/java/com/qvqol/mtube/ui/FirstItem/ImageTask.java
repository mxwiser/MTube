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
        String url=strings[0];
        Drawable drawable= null;
        try {
            drawable = getDrawable(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return drawable;
    }
    public Drawable getDrawable(String url) throws IOException {

     return   loadImageFromNetwork(url);
    }
    public interface Listener{
        void onSuccess(Drawable drawable);
    }

    @Override
    protected void onPostExecute(Drawable drawable) {
        mListener.onSuccess(drawable);
    }



    private Drawable loadImageFromNetwork(String imageUrl)
    {
        Drawable drawable = null;
        try {
            // 可以在这里通过文件名来判断，是否本地有此图片
            drawable = Drawable.createFromStream(
                    new URL(imageUrl).openStream(), "image.jpg");
        } catch (IOException e) {
            Log.d("test", e.getMessage());
        }
        if (drawable == null) {
            Log.d("test", "null drawable");
        } else {
            Log.d("test", "not null drawable");
        }

        return drawable ;
    }

}
