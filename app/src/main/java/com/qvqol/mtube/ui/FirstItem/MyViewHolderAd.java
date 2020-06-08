package com.qvqol.mtube.ui.FirstItem;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.qvqol.mtube.R;


public class MyViewHolderAd extends RecyclerView.ViewHolder {

private  Context context;
private  int pos;
private  MyLinearImageAd myLinearImageAd;
    public MyViewHolderAd(@NonNull View itemView) {
        super(itemView);
        myLinearImageAd=itemView.findViewById(R.id.adlimage);
    }

    public void OnBindUI(VItem vItem, int pos, Context context){
     this.context=context;
     this.pos=pos;
     myLinearImageAd.setBackgroundResource(R.drawable.adone);
    }
}