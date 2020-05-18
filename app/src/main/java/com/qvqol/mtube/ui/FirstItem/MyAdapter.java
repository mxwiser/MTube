package com.qvqol.mtube.ui.FirstItem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.qvqol.mtube.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final static int TYPE_CONTENT=0;//正常内容
    private final static int TYPE_FOOTER=1;//下拉刷新
    private ArrayList<String> list;
    private Context context;

    public  MyAdapter(Context context){
        this.context=context;
        list=new ArrayList<>();
        list.add("a");
        list.add("b");

    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==TYPE_FOOTER){
            View view= LayoutInflater.from(context).inflate(R.layout.activity_main_foot,parent,false);

        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position==list.size()){
            return TYPE_FOOTER;
        }
        return TYPE_CONTENT;
    }
}
