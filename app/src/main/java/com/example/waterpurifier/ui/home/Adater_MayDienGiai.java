package com.example.waterpurifier.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.waterpurifier.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adater_MayDienGiai extends RecyclerView.Adapter<Adater_MayDienGiai.Viewhoder> {

    List<Contact_MayDienGiai> contact_mayDienGiais;
    private Context context;

    public Adater_MayDienGiai(List<Contact_MayDienGiai> contact_mayDienGiais, Context context) {
        this.contact_mayDienGiais = contact_mayDienGiais;
        this.context = context;
    }

    @NonNull
    @Override
    public Adater_MayDienGiai.Viewhoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.custom_list_maydiengiai, parent, false);

        Adater_MayDienGiai.Viewhoder viewhoder = new Adater_MayDienGiai.Viewhoder(view);
        return viewhoder;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewhoder holder, int position) {
        final Contact_MayDienGiai contact = contact_mayDienGiais.get(position);
        Picasso.with(context).load(contact.getImage()).into(holder.image_spBanChay);
        holder.tvone.setText(String.valueOf(contact.getName_product()));
        holder.tvtwo.setText(String.valueOf(contact.getPrice()));
    }

    @Override
    public int getItemCount() {
        return contact_mayDienGiais.size();
    }

    public class Viewhoder extends RecyclerView.ViewHolder {
        ImageView image_spBanChay;
        TextView tvone, tvtwo;

        public Viewhoder(@NonNull View itemView) {
            super(itemView);
            tvone = itemView.findViewById(R.id.tv_name_mayDG);
            tvtwo = itemView.findViewById(R.id.tv_price_mayDG);
            image_spBanChay = itemView.findViewById(R.id.image_mayDG);

        }
    }
}
