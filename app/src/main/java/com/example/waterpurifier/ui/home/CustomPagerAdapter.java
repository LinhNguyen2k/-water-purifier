package com.example.waterpurifier.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.waterpurifier.R;

public class CustomPagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;

    private Integer []image = {R.drawable.two,R.drawable.three,R.drawable.two};

    public CustomPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return image.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
   return view ==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

View view =layoutInflater.inflate(R.layout.slide_pager_home,null);
        ImageView imageView =(ImageView) view.findViewById(R.id.image_slide);
        imageView.setImageResource(image[position]);
        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager viewPager = (ViewPager) container;
        View view = (View) object;
        viewPager.removeView(view);
    }
}