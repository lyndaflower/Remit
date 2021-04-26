package com.example.moniremit_project.models;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.moniremit_project.R;

public class RegistrationActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    Button next, skip;
    private int[] layouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        viewPager = (ViewPager) findViewById(R.id.view_pager);
        next = (Button) findViewById(R.id.btn_next);
        layouts = new int[]
                {R.layout.page1, R.layout.page2, R.layout.page3, R.layout.page4};
        viewPagerAdapter = new ViewPagerAdapter();
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(viewListener);

        next.setOnClickListener(view -> {
            int current = getItem(+1);
            if (current < layouts.length) {
                viewPager.setCurrentItem(current);
            } else {
                AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                dialog.setMessage("Your request has been submitted successfully,You will receive an SMS confirming your login PIN shortly.");
                dialog.setTitle("Thank you!");
                dialog.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                Toast.makeText(getApplicationContext(),"Thank you for registering",Toast.LENGTH_LONG).show();
                                Intent reset= new Intent(RegistrationActivity.this,Verification_codeActivity.class);
                                startActivity(reset);
                                finish();
                            }
                        });
                dialog.setNegativeButton("cancel",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"Request cancelled",Toast.LENGTH_LONG).show();
                    }
                });
                AlertDialog alertDialog=dialog.create();
                alertDialog.show();
            }
        });

    }

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            if (position == layouts.length - 1) {
                next.setText("Register");
//                skip.setVisibility(View.GONE);
            } else {
                next.setText("Continue");
//                skip.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

//    private void changeStatusBarColor() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            Window window = getWindow();
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.setStatusBarColor(Color.TRANSPARENT);
//        }
//    }

    //PagerAdapter class which will inflate our sliders in our ViewPager
    public class ViewPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;

        @Override
        public Object instantiateItem(ViewGroup myContainer, int mPosition) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = layoutInflater.inflate(layouts[mPosition], myContainer, false);
            myContainer.addView(v);
            return v;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View mView, Object mObject) {
            return mView == mObject;
        }

        @Override
        public void destroyItem(ViewGroup mContainer, int mPosition, Object mObject) {
            View v = (View) mObject;
            mContainer.removeView(v);
        }
    }
}