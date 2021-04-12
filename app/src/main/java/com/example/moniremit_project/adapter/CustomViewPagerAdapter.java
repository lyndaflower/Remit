package com.example.moniremit_project.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.moniremit_project.fragments.FragmentSliderOne;
import com.example.moniremit_project.fragments.FragmentSliderThree;
import com.example.moniremit_project.fragments.FragmentSliderTwo;

public class CustomViewPagerAdapter extends FragmentStatePagerAdapter {

    public CustomViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;

        if (position == 0) {
            fragment = new FragmentSliderOne();
        } else if (position == 1) {
            fragment = new FragmentSliderTwo();
        } else {
            fragment = new FragmentSliderThree();
        }

        return fragment;
    }

    @Override
    public int getCount() {
// return the number of your fragments,
// we have 3 fragments
        return 3;
    }
}