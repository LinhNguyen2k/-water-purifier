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
import com.example.waterpurifier.databinding.FragmentItemSpbanchayBinding;
import com.squareup.picasso.Picasso;

import java.io.Serializable;

public class ItemSPBanChay extends Fragment {
    FragmentItemSpbanchayBinding binding;
    Contact_SPBanChay contact_spBanChay;

    public static ItemSPBanChay newInstance(Contact_SPBanChay contact_spBanChay) {
        
        Bundle args = new Bundle();
       args.putSerializable("contact_spBanChay",contact_spBanChay);
        ItemSPBanChay fragment = new ItemSPBanChay();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_item_spbanchay,container,false);

           contact_spBanChay = (Contact_SPBanChay)getArguments().getSerializable("contact_spBanChay");

        Picasso.with(getContext()).load(contact_spBanChay.getImage()).into(binding.igItemSpbanchay);
        return binding.getRoot();
    }
}
