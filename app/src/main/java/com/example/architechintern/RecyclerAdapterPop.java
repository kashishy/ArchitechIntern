package com.example.architechintern;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapterPop extends RecyclerView.Adapter<ViewHolderPop> {

    List<DataPop> data;
    Context context;

    public RecyclerAdapterPop(List<DataPop> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderPop onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.popcdvlyt,viewGroup,false);
        ViewHolderPop viewHolderpop = new ViewHolderPop(view);
        return viewHolderpop;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPop viewHolderPop, int i) {

        DataPop dataPop = data.get(i);
        viewHolderPop.placeNme.setText(dataPop.name);
        Glide.with(context).load(dataPop.url).into(viewHolderPop.placeImg);

    }

    @Override
    public int getItemCount() {
        if(data==null)
            return 0;
        else
            return data.size();
    }
}
