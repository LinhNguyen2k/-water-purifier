package com.example.waterpurifier.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.waterpurifier.R;
import com.example.waterpurifier.databinding.FragmentLitsPriceCarBinding;

public class FragmentListPriceCar extends Fragment {
    FragmentLitsPriceCarBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_lits_price_car,container,false);
        return binding.getRoot();
    }
}
