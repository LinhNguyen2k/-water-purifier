package com.example.waterpurifier.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;


import com.example.waterpurifier.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter_SPBanChay extends RecyclerView.Adapter<Adapter_SPBanChay.Viewhoder> {

    List<Contact_SPBanChay> contact_spBanChays;
private Context context;

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
       holder.tvtwo.setText(String.valueOf(contact.getPrice()));

    }

    @Override
    public int getItemCount() {
        return contact_spBanChays.size();
    }

    public class Viewhoder extends RecyclerView.ViewHolder {
        ImageView image_spBanChay;
        TextView tvone, tvtwo;

        public Viewhoder(@NonNull View itemView) {
            super(itemView);
            tvone = itemView.findViewById(R.id.tv_name_spBanChay);
            tvtwo = itemView.findViewById(R.id.tv_price_spBanChay);
            image_spBanChay = itemView.findViewById(R.id.image_spBanChay);

        }
    }

}
