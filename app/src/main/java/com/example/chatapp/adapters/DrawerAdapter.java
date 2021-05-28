package com.example.chatapp.adapters;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DrawerAdapter extends RecyclerView.Adapter<DrawerAdapter.DrawerViewHolder> {
    private List<DrawerItem> items;
    private Map<Class<? extends DrawerItem>, Integer> viewType;
    private SparseArray<DrawerItem> holderFactory;
    
    private OnItemSelectedListener listener;
    
    public DrawerAdapter(List<DrawerItem> items) {
        this.items = items;
        this.viewType = new HashMap<>();
        this.holderFactory = new SparseArray<>();
        processViewType();
        
    }
    
    private void processViewType() {
        int type = 0;
        for( DrawerItem item : items){
            if(!viewType.containsKey(item.getClass())){
                viewType.put(item.getClass(),type);
                holderFactory.put(type, item);
                type++;
            }
        }
    }
    
    @NonNull
    @Override
    public DrawerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        DrawerViewHolder holder = holderFactory.get(viewType).createViewHolder(parent);
        holder.drawerAdapter = this;
        return holder;
    }
    
    @Override
    public void onBindViewHolder(@NonNull DrawerViewHolder holder, int position) {
        items.get(position).bindViewHolder(holder);
    }
    
    @Override
    public int getItemCount() {
        return items.size();
    }
    
    @Override
    public int getItemViewType(int position) {
        return viewType.get(items.get(position).getClass());
    }
    
    public void setSelected(int position){
        DrawerItem newChecked = items.get(position);
        if(!newChecked.isSelectable())
            return;
        for (int i=0; i<items.size(); i++){
            DrawerItem item = items.get(i);
            if(item.isChecked()){
                item.setChecked(false);
                notifyItemChanged(i);
                break;
            }
        }
        newChecked.setChecked(true);
        notifyItemChanged(position);
        
        if(listener != null){
            listener.onItemSelected(position);
        }
    }
    public void setListener(OnItemSelectedListener listener){
        this.listener = listener;
    }
    public interface OnItemSelectedListener{
        void onItemSelected(int position);
    }
    
    static abstract class DrawerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private DrawerAdapter drawerAdapter;
        
        public DrawerViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }
    
        @Override
        public void onClick(View v) {
            drawerAdapter.setSelected(getBindingAdapterPosition());
        }
    }
    
    
}
