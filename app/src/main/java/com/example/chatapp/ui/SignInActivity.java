package com.example.chatapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.chatapp.R;
import com.example.chatapp.databinding.ActivitySignInBinding;

public class SignInActivity extends AppCompatActivity {
    ActivitySignInBinding binding;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_sign_in);
    }
    
    public void getBackToPrevious(View view) {
        super.onBackPressed();
    }
    
    public void openHomePage(View view) {
        startActivity(new Intent(SignInActivity.this, MenuActivity.class));
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