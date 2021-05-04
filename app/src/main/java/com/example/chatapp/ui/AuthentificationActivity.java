package com.example.chatapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
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
    }
    
    public void startSignInActivity(View view) {
        startActivity(new Intent(AuthentificationActivity.this, RegisterActivity.class));
    }
    
    public void startLoginActivity(View view) {
    }
}