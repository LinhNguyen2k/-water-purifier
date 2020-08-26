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

public class Adapter_LinhKienMayLocNuoc extends RecyclerView.Adapter<Adapter_LinhKienMayLocNuoc.Viewhoder> {

    List<Coctac_LinhKien> coctac_linhKiens;
    private Context context;

    public Adapter_LinhKienMayLocNuoc(List<Coctac_LinhKien> coctac_linhKiens, Context context) {
        this.coctac_linhKiens = coctac_linhKiens;
        this.context = context;
    }

    @NonNull
    @Override
    public Adapter_LinhKienMayLocNuoc.Viewhoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.custom_list_linhkien, parent, false);

        Adapter_LinhKienMayLocNuoc.Viewhoder viewhoder = new Adapter_LinhKienMayLocNuoc.Viewhoder(view);
        return viewhoder;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewhoder holder, int position) {
        final Coctac_LinhKien contact = coctac_linhKiens.get(position);
        Picasso.with(context).load(contact.getImage()).into(holder.image_heThongLocNuoc);
        holder.tvone.setText(String.valueOf(contact.getName_product()));
        holder.tvtwo.setText(String.valueOf(contact.getPrice()));
    }

    @Override
    public int getItemCount() {
        return coctac_linhKiens.size();
    }

    public class Viewhoder extends RecyclerView.ViewHolder {
        ImageView image_heThongLocNuoc;
        TextView tvone, tvtwo;

        public Viewhoder(@NonNull View itemView) {
            super(itemView);
            tvone = itemView.findViewById(R.id.tv_name_LinhKien);
            tvtwo = itemView.findViewById(R.id.tv_price_LinhKien);
            image_heThongLocNuoc = itemView.findViewById(R.id.image_LinhKien);

        }
    }
}
