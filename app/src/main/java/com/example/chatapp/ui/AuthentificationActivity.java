package com.example.chatapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;

import com.example.chatapp.R;
import com.example.chatapp.databinding.ActivityAuthentificationBinding;

public class AuthentificationActivity extends AppCompatActivity {
    ActivityAuthentificationBinding binding;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_authentification);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        
        
       
    }
    
    public void startHomePage(View view) {
        startActivity(new Intent(AuthentificationActivity.this, MenuActivity.class));
    }
    
    public void startRegisterActivity(View view) {
        final Intent intent = new Intent(AuthentificationActivity.this, RegisterActivity.class);
    
        Pair[] pairs = new Pair[3];
        pairs[0] = new Pair<View, String>(binding.logInChoiceButton, "anim1");
        pairs[1] = new Pair<View, String>(binding.lottieAnimSplash, "LogoTransition");
        pairs[2] = new Pair<View, String>(binding.logoImageView, "LogoTransition");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(AuthentificationActivity.this ,pairs);
        startActivity(intent, options.toBundle());
    }
    
    public void startLoginActivity(View view) {
        final Intent intent = new Intent(AuthentificationActivity.this, SignInActivity.class);
    
        Pair[] pairs = new Pair[3];
        pairs[0] = new Pair<View, String>(binding.logInChoiceButton, "anim1");
        pairs[1] = new Pair<View, String>(binding.lottieAnimSplash, "LogoTransition");
        pairs[2] = new Pair<View, String>(binding.logoImageView, "LogoTransition");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(AuthentificationActivity.this ,pairs);
        startActivity(intent, options.toBundle());
    }
    
    @Override
    protected void onStart() {
        super.onStart();
        binding.lottieAnimSplash.playAnimation();
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding.lottieAnimSplash.cancelAnimation();
    }
    
    @Override
    protected void onPause() {
        super.onPause();
        binding.lottieAnimSplash.pauseAnimation();
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        binding.lottieAnimSplash.resumeAnimation();
    }
}