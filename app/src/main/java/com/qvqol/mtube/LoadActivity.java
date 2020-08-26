package com.qvqol.mtube;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;

import java.util.concurrent.ExecutionException;

public class LoadActivity extends AppCompatActivity {
    Handler handler;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        loadLCHImage();
        setContentView(R.layout.load);
        handler=new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
               loadMainItemImage();
               startMain();
            }
        }).start();
    }
    //图片预加载
    private  void loadMainItemImage(){
        Glide.with(LoadActivity.this).load("https://qvqol.com/xzpq.png").preload();
    }
    //启动图预加载
    private  void loadLCHImage(){
     Glide.with(getApplicationContext()).asGif().load("").into(new ImageView(getApplicationContext()));
    }
    private void  startMain(){
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(LoadActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        },500);
    }
}
