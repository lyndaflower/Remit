package com.example.moniremit_project.models;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.example.moniremit_project.R;
import com.example.moniremit_project.adapter.CustomViewPagerAdapter;

public class MainWelcomeActivity extends AppCompatActivity implements View.OnClickListener {
    private static final long SLIDER_TIMER = 2000; // change slider interval
    private int currentPage = 0; // this will tell us the current page available on the view pager
    // please see ViewPager Listener on the onPageSelected method to see how we are updating
// currentPage variable
    Button mGetStarted;
    Button mRegister;

    private boolean isCountDownTimerActive = false; // let the timer start if and only if it has completed previous task

    private Handler handler;
    private ViewPager viewPager;

    private final Runnable runnable = new Runnable() {
        @Override
        public void run() {

            if (!isCountDownTimerActive) {
                automateSlider();
            }

            handler.postDelayed(runnable, 1000);
// our runnable should keep running for every 1000 milliseconds (1 seconds)
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_welcome);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        handler = new Handler();

        mGetStarted = (Button) findViewById(R.id.btn_start);
        mRegister = (Button) findViewById(R.id.register_btn);

        mGetStarted.setOnClickListener(this);
        mRegister.setOnClickListener(this);

        handler.postDelayed(runnable, 1000);
        runnable.run();

        viewPager = findViewById(R.id.view_pager_slider);

        CustomViewPagerAdapter viewPagerAdapter = new CustomViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);

// now it’s time to think about our sliders

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    currentPage = 0;
                } else if (position == 1) {
                    currentPage = 1;
                } else {
                    currentPage = 2;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


    private void automateSlider() {
        isCountDownTimerActive = true;
        new CountDownTimer(SLIDER_TIMER, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {

                int nextSlider = currentPage + 1;

                if (nextSlider == 3) {
                    nextSlider = 0; // if it’s last Image, let it go to the first image
                }

                viewPager.setCurrentItem(nextSlider);
                isCountDownTimerActive = false;
            }
        }.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
// Kill this background task once the activity has been killed
        handler.removeCallbacks(runnable);
    }

    @Override
    public void onClick(View v) {
        if (v == mGetStarted) {
            Intent start = new Intent(MainWelcomeActivity.this, LoginActivity.class);
            startActivity(start);
        }
        if ( v == mRegister){
            Intent register = new Intent(MainWelcomeActivity.this,RegistrationActivity.class);
            startActivity(register);
        }
    }
}

