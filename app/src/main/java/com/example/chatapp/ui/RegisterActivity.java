package com.example.chatapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

import com.example.chatapp.R;
import com.example.chatapp.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {
    ActivityRegisterBinding binding;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_register);
        
        
    }
    
    public void openVerifyPage(View view) {
        final Intent intent = new Intent(RegisterActivity.this, VerifyActivity.class);
    
        Pair[] pairs = new Pair[2];
        pairs[0] = new Pair<View, String>(binding.buttonContinue, "anim1");
        pairs[1] = new Pair<View, String>(binding.registerDescription, "anim3");
        //pairs[2] = new Pair<View, String>(binding.textViewOne, "anim2");
        //pairs[3] = new Pair<View, String>(binding.registerImageView, "anim4");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(RegisterActivity.this ,pairs);
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
    
    public void getBackToPrevious(View view) {
        super.onBackPressed();
    }
}