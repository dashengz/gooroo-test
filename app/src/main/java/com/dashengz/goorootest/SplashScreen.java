package com.dashengz.goorootest;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class SplashScreen extends AppCompatActivity {

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getWindow().setFormat(PixelFormat.RGBA_8888);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();
        animate();
    }

    private void animate() {
        reanimate(R.anim.alpha, R.id.linear_layout);
        reanimate(R.anim.translate, R.id.splash);

        (new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    // Pause for 5 secs
                    while (waited < 5000) {
                        sleep(100);
                        waited += 100;
                    }
                    Intent intent = new Intent(SplashScreen.this,
                            MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    SplashScreen.this.finish();
                } catch (InterruptedException e) {
                    // Do nothing
                } finally {
                    SplashScreen.this.finish();
                }

            }
        }).start();
    }

    private void reanimate(int animRes, int layoutRes) {
        Animation anim = AnimationUtils.loadAnimation(this, animRes);
        View view = findViewById(layoutRes);

        anim.reset();
        view.clearAnimation();
        view.startAnimation(anim);
    }

}