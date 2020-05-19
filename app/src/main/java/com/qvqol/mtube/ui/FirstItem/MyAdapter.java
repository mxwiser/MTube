package com.qvqol.mtube.ui.FirstItem;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.qvqol.mtube.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final static int TYPE_CONTENT=0;//正常内容
    private final static int TYPE_FOOTER=1;//下拉刷新
    private ArrayList<VItem> listItem;
    private Context context;

    public  MyAdapter(Context context){
        this.context=context;
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
            View view=LayoutInflater.from(context).inflate(R.layout.activity_main_item,parent,false);
            return new MyViewHolder(view);
        }

    }
    //绑定数据
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position)==TYPE_FOOTER){

        }
        else{
            MyViewHolder viewHolder= (MyViewHolder) holder;
            viewHolder.textView.setText(listItem.get(position).title);

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
        return TYPE_CONTENT;
    }
    public void addDate(String title, String time, String hot, String duration, String message, int category, Bitmap bitmap){
        VItem vItem=new VItem();
        vItem.title=title;
        vItem.time=time;
        vItem.hot=hot;
        vItem.duration=duration;
        vItem.message=message;
        vItem.category=category;
        vItem.bitmap=bitmap;
        listItem.add(vItem);

    };
    public void ClearList(){
        listItem.clear();
    }
}
