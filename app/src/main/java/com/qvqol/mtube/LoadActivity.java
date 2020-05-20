package com.qvqol.mtube;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.qvqol.mtube.ui.FirstItem.ImageTask;

public class LoadActivity extends AppCompatActivity {
    Handler handler;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
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

    private  void loadMainItemImage(){
        for (int i=0;i<5;i++){
            ImageTask.loadImageFromNetwork("https://qvqol.com/img.png","ItemImage"+i);
        }
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
