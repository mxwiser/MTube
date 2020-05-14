package com.qvqol.mtube.ui.FirstItem;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.qvqol.mtube.R;

public class FirstFragment extends Fragment {


    public FirstFragment(){

    }
    private   SwipeRefreshLayout srl;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_first, container, false);
        root.setBackgroundColor(Color.WHITE);
        srl=root.findViewById(R.id.swip);
        srl.setColorSchemeResources(R.color.feng);
        srl.setRefreshing(true);
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
             reView();
            }
        });
        reView();
        
        return root;
    }
    public  void  reView(){
        Toast.makeText(getContext(),"hello",Toast.LENGTH_LONG).show();
        srl.setRefreshing(false);
    }
}
