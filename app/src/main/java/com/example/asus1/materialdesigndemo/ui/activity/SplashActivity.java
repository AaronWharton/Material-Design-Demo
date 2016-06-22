package com.example.asus1.materialdesigndemo.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.asus1.materialdesigndemo.R;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        /**
         * 开启动画效果
         */
        FrameLayout splash = (FrameLayout) findViewById(R.id.splash_background);
        Animation splashBackground = AnimationUtils.loadAnimation(this, R.anim.splash_background);
        splash.setAnimation(splashBackground);

        ImageView logo = (ImageView) findViewById(R.id.logo);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.logo_animation);
        logo.setAnimation(animation);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 3000);
    }
}
