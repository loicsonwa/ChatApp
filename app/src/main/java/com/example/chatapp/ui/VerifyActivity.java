package com.example.chatapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

import com.example.chatapp.R;
import com.example.chatapp.databinding.ActivityVerifyBinding;

public class VerifyActivity extends AppCompatActivity {
    ActivityVerifyBinding binding;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_verify);
        binding.ccp.detectSIMCountry(true);
        //binding.ccp.setDefaultCountryUsingNameCode("CM");
    }
    
    public void openOTPPage(View view) {
        final Intent intent = new Intent(VerifyActivity.this, OTPActivity.class);
    
        Pair[] pairs = new Pair[3];
        pairs[0] = new Pair<View, String>(binding.buttonSendOTP, "anim1");
        pairs[1] = new Pair<View, String>(binding.registerTextView1, "anim2");
        pairs[2] = new Pair<View, String>(binding.registerTextView2, "anim3");
        //pairs[3] = new Pair<View, String>(binding.registerImageView, "anim4");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(VerifyActivity.this ,pairs);
        startActivity(intent, options.toBundle());
    }
    
    public void getBackToRegister(View view) {
        super.onBackPressed();
    }
}