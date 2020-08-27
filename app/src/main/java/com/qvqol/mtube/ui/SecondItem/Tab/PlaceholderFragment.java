package com.qvqol.mtube.ui.SecondItem.Tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.qvqol.mtube.R;


/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends BaseFragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private int mCurIndex = -1;
    /** 标志位，标志已经初始化完成 */
    private boolean isPrepared;
    /** 是否已被加载过一次，第二次就不再去请求数据了 */
    private boolean mHasLoadedOnce;
    public static PlaceholderFragment newInstance(int index,Context context) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
           mCurIndex=index;
    }
    boolean isLoad=false;
    private TextView textView;
    @SuppressLint("FragmentLiveDataObserve")
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_second, container, false);

             textView = root.findViewById(R.id.adddd);
            isPrepared=true;
            lazyLoad();
        return root;
    }
    //预加载
    public  void OnLoad(View root,String s){

        Toast.makeText(getActivity(),s,3000).show();
    }


    @Override
    protected void lazyLoad() {
        if (!isPrepared || !isVisible ) {
            return;
        }

        textView.setText("dd");
    }
}