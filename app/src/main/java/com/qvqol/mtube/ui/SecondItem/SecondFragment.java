package com.qvqol.mtube.ui.SecondItem;

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

public class SecondFragment extends Fragment {


    private ListView listView;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_second, container, false);
        root.setBackgroundColor(Color.WHITE);
        return root;
    }
}
