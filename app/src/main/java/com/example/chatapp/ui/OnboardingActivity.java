package com.example.chatapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.chatapp.R;
import com.example.chatapp.adapters.OnboardingAdapter;
import com.example.chatapp.databinding.ActivityOnboardingBinding;

public class OnboardingActivity extends AppCompatActivity {
    
    ActivityOnboardingBinding binding;
    OnboardingAdapter onboardingAdapter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_onboarding);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        setupViewpager();
        binding.dotsIndicators.setViewPager(binding.onboardingViewpager);
     
    }
    
    public void openHomePage(View view) {
        Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show();
    }
    public void setupViewpager(){
        onboardingAdapter = new OnboardingAdapter(getSupportFragmentManager(), 1);
        binding.onboardingViewpager.setAdapter(onboardingAdapter);
    }
}