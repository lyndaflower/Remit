package com.example.moniremit_project.models;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.moniremit_project.MainActivity;
import com.example.moniremit_project.R;

public class SplashActivity extends AppCompatActivity {

    private ImageView logo;
    private static int splashTimeout=5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        logo=(ImageView)findViewById(R.id.logo);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        },splashTimeout);

        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.splash_anim);
        logo.startAnimation(myanim);
    }
}