package com.example.waterpurifier.ui.recruiment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.waterpurifier.R;
import com.example.waterpurifier.ui.news.NewsViewModel;

public class RecruimentFragment extends Fragment {
    private RecruimentViewModel recruimentViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        recruimentViewModel =
                ViewModelProviders.of(this).get(RecruimentViewModel.class);
        View root = inflater.inflate(R.layout.fragment_news, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        recruimentViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

}
