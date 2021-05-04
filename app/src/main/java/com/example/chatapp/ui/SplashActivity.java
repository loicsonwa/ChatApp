package com.example.chatapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.chatapp.R;
import com.example.chatapp.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {
    
    ActivitySplashBinding binding;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        binding.setLogoRes(R.drawable.logo_no_icon);
        
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.transition);
        binding.logoImageView.setAnimation(anim);
        
        final Intent intent = new Intent(this, HomeActivity.class);
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                binding.logoImageView.setAnimation(anim);
            }
        });
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
    
                final Intent intent = new Intent(SplashActivity.this, AuthentificationActivity.class);
    
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View, String>(binding.lottieAnimSplash, "LogoTransition");
                pairs[1] = new Pair<View, String>(binding.logoImageView, "LogoTransition");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SplashActivity.this ,pairs);
                startActivity(intent, options.toBundle());
            }
        },4000);
        
        
        
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding.lottieAnimSplash.cancelAnimation();
    }
    
    @Override
    protected void onStart() {
        super.onStart();
        binding.lottieAnimSplash.playAnimation();
    }
    
}