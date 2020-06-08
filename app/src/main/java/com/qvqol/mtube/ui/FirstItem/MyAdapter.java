package com.qvqol.mtube.ui.FirstItem;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.qvqol.mtube.R;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final static int TYPE_CONTENT=0;//正常内容
    private final static int TYPE_FOOTER=-1;//下拉刷新
    private ArrayList<VItem> listItem;
    private Context context;
    final ThreadPoolExecutor threadPoolExecutor;

    public  MyAdapter(Context context){
        this.context=context;
        threadPoolExecutor=new ThreadPoolExecutor(3,5,1, TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>(100));
        listItem=new ArrayList<>();
    }
    @NonNull
    //创建布局
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==TYPE_FOOTER){

            View view= LayoutInflater.from(context).inflate(R.layout.activity_main_foot,parent,false);
            return  new FootViewHolder(view);
        }else {
            if (listItem.get(viewType).category==0){
                View view=LayoutInflater.from(context).inflate(R.layout.activity_main_item,parent,false);
                return new MyViewHolder(view);
            }else{
                View view=LayoutInflater.from(context).inflate(R.layout.activity_main_item_ad,parent,false);
                return new MyViewHolderAd(view);
            }

        }

    }
    //绑定数据
    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        if (getItemViewType(position)==TYPE_FOOTER){
        }
        else{
            if (listItem.get(position).category==0){
                final MyViewHolder viewHolder= (MyViewHolder) holder;
                viewHolder.OnBindUI(listItem.get(position),position,context);
            }else if(listItem.get(position).category==1){
                final MyViewHolderAd viewHolder= (MyViewHolderAd) holder;
                viewHolder.OnBindUI(listItem.get(position),position,context);
            }

        }
    }

    @Override
    public int getItemCount() {
        return listItem.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position==listItem.size()){
            return TYPE_FOOTER;
        }
        return position;
    }
    public void addDate(String title, String time, String hot, String duration, String message, int category, String img){
        VItem vItem=new VItem();
        vItem.title=title;
        vItem.time=time;
        vItem.hot=hot;
        vItem.duration=duration;
        vItem.message=message;
        vItem.category=category;
        vItem.imgUrl=img;
        listItem.add(vItem);
    };

    public void addDateAd(String title, String message, String img,String abdul,boolean isOpenOnApp){
        VItem vItem=new VItem();
        vItem.title=title;
        vItem.category=1;
        vItem.imgUrl=img;
        vItem.isOpenOnApp=isOpenOnApp;
        vItem.adurl=abdul;
        listItem.add(vItem);
    };

    public void ClearList(){
        listItem.clear();
    }
}
