package com.example.chatapp.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.chatapp.R;
import com.example.chatapp.models.UserModel;
import com.example.chatapp.utils.Constants.Common;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private final static int LOGIN_REQUEST_CODE = 1010;
    private List<AuthUI.IdpConfig> providers;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;
    
    FirebaseDatabase database;
    DatabaseReference userRef;
    
    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(firebaseAuthListener);
    }
    
    @Override
    protected void onStop() {
        if(firebaseAuth != null)
            firebaseAuth.removeAuthStateListener(firebaseAuthListener);
        super.onStop();
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }
    
    private void init() {
        providers = Collections.singletonList(
                new AuthUI.IdpConfig.PhoneBuilder().build()
        );
        firebaseAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        userRef = database.getReference(Common.USER_REFERENCES);
        
        firebaseAuthListener = myFirebaseAuth -> {
            Dexter.withContext(this)
                    .withPermissions(Arrays.asList(
                            Manifest.permission.ACCESS_FINE_LOCATION
                    )).withListener(new MultiplePermissionsListener() {
                @Override
                public void onPermissionsChecked(MultiplePermissionsReport multiplePermissionsReport) {
                    if (multiplePermissionsReport.areAllPermissionsGranted()){
                        FirebaseUser user = myFirebaseAuth.getCurrentUser();
                        if(user != null){
                            checkUserFromFirebase();
                        }else
                            showLoginLayout();
                    }
                    else
                        Toast.makeText(LoginActivity.this, "Please allow all permissions first.", Toast.LENGTH_SHORT).show();
        
                }
    
                @Override
                public void onPermissionRationaleShouldBeShown(List<PermissionRequest> list, PermissionToken permissionToken) {
        
                }
            }).check();
        };
    }
    
    private void showLoginLayout() {
        startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder()
        .setIsSmartLockEnabled(false)
        .setTheme(R.style.LoginTheme)
        .setAvailableProviders(providers).build(), LOGIN_REQUEST_CODE);
    }
    
    private void checkUserFromFirebase() {
        userRef.child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        UserModel userModel = snapshot.getValue(UserModel.class);
                        userModel.setUid(snapshot.getKey());
                        goToHomeActivity(userModel);
                    }
    
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        showRegisterLayout();
                    }
                });
    }
    
    private void goToHomeActivity(UserModel userModel) {
        Common.currentUser = userModel; // IMPORTANT
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }
    
    private void showRegisterLayout() {
        startActivity(new Intent(this, VerifyActivity.class));
        finish();
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == LOGIN_REQUEST_CODE){
            Intent intent;
            IdpResponse response = IdpResponse.fromResultIntent(data);
            if(resultCode == RESULT_OK){
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            }else
                Toast.makeText(this, "[ERROR]"+response.getError(), Toast.LENGTH_SHORT).show();
        }
    }
}