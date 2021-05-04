package com.example.chatapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.chatapp.R;
import com.example.chatapp.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {
    ActivityRegisterBinding binding;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_register);
        binding.ccp.detectSIMCountry(true);
        //binding.ccp.setDefaultCountryUsingNameCode("CM");
    }
    
    public void openVerifyPage(View view) {
        startActivity(new Intent(RegisterActivity.this, VerifyActivity.class));
    }
}