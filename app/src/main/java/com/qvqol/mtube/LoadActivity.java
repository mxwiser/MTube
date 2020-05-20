package com.qvqol.mtube;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.qvqol.mtube.ui.FirstItem.ImageTask;

public class LoadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.load);
        final Handler handler=new Handler();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<5;i++){
                    ImageTask.loadImageFromNetwork("https://qvqol.com/img.png","ItemImage"+i);

                }
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent i=new Intent(LoadActivity.this,MainActivity.class);
                        startActivity(i);
                        finish();
                    }
                },500);
            }
        }).start();





    }
}
