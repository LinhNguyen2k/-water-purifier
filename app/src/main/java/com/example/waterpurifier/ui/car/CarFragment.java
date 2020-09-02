package com.example.waterpurifier.ui.car;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.waterpurifier.R;
import com.example.waterpurifier.databinding.FragmentCarBinding;
import com.example.waterpurifier.ui.home.Adapter_SPBanChay;
import com.example.waterpurifier.ui.home.Adapter_custom_car;
import com.example.waterpurifier.ui.home.Contact_SPBanChay;
import com.example.waterpurifier.ui.home.SQL_Helper;

import java.util.ArrayList;
import java.util.List;

public class CarFragment extends Fragment {
     FragmentCarBinding binding;
    SQL_Helper sql_helper;
    List<Contact_SPBanChay> listcar;
    Adapter_custom_car adapter_custom_car1;
    Contact_SPBanChay contact_spBanChay;

    public static CarFragment newInstance() {
        
        Bundle args = new Bundle();
        
        CarFragment fragment = new CarFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_car,container,false);
             listcar = new  ArrayList<>();
             sql_helper =new SQL_Helper(getContext());
             listcar =sql_helper.getallProduct();
             Adapter_custom_car adapter_custom_car =new Adapter_custom_car(listcar,getContext());
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 1, RecyclerView.VERTICAL, false);
        binding.RCListSpCar.setAdapter(adapter_custom_car);
        binding.RCListSpCar.setLayoutManager(layoutManager);

//       binding.sumPriceCar.setText(String.valueOf(adapter_custom_car1.sumPrice()));
// sumPrice();
        return binding.getRoot();
    }

//
//    public void sumPrice()
//    {
//
//        int sum= 0;
//        for(int i=0;i<listcar.size();i++)
//        {
//            sum+=contact_spBanChay.getNew_price();
//        }
//       binding.sumPriceCar.setText(String.valueOf(sum));
//    }
}


