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

public class Adapter_MayLocNuoc extends RecyclerView.Adapter<Adapter_MayLocNuoc.Viewhoder>{

        List<Contac_MayLocNuoc> contac_mayLocNuocs;
private Context context;

public Adapter_MayLocNuoc(List<Contac_MayLocNuoc> contac_mayLocNuocs,Context context){
        this.contac_mayLocNuocs=contac_mayLocNuocs;
        this.context=context;
        }

@NonNull
@Override
public Adapter_MayLocNuoc.Viewhoder onCreateViewHolder(@NonNull ViewGroup parent,int viewType){
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.custom_list_maylocnuoc,parent,false);

        Adapter_MayLocNuoc.Viewhoder viewhoder=new Adapter_MayLocNuoc.Viewhoder(view);
        return viewhoder;
        }

    @Override
public void onBindViewHolder(@NonNull Viewhoder holder,int position){
final Contac_MayLocNuoc contact=contac_mayLocNuocs.get(position);
        Picasso.with(context).load(contact.getImage()).into(holder.image_spBanChay);
        holder.tvone.setText(String.valueOf(contact.getName_product()));
        holder.tvtwo.setText(String.valueOf(contact.getPrice()));
        }

@Override
public int getItemCount(){
        return contac_mayLocNuocs.size();
        }

public class Viewhoder extends RecyclerView.ViewHolder {
    ImageView image_spBanChay;
    TextView tvone, tvtwo;

    public Viewhoder(@NonNull View itemView) {
        super(itemView);
        tvone = itemView.findViewById(R.id.tv_name_MayLocNuoc);
        tvtwo = itemView.findViewById(R.id.tv_price_MayLocNuoc);
        image_spBanChay = itemView.findViewById(R.id.image_MayLocNuoc);

    }
}
}


