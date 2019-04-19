package com.example.architechintern;

import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static android.support.v7.widget.RecyclerView.*;

public class ViewHolderPopActvty extends ViewHolder {

    TextView name,place,booked;
    ImageView image;
    TextView star,rview,oldprice,price,avl,dash;

    public ViewHolderPopActvty(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.rvpopActvtyNme_id);
        image = itemView.findViewById(R.id.rvpopActvtyImg_id);
        place = itemView.findViewById(R.id.rvpopActvtyPlc_id);
        booked = itemView.findViewById(R.id.rvpopActvtyBkd_id);
        star = itemView.findViewById(R.id.rvpopActvtyStr_id);
        rview = itemView.findViewById(R.id.rvpopActvtyRvw_id);
        oldprice = itemView.findViewById(R.id.rvpopActvtyOldPr_id);
        price = itemView.findViewById(R.id.rvpopActvtyprc_id);
        avl = itemView.findViewById(R.id.rvpopActvtyAvl_id);
        dash = itemView.findViewById(R.id.txtDash_id);
    }
}
