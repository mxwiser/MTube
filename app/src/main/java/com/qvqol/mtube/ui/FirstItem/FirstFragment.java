package com.qvqol.mtube.ui.FirstItem;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_first, container, false);
        root.setBackgroundColor(Color.WHITE);
        SwipeRefreshLayout srl=root.findViewById(R.id.swip);
        srl.setColorSchemeResources(R.color.feng);
        srl.setRefreshing(true);
        return root;
    }
}
