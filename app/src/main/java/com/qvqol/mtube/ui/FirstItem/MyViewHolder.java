package com.qvqol.mtube.ui.FirstItem;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.qvqol.mtube.R;


public class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView textView;
    public LinearLayout limage;
    public CardView cardView;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        textView=itemView.findViewById(R.id.textItem);
        cardView=itemView.findViewById(R.id.card);
        limage=itemView.findViewById(R.id.limage);
        ViewGroup.LayoutParams layoutParams= limage.getLayoutParams();

        float width=cardView.getMeasuredWidth();
        float height=width/2;
       // layoutParams.height= (int) (height);
    }
}
