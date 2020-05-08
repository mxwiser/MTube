package com.qvqol.mtube;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;
import q.rorbin.badgeview.Badge;
import q.rorbin.badgeview.QBadgeView;

import com.qvqol.mtube.ui.FirstItem.FirstFragment;
import com.qvqol.mtube.ui.SecondItem.SecondFragment;
import com.qvqol.mtube.ui.mynav.BottomNavigationItemView;
import com.qvqol.mtube.ui.mynav.BottomNavigationView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
  private   BottomNavigationView navView;
  private   MenuItem  backItem;
  private   MenuItem  thisItem;
  private  BottomNavigationItemView firstitem,seconditem,thirditem,fourthitem,fifthitem;
  private FragmentManager fragmentManager;
  private Fragment firstFragment,secondFragment;
  Badge firstbagde,secondbadge,thirdbadge,fourthbadge,fifthbadge;
  private boolean backdesktop=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
         this.getSupportActionBar().hide();
         navView = findViewById(R.id.nav_view);
         navView.setItemIconTintList(null);
         navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
         backItem=navView.getMenu().findItem(R.id.navigation_first);
         thisItem=navView.getMenu().findItem(R.id.navigation_first);
         initView();
    }
    private void initView(){
        firstitem=navView.findViewById(R.id.navigation_first);
        seconditem=navView.findViewById(R.id.navigation_second);
        thirditem=navView.findViewById(R.id.navigation_third);
        fourthitem=navView.findViewById(R.id.navigation_fourth);
        fifthitem=navView.findViewById(R.id.navigation_fifth);
        firstbagde=new QBadgeView(this).bindTarget(firstitem);
        secondbadge=new QBadgeView(this).bindTarget(seconditem);
        thirdbadge=new QBadgeView(this).bindTarget(thirditem);
        fourthbadge=new QBadgeView(this).bindTarget(fourthitem);
        fifthbadge=new QBadgeView(this).bindTarget(fifthitem);
        fifthbadge.setBadgeGravity(Gravity.END|Gravity.TOP);
        secondbadge.setBadgeGravity(Gravity.END|Gravity.TOP);
        thirdbadge.setBadgeGravity(Gravity.END|Gravity.TOP);
        fourthbadge.setBadgeGravity(Gravity.END|Gravity.TOP);
        fifthbadge.setBadgeGravity(Gravity.END|Gravity.TOP);
        //init fragment
        firstFragment=new FirstFragment();
        secondFragment=new SecondFragment();
        setDefaultFragment(firstFragment);

    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            backdesktop=true;
            switchNav(item);
            return false;
        }

    };
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (!backdesktop){
            return  super.onKeyDown(keyCode,event);
        }
        if (backItem!=null){
            switchNav(backItem);
            backdesktop=false;
        }
        return true;
    }
    private void switchNav(MenuItem item){
        if (thisItem!=item){
            backItem=thisItem;
        }
        thisItem=item;
        resetToDefaultIcon();//重置到默认不选中图片
        switch (item.getItemId()) {
            case R.id.navigation_first:
                //在这里替换图标
                item.setIcon(R.drawable.src_images_tabiconsactive_av);
                item.setTitle(addColor("热门",getResources().getColor(R.color.feng)));
                break;
            case R.id.navigation_second:
                item.setIcon(R.drawable.src_images_tabiconsactive_video);
                item.setTitle(addColor("视频",getResources().getColor(R.color.feng)));
                break;
            case R.id.navigation_third:
                item.setIcon(R.drawable.src_images_tabiconsactive_category);
                item.setTitle(addColor("分类",getResources().getColor(R.color.feng)));
                break;
            case  R.id.navigation_fourth:
                item.setIcon(R.drawable.src_images_tabiconsactive_like);
                item.setTitle(addColor("收藏",getResources().getColor(R.color.feng)));
                break;
            case  R.id.navigation_fifth:
                item.setIcon(R.drawable.src_images_tabiconsactive_my);
                item.setTitle(addColor("我的",getResources().getColor(R.color.feng)));
                break;
        }

    }
    private void resetToDefaultIcon() {
        MenuItem home =  navView.getMenu().findItem(R.id.navigation_first);
        home.setIcon(R.drawable.src_images_tabicons_av);
        home.setTitle(addColor("热门",getResources().getColor(R.color.black)));
        MenuItem xsp=navView.getMenu().findItem(R.id.navigation_second);
        xsp.setIcon(R.drawable.src_images_tabicons_video);
        xsp.setTitle(addColor("视频",getResources().getColor(R.color.black)));
        MenuItem fl=navView.getMenu().findItem(R.id.navigation_third);
        fl.setIcon(R.drawable.src_images_tabicons_category);
        fl.setTitle(addColor("分类",getResources().getColor(R.color.black)));
        MenuItem sc=navView.getMenu().findItem(R.id.navigation_fourth);
        sc.setIcon(R.drawable.src_images_tabicons_like);
        sc.setTitle(addColor("收藏",getResources().getColor(R.color.black)));
        MenuItem my=navView.getMenu().findItem(R.id.navigation_fifth);
        my.setIcon(R.drawable.src_images_tabicons_my);
        my.setTitle(addColor("我的",getResources().getColor(R.color.black)));
    }



    private SpannableStringBuilder addColor(CharSequence text, int color) {
        SpannableStringBuilder builder = new SpannableStringBuilder(text);
        if (color != 0) {
            builder.setSpan(new ForegroundColorSpan(color), 0, text.length(),
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return builder;
    }

    private Fragment mContent;
    //只调用一次设置默认fragment
    private void setDefaultFragment(Fragment fm) {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction mFragmentTrans = fragmentManager.beginTransaction();
        mFragmentTrans.add(R.id.nav_host_fragment, fm).commit();
        mContent = fm;
    }
    /**
     * 修改显示的内容 不会重新加载 *
     */
    public void switchContent(Fragment to) {
        if (mContent != to) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            if (!to.isAdded()) { // 先判断是否被add过
                transaction.hide(mContent).add(R.id.nav_host_fragment, to).commit(); // 隐藏当前的fragment，add下一个到Activity中
            } else {
                //transaction.hide(mContent).show(to).commit(); // 隐藏当前的fragment，显示下一个
                transaction.hide(mContent);
                transaction.show(to);
                transaction.commit();
            }
            mContent = to;
        }
    }
    /**
     * 修改显示的内容 但会重新加载 *
     */
    public void switchContent2(Fragment to){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.nav_host_fragment,to);
        //transaction.addToBackStack(null);
        transaction.commit();
    }
}
