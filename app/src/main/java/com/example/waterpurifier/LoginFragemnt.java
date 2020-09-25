package com.example.waterpurifier;

import android.content.Intent;
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

import com.example.waterpurifier.databinding.FragmentLoginBinding;
import com.example.waterpurifier.ui.SQLite.SQLite_Account;
import com.example.waterpurifier.ui.cart.CartFragment;

public class LoginFragemnt extends Fragment {
    FragmentLoginBinding binding;
    static  SQLite_Account sqLite_account1;

    public static LoginFragemnt newInstance() {

        Bundle args = new Bundle();

        LoginFragemnt fragment = new LoginFragemnt();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);
        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = binding.userName.getText().toString();
                String password = binding.password.getText().toString();
                SQLite_Account sqLite_account = new SQLite_Account(getContext());
                if (userName.length() == 0 || password.length() == 0) {
                    Toast.makeText(getContext(), "Bạn Phải Nhập Đầy Đủ Thông Tin", Toast.LENGTH_LONG).show();
                    return;
                } else if (sqLite_account.chekUser(userName, password)) {
                   Toast.makeText(getContext(), "Đăng Nhập Thành Công", Toast.LENGTH_LONG).show();
                    Fragment listContactFragment = CartFragment.newInstance(true);
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.nav_host_fragment, listContactFragment).commit();
//                    Intent intent = new Intent(getContext(),MainActivity.class);
//                    startActivity(intent);

                } else {
                    Toast.makeText(getContext(), "Tài Khoản Hoặc Mật Khẩu Không Chính Xác", Toast.LENGTH_LONG).show();
                    return;
                }

            }
        });

        binding.singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent intent = new Intent(getContext(),activity_regisstration.class);
//                startActivity(intent);
                Fragment listContactFragment = Fragment_Registraion.newInstance();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment, listContactFragment).commit();
            }
        });
        return binding.getRoot();
    }

    public void select_information()
    {
        sqLite_account1 = new SQLite_Account(getContext());
        String name ="";
        String phonenumber ="";
        String addres ="";
        String userName = binding.userName.getText().toString();
        String password = binding.password.getText().toString();
        if (sqLite_account1.chekUser(userName, password))
        {

        }
    }
}
