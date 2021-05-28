package com.example.chatapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;

import com.example.chatapp.R;
import com.example.chatapp.databinding.ActivityOtpBinding;

import static android.graphics.Typeface.BOLD;

public class OTPActivity extends AppCompatActivity {
    ActivityOtpBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_otp);
        binding.firstPinView.setAnimationEnable(true);
        binding.firstPinView.isEnabled();
        changeTextColor();
    }
    
    public void changeTextColor(){
        CharSequence source = "Didn't receive OTP? Resend Code";
        SpannableString spannableString = new SpannableString(source);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#00515D")),20,31, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new StyleSpan(BOLD),20,31, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        binding.otpTextView3.setText(spannableString);
    }
    
    public void getBackToVerify(View view) {
        super.onBackPressed();
    }
    
    public void openHomePage(View view) {
        startActivity(new Intent(OTPActivity.this, MenuActivity.class));
    }
    
}