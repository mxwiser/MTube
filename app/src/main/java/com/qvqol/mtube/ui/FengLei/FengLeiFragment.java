package com.qvqol.mtube.ui.FengLei;

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

public class FengLeiFragment extends Fragment {

    private FengLeiViewModel flViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        flViewModel = ViewModelProviders.of(this).get(FengLeiViewModel.class);
        View root = inflater.inflate(R.layout.fragment_fourth, container, false);
        final TextView textView = root.findViewById(R.id.text_fl);
        flViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
