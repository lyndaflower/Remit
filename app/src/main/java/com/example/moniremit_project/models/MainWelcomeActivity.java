package com.example.moniremit_project.models;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.example.moniremit_project.R;
import com.example.moniremit_project.adapter.PrefAdapter;

import java.util.HashMap;

import static com.daimajia.slider.library.SliderTypes.BaseSliderView.*;

public class MainWelcomeActivity extends AppCompatActivity implements OnSliderClickListener,
        ViewPagerEx.OnPageChangeListener {

    SliderLayout sliderLayout;

    HashMap<String, String> HashMapForURL;

    HashMap<String, Integer> HashMapForLocalRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sliderLayout = (SliderLayout) findViewById(R.id.slider);

        //Call this method if you want to add images from URL .
        AddImagesUrlOnline();

        //Call this method to add images from local drawable folder .
        //AddImageUrlFormLocalRes();

        //Call this method to stop automatic sliding.
        //sliderLayout.stopAutoCycle();

        for (String name : HashMapForURL.keySet()) {

            TextSliderView textSliderView = new TextSliderView(MainWelcomeActivity.this);

            textSliderView
                    .description(name)
                    .image(HashMapForURL.get(name))
                    .setScaleType(ScaleType.Fit)
                    .setOnSliderClickListener(this);

            textSliderView.bundle(new Bundle());

            textSliderView.getBundle()
                    .putString("extra", name);

            sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.DepthPage);

        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);

        sliderLayout.setCustomAnimation(new DescriptionAnimation());

        sliderLayout.setDuration(3000);

        sliderLayout.addOnPageChangeListener(MainWelcomeActivity.this);
    }

    @Override
    protected void onStop() {

        sliderLayout.stopAutoCycle();

        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

        Toast.makeText(this, slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {

        Log.d("Slider Demo", "Page Changed: " + position);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public void AddImagesUrlOnline() {

        HashMapForURL = new HashMap<String, String>();

        HashMapForURL.put("CupCake", "https://s3.amazonaws.com/tc-global-prod/uploaded_images/ca/images/5030/original/Support_Young_African_Professional.jpg");
        HashMapForURL.put("Donut", "https://cdn.24.co.za/files/Cms/General/d/8061/3066229472314b4e9b9ee2a5437f1f3f.jpg");
        HashMapForURL.put("Eclair", "https://www.itnewsafrica.com/wp-content/uploads/2018/07/business-people.jpg");
        HashMapForURL.put("Froyo", "https://www.africa-business.com/pics2/pics2016/african-business.jpg");
        HashMapForURL.put("GingerBread", "http://st.depositphotos.com/1011643/3411/i/450/depositphotos_34115809-African-business-people-handshaking.jpg");
    }

    public void AddImageUrlFormLocalRes() {

        HashMapForLocalRes = new HashMap<String, Integer>();

        HashMapForLocalRes.put("CupCake", R.drawable.img1);
        HashMapForLocalRes.put("Donut", R.drawable.img2);

    }
}