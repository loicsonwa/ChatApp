package com.example.chatapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chatapp.R;
import com.example.chatapp.models.ShipmentModel;

import java.util.List;

public class ShipmentAdapter extends RecyclerView.Adapter<ShipmentAdapter.ViewHolder> {
    Context context;
    List<ShipmentModel> shipmentList;
    
    public ShipmentAdapter(Context context, List<ShipmentModel> shipmentList) {
        this.context = context;
        this.shipmentList = shipmentList;
    }
    
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.history_item_layout,parent,false);
        return new ViewHolder(view);
    }
    
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.trackingNum.setText(shipmentList.get(position).getTrackingNum());
        holder.status.setBackgroundResource(shipmentList.get(position).getStatusBackground());
        holder.status.setText(shipmentList.get(position).getStatus());
        holder.trackingPickupLocation.setText(shipmentList.get(position).getTrackingPickupLocation());
        holder.trackingDropLocation.setText(shipmentList.get(position).getTrackingDropLocation());
        holder.trackingPickupDate.setText(shipmentList.get(position).getTrackingPickupDate());
        holder.trackingDropDate.setText(shipmentList.get(position).getTrackingDropDate());
        
    }
    
    @Override
    public int getItemCount() {
        return shipmentList.size();
    }
    
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView trackingNum,status, trackingPickupLocation,
                trackingDropLocation, trackingPickupDate, trackingDropDate;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            trackingNum = itemView.findViewById(R.id.textView_trackingNum);
            status = itemView.findViewById(R.id.textView_status);
            trackingPickupLocation = itemView.findViewById(R.id.textView_pickup);
            trackingDropLocation = itemView.findViewById(R.id.textView_drop);
            trackingPickupDate = itemView.findViewById(R.id.textView_pickup_date);
            trackingDropDate = itemView.findViewById(R.id.textView_drop_date);
            
        }
    
        @Override
        public void onClick(View v) {
        
        }
    }
}
