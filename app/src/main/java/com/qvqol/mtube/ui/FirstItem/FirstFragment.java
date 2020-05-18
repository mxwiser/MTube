package com.qvqol.mtube.ui.FirstItem;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.qvqol.mtube.R;

public class FirstFragment extends Fragment {


    public FirstFragment(){

    }
    private MyAdapter myAdapter;
    private   SwipeRefreshLayout srl;
    private RecyclerView recyclerView;
    private Handler handler;
    private LinearLayoutManager linearLayoutManager;
    private onLoadMoreListener onLoadMoreListener;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_first, container, false);
        root.setBackgroundColor(Color.WHITE);
        srl=root.findViewById(R.id.swip);
        recyclerView=root.findViewById(R.id.recy);


        initView();
        return root;
    }



    private void initView(){
        handler=new Handler();
        linearLayoutManager=new LinearLayoutManager(getContext());
        onLoadMoreListener=new onLoadMoreListener() {
            @Override
            protected void onLoading(int countItem, int lastItem) {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getData("loadMore");
                    }
                }, 500);
            }
        };

        srl.setColorSchemeResources(R.color.feng);
        srl.setRefreshing(true);
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData("reset");
            }
        });

        myAdapter=new MyAdapter(getContext());
        recyclerView.setOverScrollMode(View.OVER_SCROLL_NEVER);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(myAdapter);
        recyclerView.addOnScrollListener(onLoadMoreListener);
        getData("reset");

    }




    public  void  reView(){
        Toast.makeText(getContext(),"hello",Toast.LENGTH_LONG).show();
        srl.setRefreshing(false);
    }
int count;
    private void getData(final String type) {
        if ("reset".equals(type)) {
           myAdapter.ClearList();
           count = 0;
            for (int i = 0; i < 20; i++) {
                count += 1;
                myAdapter.addDate(String.valueOf(count));
            }
        }
        else if ("refresh".equals(type)) {
            myAdapter.ClearList();
            count = 0;
            for (int i = 0; i < 13; i++) {
                count += 1;
                myAdapter.addDate(String.valueOf(count));
            }
        } else {
            for (int i = 0; i < 3; i++) {
                count += 1;
                myAdapter.addDate(String.valueOf(count));
            }
        }

        myAdapter.notifyDataSetChanged();
        if (srl.isRefreshing()) {
            srl.setRefreshing(false);
        }
        if ("refresh".equals(type)) {
            Toast.makeText(getContext(), "刷新完毕", Toast.LENGTH_SHORT).show();
        } else {
            //Toast.makeText(getContext(), "加载完毕", Toast.LENGTH_SHORT).show();
        }
    }
}
