package com.example.chatapp.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.chatapp.R;
import com.example.chatapp.adapters.ShipmentAdapter;
import com.example.chatapp.databinding.FragmentHomeBinding;
import com.example.chatapp.databinding.FragmentOnboardingOneBinding;
import com.example.chatapp.models.ShipmentModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    FragmentHomeBinding binding;
    List<ShipmentModel> shipmentList;
    
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        binding.recyclerViewHistory.hasFixedSize();
        initList();
        
        View view = binding.getRoot();
        return view;
    }
    
    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
    
    public void initList(){
        shipmentList = new ArrayList<>();
        shipmentList.add(new ShipmentModel("#002254884578", "Delivered", R.drawable.textview_bg3,"Buea, Cameroun",
                "Douala, Cameroun","February 15, 11:30","June 09, 17:36"));
        shipmentList.add(new ShipmentModel("#001484787923", "Waiting Pickup", R.drawable.textview_bg2,"Douala, Cameroun",
                "Yaounde, Cameroun","January 17, 15:30","July 09, 12:36"));
        shipmentList.add(new ShipmentModel("#004265989784", "Shipped", R.drawable.textview_bg4,"Dschang, Cameroun",
                "Bamenda, Cameroun","March 15, 13:15","June 09, 08:55"));
        ShipmentAdapter adapter = new ShipmentAdapter(getContext(), shipmentList);
        binding.recyclerViewHistory.setAdapter(adapter);
        
        adapter.notifyDataSetChanged();
        binding.recyclerViewHistory.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerViewHistory.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
    }
}
