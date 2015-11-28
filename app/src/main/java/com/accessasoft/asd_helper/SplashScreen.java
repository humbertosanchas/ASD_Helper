package com.accessasoft.asd_helper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

/**
 * Created by Paul Boyko on 11/27/2015.
 */
public class SplashScreen extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

        int secondsDelay = 2;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this, MainActivity.class));
                overridePendingTransition(R.anim.abc_fade_in,R.anim.abc_fade_out);
            }
        }, secondsDelay * 1000);
    }
}
