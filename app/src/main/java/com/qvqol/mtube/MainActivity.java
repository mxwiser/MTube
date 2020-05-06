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
import com.qvqol.mtube.ui.mynav.BottomNavigationItemView;
import com.qvqol.mtube.ui.mynav.BottomNavigationView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;
public class MainActivity extends AppCompatActivity {
  private   BottomNavigationView navView;
  private   AppBarConfiguration appBarConfiguration;
  private   MenuItem  backItem;
  private   MenuItem  thisItem;
  private  BottomNavigationItemView homeitem,videoitem,flitem,likeitem,myitem;
  Badge homebagde,videobadge,flbadge,likebadge,mybadge;
  private boolean backdesktop=false;
  

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         this.getSupportActionBar().hide();
         navView = findViewById(R.id.nav_view);
         navView.setItemIconTintList(null);
         navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
         //closeAnimation(navView);
         backItem=navView.getMenu().findItem(R.id.navigation_home);
         thisItem=navView.getMenu().findItem(R.id.navigation_home);
         initView();
    }

    private void initView(){
        homeitem=navView.findViewById(R.id.navigation_home);
        videoitem=navView.findViewById(R.id.navigation_dashboard);
        flitem=navView.findViewById(R.id.navigation_notifications);
        likeitem=navView.findViewById(R.id.navigation_fl);
        myitem=navView.findViewById(R.id.navigation_my);
        homebagde=new QBadgeView(this).bindTarget(homeitem);
        videobadge=new QBadgeView(this).bindTarget(videoitem);
        flbadge=new QBadgeView(this).bindTarget(flitem);
        likebadge=new QBadgeView(this).bindTarget(likeitem);
        mybadge=new QBadgeView(this).bindTarget(myitem);
        homebagde.setBadgeGravity(Gravity.END|Gravity.TOP);
        videobadge.setBadgeGravity(Gravity.END|Gravity.TOP);
        flbadge.setBadgeGravity(Gravity.END|Gravity.TOP);
        likebadge.setBadgeGravity(Gravity.END|Gravity.TOP);
        mybadge.setBadgeGravity(Gravity.END|Gravity.TOP);

    }

    @Override
    protected void onStart() {
        super.onStart();
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
            case R.id.navigation_home:
                //在这里替换图标
                item.setIcon(R.drawable.src_images_tabiconsactive_av);
                item.setTitle(addColor("热门",getResources().getColor(R.color.feng)));
                break;
            case R.id.navigation_dashboard:
                item.setIcon(R.drawable.src_images_tabiconsactive_video);
                item.setTitle(addColor("视频",getResources().getColor(R.color.feng)));
                break;
            case R.id.navigation_notifications:
                item.setIcon(R.drawable.src_images_tabiconsactive_category);
                item.setTitle(addColor("分类",getResources().getColor(R.color.feng)));
                break;
            case  R.id.navigation_fl:
                item.setIcon(R.drawable.src_images_tabiconsactive_like);
                item.setTitle(addColor("收藏",getResources().getColor(R.color.feng)));
                break;
            case  R.id.navigation_my:
                item.setIcon(R.drawable.src_images_tabiconsactive_my);
                item.setTitle(addColor("我的",getResources().getColor(R.color.feng)));
                break;

        }

    }
    private void resetToDefaultIcon() {
        MenuItem home =  navView.getMenu().findItem(R.id.navigation_home);
        home.setIcon(R.drawable.src_images_tabicons_av);
        home.setTitle(addColor("热门",getResources().getColor(R.color.black)));
        MenuItem xsp=navView.getMenu().findItem(R.id.navigation_dashboard);
        xsp.setIcon(R.drawable.src_images_tabicons_video);
        xsp.setTitle(addColor("视频",getResources().getColor(R.color.black)));
        MenuItem fl=navView.getMenu().findItem(R.id.navigation_notifications);
        fl.setIcon(R.drawable.src_images_tabicons_category);
        fl.setTitle(addColor("分类",getResources().getColor(R.color.black)));
        MenuItem sc=navView.getMenu().findItem(R.id.navigation_fl);
        sc.setIcon(R.drawable.src_images_tabicons_like);
        sc.setTitle(addColor("收藏",getResources().getColor(R.color.black)));
        MenuItem my=navView.getMenu().findItem(R.id.navigation_my);
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







}
