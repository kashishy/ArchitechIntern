package com.example.architechintern;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerAdapterPopactvty extends RecyclerView.Adapter<ViewHolderPopActvty> {

    List<DataPopActivity> data;
    Context context;

    public RecyclerAdapterPopactvty(List<DataPopActivity> data, Context context){
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderPopActvty onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.popactvtycdvlyt,viewGroup,false);
        ViewHolderPopActvty viewHolderPopActvty = new ViewHolderPopActvty(view);
        return viewHolderPopActvty;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPopActvty holder, int i) {

        DataPopActivity dataPopActivity = data.get(i);
        holder.name.setText(dataPopActivity.getName());
        holder.place.setText(dataPopActivity.getPlace());
        if(dataPopActivity.getStar().equals("0")){
            holder.star.setVisibility(View.INVISIBLE);
        }else{
            holder.star.setText("★"+dataPopActivity.getStar());
        }
        if (dataPopActivity.getReviews().equals("0")){
            holder.dash.setVisibility(View.INVISIBLE);
        }else{
            holder.rview.setText("("+dataPopActivity.getReviews()+" reviews)");
            holder.dash.setPadding(5,0,5,0);
            holder.dash.setVisibility(View.VISIBLE);
        }
        if (dataPopActivity.getOldprice().equals("0")){
            holder.oldprice.setVisibility(View.INVISIBLE);
        }else {
            holder.oldprice.setText("₹"+dataPopActivity.getOldprice());
            holder.oldprice.setPaintFlags(holder.oldprice.getPaintFlags()|Paint.STRIKE_THRU_TEXT_FLAG);
        }
        holder.avl.setText(dataPopActivity.getAvailable());
        if (dataPopActivity.getAvailable().equals("Available Today")||dataPopActivity.getAvailable().equals("Available Tommorow")){
            holder.avl.setTextColor(Color.parseColor("#58A55B"));
        }
        holder.price.setText("₹"+dataPopActivity.getPrice());
        holder.booked.setText(dataPopActivity.getBooked()+" Booked");
        Glide.with(context).load(dataPopActivity.getUrl()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
