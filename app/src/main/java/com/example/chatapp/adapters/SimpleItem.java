package com.example.chatapp.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.chatapp.R;

public class SimpleItem extends DrawerItem<SimpleItem.ViewHolder>{
    private int selectedItemIconTint;
    private int selectedItemTextTint;
    private int selectedLayoutBackgroundTint;
    
    
    private int normalItemIconTint;
    private int normalItemTextTint;
    private int normalLayoutBackgroundTint;
    
    private Drawable icon;
    private String title;
    
    public SimpleItem(Drawable icon, String title) {
        this.icon = icon;
        this.title = title;
    }
    
    @Override
    public ViewHolder createViewHolder(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_option, parent, false);
        return new ViewHolder(view);
    }
    
    @Override
    public void bindViewHolder(ViewHolder holder) {
        holder.icon.setImageDrawable(icon);
        holder.title.setText(title);
        
        holder.icon.setColorFilter(isChecked ? selectedItemIconTint : normalItemIconTint);
        holder.title.setTextColor(isChecked ? selectedItemTextTint : normalItemTextTint);
        holder.layout.setBackgroundResource(isChecked ? selectedLayoutBackgroundTint : normalLayoutBackgroundTint);
    }
    
    public SimpleItem withSelectedIconTint(int selectedItemIconTint){
        this.selectedItemIconTint = selectedItemIconTint;
        return this;
    }
    public SimpleItem withSelectedITextTint(int selectedItemTextTint){
        this.selectedItemTextTint = selectedItemTextTint;
        return this;
    }
    public SimpleItem withNormalTextTint(int normalItemTextTint){
        this.normalItemTextTint = normalItemTextTint;
        return this;
    }
    
    public SimpleItem withNormalIconTint(int normalItemIconTint){
        this.normalItemIconTint = normalItemIconTint;
        return this;
    }
    public SimpleItem withNormalLayoutBackgroundTint(int normalLayoutBackgroundTint){
        this.normalLayoutBackgroundTint = normalLayoutBackgroundTint;
        return this;
    }
    public SimpleItem withSelectedLayoutBackgroundTint(int selectedLayoutBackgroundTint){
        this.selectedLayoutBackgroundTint = selectedLayoutBackgroundTint;
        return this;
    }
    
    
    
    static class ViewHolder extends DrawerAdapter.DrawerViewHolder {
        private ImageView icon;
        private TextView title;
        private ConstraintLayout layout;
        
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.icon);
            title = itemView.findViewById(R.id.title);
            layout = itemView.findViewById(R.id.constraintLayout1);
        }
    }
}
