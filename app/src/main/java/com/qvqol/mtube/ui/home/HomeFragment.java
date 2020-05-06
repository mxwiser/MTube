package com.qvqol.mtube.ui.home;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.qvqol.mtube.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private ListView listView;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        root.setBackgroundColor(Color.WHITE);
        listView=root.findViewById(R.id.listhome);


        return root;
    }
}
