package com.example.chatapp.ui;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.allenliu.badgeview.BadgeFactory;
import com.allenliu.badgeview.BadgeView;
import com.example.chatapp.R;
import com.example.chatapp.adapters.DrawerAdapter;
import com.example.chatapp.adapters.DrawerItem;
import com.example.chatapp.adapters.SimpleItem;
import com.example.chatapp.adapters.SpaceItem;
import com.example.chatapp.databinding.ActivityMenuBinding;
import com.example.chatapp.ui.fragments.FragmentHistory;
import com.example.chatapp.ui.fragments.FragmentProfile;
import com.example.chatapp.ui.fragments.FragmentTrack;
import com.example.chatapp.ui.fragments.HomeFragment;
import com.example.chatapp.ui.fragments.SendParcelFragment;
import com.minibugdev.drawablebadge.DrawableBadge;
import com.yarolegovich.slidingrootnav.SlideGravity;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;
import com.yarolegovich.slidingrootnav.transform.CompositeTransformation;

import java.util.Arrays;

public class MenuActivity extends AppCompatActivity implements DrawerAdapter.OnItemSelectedListener {
    ActivityMenuBinding binding;
    //private static final int POS_CLOSE = 0;
    private static final int POS_HOME = 0;
    private static final int POS_SEND = 1;
    private static final int POS_TRACK = 2;
    private static final int POS_HISTORY = 3;
    private static final int POS_PROFILE = 4;
    private static final int POS_LOGOUT = 5;
    
    private String[] screenTitles;
    private Drawable[] screenIcons;
    TextView textView;
    
    private BadgeFactory drawableBadge;
    private SlidingRootNav slidingRootNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_menu);
        
        setSupportActionBar(binding.customToolbar);
//        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        getSupportActionBar().setCustomView(R.layout.custom_toolbar);
        textView = binding.customToolbar.getRootView().findViewById(R.id.toolbar_title);
        textView.setText("My Custom Title");
        initNavigationDrawer(savedInstanceState);
        initBadge();
        
    }
    
    public void initBadge(){
        BadgeFactory.createDot(this)
                .setBadgeCount(2)
                .bind(binding.notificationImageView);
    }
    
    public void initNavigationDrawer(Bundle savedInstanceState) {
        slidingRootNav = new SlidingRootNavBuilder(this)
                .withDragDistance(180)
                .withRootViewScale(0.75f)
                .withRootViewElevation(25)
                .withToolbarMenuToggle(binding.customToolbar)
                .withMenuOpened(false)
                .withContentClickableWhenMenuOpened(false)
                .withSavedState(savedInstanceState)
                .withMenuLayout(R.layout.drawer_menu)
                .withRootViewYTranslation(4)
                .withGravity(SlideGravity.LEFT)
                .inject();
    
        screenIcons = loadScreenIcons();
        screenTitles = loadScreenTitles();
    
        DrawerAdapter adapter = new DrawerAdapter(Arrays.asList(
                createItemFor(POS_HOME),
                createItemFor(POS_SEND).setChecked(true),
                createItemFor(POS_TRACK),
                createItemFor(POS_HISTORY),
                createItemFor(POS_PROFILE),
                new SpaceItem(100),
                createItemFor(POS_LOGOUT)
        ));
        
        adapter.setListener(this);
        
        RecyclerView list = findViewById(R.id.drawerList);
        list.setNestedScrollingEnabled(false);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(adapter);
        adapter.setSelected(POS_HOME);
    
       
    }
    
    private Drawable[] loadScreenIcons() {
    
        TypedArray typedArray = getResources().obtainTypedArray(R.array.id_activityScreenIcons);
        Drawable[] icons = new Drawable[typedArray.length()];
        for(int i=0; i<typedArray.length(); i++){
            int id = typedArray.getResourceId(i,0);
            if(id != 0){
                icons[i] = ContextCompat.getDrawable(this,id);
            }
        }
        typedArray.recycle();
        return icons;
    }
    
    private String[] loadScreenTitles() {
        
        return getResources().getStringArray(R.array.id_activityScreenTitles);
    }
    
    private DrawerItem createItemFor(int position){
        return new SimpleItem(screenIcons[position], screenTitles[position])
                .withNormalIconTint(color(R.color.purple_200))
                .withNormalTextTint(color(R.color.purple_200))
                .withSelectedIconTint(color(R.color.white))
                .withSelectedITextTint(color(R.color.white))
                .withSelectedLayoutBackgroundTint(R.drawable.menu_button_bg);
    }
    
    @ColorInt
    private int color(@ColorRes int res){
        return ContextCompat.getColor(this,res);
    }
    
    @Override
    public void onItemSelected(int position) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    
        if(position == POS_HOME){
            HomeFragment homeFragment = new HomeFragment();
            transaction.replace(R.id.frameLayout, homeFragment);
            textView.setText("Home");
        }
        
        else if(position == POS_SEND){
            SendParcelFragment sendFragment = new SendParcelFragment();
            transaction.replace(R.id.frameLayout, sendFragment);
            textView.setText("Send a parcel");
        }

        else if(position == POS_TRACK){
            FragmentTrack fragmentTrack = new FragmentTrack();
            transaction.replace(R.id.frameLayout, fragmentTrack);
            textView.setText("Track a parcel");
        }

        else if(position == POS_HISTORY){
            FragmentHistory fragmentHistory = new FragmentHistory();
            transaction.replace(R.id.frameLayout, fragmentHistory);
            textView.setText("Your history");
        }

        else if(position == POS_PROFILE){
            FragmentProfile fragmentProfile = new FragmentProfile();
            transaction.replace(R.id.frameLayout, fragmentProfile);
            textView.setText("Your profile");
        }
        
        else if(position == POS_LOGOUT){
            finish();
        }
        
        slidingRootNav.closeMenu();
        transaction.addToBackStack(null);
        transaction.commit();
        
    
    }
    
    @Override
    public void onBackPressed() {
        finish();
    }
}