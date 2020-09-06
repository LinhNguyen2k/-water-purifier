package com.example.waterpurifier.ui.car;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

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

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_car, container, false);
        listcar = new ArrayList<>();
        sql_helper = new SQL_Helper(getContext());
        listcar = sql_helper.getallProduct();
        Adapter_custom_car adapter_custom_car = new Adapter_custom_car(listcar, getContext());
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 1, RecyclerView.VERTICAL, false);
        binding.RCListSpCar.setAdapter(adapter_custom_car);
        binding.RCListSpCar.setLayoutManager(layoutManager);

        int sum = 0;

        for(Contact_SPBanChay sp : listcar)
        {
            if(sp.getNew_price()>0)
            {
                sum+=sp.getNew_price();
            }
        }
        Locale local =new Locale("vi","VN");
        NumberFormat numberFormat = NumberFormat.getInstance(local);
        String money = numberFormat.format(sum);
        binding.sumPriceCar.setText(String.valueOf(money)+(" VNĐ"));
        binding.btRefund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean listcar = sql_helper.deleteAllProtect();
                 binding.RCListSpCar.setAdapter(null);
                 binding.RCListSpCar.setLayoutManager(null);
                Toast.makeText(getContext(),"Xóa Thành Công",Toast.LENGTH_LONG).show();
            }
        });

        return binding.getRoot();
    }

}


