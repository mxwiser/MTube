package com.qvqol.mtube.ui.FirstItem;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;

public class ImageTask extends AsyncTask<String,Void, Drawable> {
    private Listener mListener;
    @Override
    protected Drawable doInBackground(String... strings) {
        String url=strings[0];
        Drawable drawable=getDrawable(url);
        return drawable;
    }
    public Drawable getDrawable(String url){

    }
    public interface Listener{
        void onSuccess(Drawable drawable);
    }

    @Override
    protected void onPostExecute(Drawable drawable) {
        mListener.onSuccess(drawable);
    }
}
