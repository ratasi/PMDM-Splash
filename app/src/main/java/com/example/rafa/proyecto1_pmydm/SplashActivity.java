package com.example.rafa.proyecto1_pmydm;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import java.util.*;

/**
 * Created by Rafa on 13/11/2017.
 */

public class SplashActivity extends Activity{
        private long SPLASH_DELAY = 3000; //6 segundos

        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splash);
            //TimerTask
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    Intent mainIntent = new Intent(getApplicationContext(),
                            MenuActivity.class);
                    startActivity(mainIntent);
                    //Destruimos esta activity para prevenir
                    // que el usuario vuelva a este Activity presionando el boton
                    // Atras.
                    finish();
                }
            };
            Timer timer = new Timer();
            timer.schedule(task, SPLASH_DELAY);
        }
    }

