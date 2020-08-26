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

public class Adapter_HeThongLocNuoc extends RecyclerView.Adapter<Adapter_HeThongLocNuoc.Viewhoder> {

    List<Contact_HeThongLocNuoc> contact_heThongLocNuocs;
    private Context context;

    public Adapter_HeThongLocNuoc(List<Contact_HeThongLocNuoc> contact_heThongLocNuocs, Context context) {
        this.contact_heThongLocNuocs = contact_heThongLocNuocs;
        this.context = context;
    }

    @NonNull
    @Override
    public Adapter_HeThongLocNuoc.Viewhoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.custom_list_hethonglocnuoc, parent, false);

        Adapter_HeThongLocNuoc.Viewhoder viewhoder = new Adapter_HeThongLocNuoc.Viewhoder(view);
        return viewhoder;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewhoder holder, int position) {
        final Contact_HeThongLocNuoc contact = contact_heThongLocNuocs.get(position);
        Picasso.with(context).load(contact.getImage()).into(holder.image_heThongLocNuoc);
        holder.tvone.setText(String.valueOf(contact.getName_product()));
        holder.tvtwo.setText(String.valueOf(contact.getPrice()));
    }

    @Override
    public int getItemCount() {
        return contact_heThongLocNuocs.size();
    }

    public class Viewhoder extends RecyclerView.ViewHolder {
        ImageView image_heThongLocNuoc;
        TextView tvone, tvtwo;

        public Viewhoder(@NonNull View itemView) {
            super(itemView);
            tvone = itemView.findViewById(R.id.tv_name_heThongLocNuoc);
            tvtwo = itemView.findViewById(R.id.tv_price_heThongLocNuoc);
            image_heThongLocNuoc = itemView.findViewById(R.id.image_heThongLocNuoc);

        }
    }
}