package com.example.waterpurifier.ui.home;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.waterpurifier.R;

import com.example.waterpurifier.databinding.FragmentItemSpbanchayBinding;

import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ItemSPBanChay extends Fragment {
    FragmentItemSpbanchayBinding binding;
    RecyclerView recyclerView;
    Contact_SPBanChay contact_spBanChay;
    List<Contact_SPBanChay> contact_spBanChays;
    Fragment is = this;

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
      binding.tvItemTitle.setText(contact_spBanChay.getName_product());
        binding.tvItemOldPrice.setText(contact_spBanChay.getOld_price());
        binding.tvItemNewPrice.setText(contact_spBanChay.getNew_price());
        binding.tvItemStatus.setText(contact_spBanChay.getStatus());
//        binding.tvItemStatus.setTextColor(Color.parseColor("#0080FF"));
//        binding.tvItemStatus.setText("Tình Trạng :"+contact_spBanChay.getStatus());
        binding.tvItemContent.setText(contact_spBanChay.getContent());
        binding.tvItemOldPrice.setPaintFlags(binding.tvItemOldPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);


        binding.igBackListHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager =getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                manager.getBackStackEntryCount();
                transaction.remove(is);
                transaction.commit();
            }
        });
         binding.addCar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 SQL_Helper sql_helper;
                 sql_helper = new SQL_Helper(getContext());
                sql_helper.insertPhone(new Contact_SPBanChay(contact_spBanChay.getNew_price(),contact_spBanChay.getOld_price(),contact_spBanChay.getContent(),contact_spBanChay.getImage(),contact_spBanChay.getName_product(),contact_spBanChay.getStatus()));
                 Toast.makeText(getContext(),"add thành công",Toast.LENGTH_LONG).show();
             }
         });
        return binding.getRoot();
    }

}
