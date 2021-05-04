package com.example.chatapp.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.chatapp.ui.fragments.OnboardingFragmentOne;
import com.example.chatapp.ui.fragments.OnboardingFragmentThree;
import com.example.chatapp.ui.fragments.OnboardingFragmentTwo;

public class OnboardingAdapter extends FragmentPagerAdapter {
    
    private final static int NUM_PAGES = 3;
    public OnboardingAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }
    
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:return new OnboardingFragmentOne();
            case 1:return new OnboardingFragmentTwo();
            case 2:return new OnboardingFragmentThree();
        }
        return null;
    }
    
    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}
