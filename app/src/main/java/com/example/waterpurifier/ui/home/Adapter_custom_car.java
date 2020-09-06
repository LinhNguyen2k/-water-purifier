package com.example.waterpurifier.ui.home;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.waterpurifier.R;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class Adapter_custom_car extends RecyclerView.Adapter<Adapter_custom_car.Viewhoder> {

    Contact_SPBanChay contact_spBanChay;
    List<Contact_SPBanChay> contact_spBanChays;
    private Context context;

    public Adapter_custom_car(List<Contact_SPBanChay> contact_spBanChays, Context context) {
        this.contact_spBanChays = contact_spBanChays;
        this.context = context;
    }

    @NonNull
    @Override
    public Adapter_custom_car.Viewhoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.custtom_list_price_car, parent, false);

        Adapter_custom_car.Viewhoder viewhoder = new Adapter_custom_car.Viewhoder(view);
        return viewhoder;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewhoder holder, int position) {
        final Contact_SPBanChay contact = contact_spBanChays.get(position);
        Picasso.with(context).load(contact.getImage()).into(holder.image_spBanChay);
        holder.tvone.setText(String.valueOf(contact.getName_product()));
        Locale local =new Locale("vi","VN");
        NumberFormat numberFormat = NumberFormat.getInstance(local);
        String money = numberFormat.format(contact.getNew_price());
        holder.tvtwo.setText(String.valueOf(money)+ (" VNĐ"));
        holder.tvthree.setText(String.valueOf(" "+1));

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
            tvone = itemView.findViewById(R.id.tv_list_name_car);
            tvtwo = itemView.findViewById(R.id.tv_list_price_car);
            tvthree = itemView.findViewById(R.id.tv_list_count_car);
            image_spBanChay = itemView.findViewById(R.id.image_list_price_car);

        }
    }

}
