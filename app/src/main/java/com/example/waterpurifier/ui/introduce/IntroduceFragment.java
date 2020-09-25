package com.example.waterpurifier.ui.Introduce;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.waterpurifier.R;
import com.example.waterpurifier.databinding.FragmentIntroduceBinding;


public class IntroduceFragment extends Fragment {

   FragmentIntroduceBinding binding;
//    Fragment is = this;
//    public static IntroduceFragment newInstance() {
//
//        Bundle args = new Bundle();
//
//        IntroduceFragment fragment = new IntroduceFragment();
//        fragment.setArguments(args);
//        return fragment;
//    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_introduce, container, false);

//        binding.imageBackLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Fragment listContactFragment = CarFragment.newInstance();
//                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.remove(is);
//                fragmentTransaction.replace( R.id.nav_host_fragment,listContactFragment ).commit();
//            }
//        });

        return binding.getRoot();
    }
}
