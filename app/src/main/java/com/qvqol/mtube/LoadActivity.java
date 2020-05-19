package com.qvqol.mtube;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setTheme(R.style.AppTheme);
        this.getSupportActionBar().hide();
        setContentView(R.layout.load);
        Handler handler=new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(LoadActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        },1000);
    }
}
