package com.example.waterpurifier.ui.home;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;


import com.example.waterpurifier.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Adapter_SPBanChay extends RecyclerView.Adapter<Adapter_SPBanChay.Viewhoder> {

    List<Contact_SPBanChay> contact_spBanChays;
    private Context context;
    IonClickWaterPurifier ionClickWaterPurifier;

    public void setIonClickWaterPurifier(IonClickWaterPurifier ionClickWaterPurifier) {
        this.ionClickWaterPurifier = ionClickWaterPurifier;
    }

    public Adapter_SPBanChay(List<Contact_SPBanChay> contact_spBanChays, Context context) {
        this.contact_spBanChays = contact_spBanChays;
        this.context = context;
    }

    @NonNull
    @Override
    public Viewhoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.custom_list_spbanchay, parent, false);

        Viewhoder viewhoder = new Viewhoder(view);
        return viewhoder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_SPBanChay.Viewhoder holder, int position) {
        final Contact_SPBanChay contact = contact_spBanChays.get(position);
        Picasso.with(context).load(contact.getImage()).into(holder.image_spBanChay);
        holder.tvone.setText(String.valueOf(contact.getName_product()));
        //  holder.tvone.setPaintFlags(holder.tvone.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        holder.tvtwo.setText(String.valueOf(contact.getNew_price()));
        holder.tvthree.setText(String.valueOf(contact.getOld_price()));
        holder.tvthree.setPaintFlags(holder.tvthree.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ionClickWaterPurifier.onClickItem(contact);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contact_spBanChays.size();
    }



    public static class Viewhoder extends RecyclerView.ViewHolder {
        ImageView image_spBanChay;
        TextView tvone, tvtwo,tvthree;
        LinearLayout layout;

        public Viewhoder(@NonNull View itemView) {
            super(itemView);
            tvone = itemView.findViewById(R.id.tv_name_spBanChay);
            tvtwo = itemView.findViewById(R.id.tv_price_spBanChay);
            tvthree = itemView.findViewById(R.id.tv_old_price_spBanChay);
            image_spBanChay = itemView.findViewById(R.id.image_spBanChay);
            layout= itemView.findViewById(R.id.custom_list_SPBanChay);


        }
    }

}
