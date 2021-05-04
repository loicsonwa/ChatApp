package com.example.chatapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;

import com.example.chatapp.R;
import com.example.chatapp.databinding.ActivityVerifyBinding;

import static android.graphics.Typeface.BOLD;

public class VerifyActivity extends AppCompatActivity {
    ActivityVerifyBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_verify);
        binding.firstPinView.setAnimationEnable(true);
        binding.firstPinView.isEnabled();
        changeTextColor();
    }
    
    public void changeTextColor(){
        CharSequence source = "Didn't receive OTP? Resend Code";
        SpannableString spannableString = new SpannableString(source);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#00515D")),20,31, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new StyleSpan(BOLD),20,31, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        binding.verifyTextView3.setText(spannableString);
    }
    
    public void getBack(View view) {
        super.onBackPressed();
    }
}