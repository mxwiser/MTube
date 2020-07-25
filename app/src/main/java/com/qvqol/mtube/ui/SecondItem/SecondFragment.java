package com.qvqol.mtube.ui.SecondItem;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.qvqol.mtube.R;
import com.qvqol.mtube.ui.SecondItem.Tab.SectionsPagerAdapter;

public class SecondFragment extends Fragment {


   private Context context;
     public SecondFragment(Context context ){
          this.context=context;

     }
    private ListView listView;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_second_tab, container, false);
        root.setBackgroundColor(Color.WHITE);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(context, getChildFragmentManager());
        ViewPager viewPager =root. findViewById(R.id.view_pager);

        //为了切换时不再进行碎片生命周期一次性懒加载
        viewPager.setOffscreenPageLimit(8);

        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs =root. findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        return root;
    }
}
