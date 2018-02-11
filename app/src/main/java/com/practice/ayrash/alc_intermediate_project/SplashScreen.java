package com.practice.ayrash.alc_intermediate_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by ibnahmadbello on 8/20/17.
 */

public class SplashScreen extends Activity {

    //Splash screen timer
    //private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.splash_activity);

//        new Handler().postDelayed(new Runnable(){
//            /*
//            Showing splash screen with a timer.
//             */
//            @Override
//            public void run(){
//                //This method will start once the timer is over
//                //It will start the main activity
//                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
//                startActivity(intent);
//
//                finish();
//
//            }
//        }, SPLASH_TIME_OUT);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }

}
