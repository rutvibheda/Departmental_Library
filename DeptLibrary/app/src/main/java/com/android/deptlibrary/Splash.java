package com.android.deptlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        Thread mythread=new Thread()
        {
            public void run()
            {
                try
                {
                    sleep(2000);
                    Intent intent=new Intent(Splash.this, AboutUs.class);
                    startActivity(intent);
                    finish();
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
                super.run();
            }
        };
        mythread.start();
    }
}

