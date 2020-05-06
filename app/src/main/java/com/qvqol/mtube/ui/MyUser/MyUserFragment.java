package com.qvqol.mtube.ui.MyUser;

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

public class MyUserFragment extends Fragment {

    private MyUserViewModel myViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        myViewModel =
                ViewModelProviders.of(this).get(MyUserViewModel.class);
        View root = inflater.inflate(R.layout.fragment_my, container, false);
        final TextView textView = root.findViewById(R.id.text_my);
        myViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText("ddddd");
            }
        });
        return root;
    }
}
