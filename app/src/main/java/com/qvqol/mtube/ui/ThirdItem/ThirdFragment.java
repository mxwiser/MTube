package com.qvqol.mtube.ui.ThirdItem;

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

import com.qvqol.mtube.R;

public class ThirdFragment extends Fragment {


    public  ThirdFragment(){

    }
    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_third, container, false);
        root.setBackgroundColor(Color.WHITE);
        final TextView textView = root.findViewById(R.id.text_notifications);
        textView.setText("3");
        return root;
    }
}
