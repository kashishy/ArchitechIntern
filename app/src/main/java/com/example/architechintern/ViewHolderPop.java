package com.example.architechintern;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolderPop extends RecyclerView.ViewHolder {

    ImageView placeImg;
    TextView placeNme;

    public ViewHolderPop(@NonNull View itemView) {
        super(itemView);

        placeImg = itemView.findViewById(R.id.rvPopLytImgV_id);
        placeNme = itemView.findViewById(R.id.rvPopTxtV_id);
    }
}
