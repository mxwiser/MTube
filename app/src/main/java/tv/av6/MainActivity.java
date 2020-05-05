package tv.av6;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {
  private   BottomNavigationView navView;
  private   AppBarConfiguration appBarConfiguration;
  private   MenuItem  backItem;
  private   MenuItem  thisItem;
  boolean backdesktop=false;
    NavController navController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            this.getWindow().getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }


        this.getSupportActionBar().hide();
        navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
         appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications,R.id.navigation_fl,R.id.navigation_my)
                .build();
         navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        navView.setItemIconTintList(null);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        closeAnimation(navView);
         backItem=   navView.getMenu().findItem(R.id.navigation_home);
         thisItem= navView.getMenu().findItem(R.id.navigation_home);
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
                navController.navigate(R.id.navigation_home);
                break;
            case R.id.navigation_dashboard:
                item.setIcon(R.drawable.src_images_tabiconsactive_video);
                item.setTitle(addColor("视频",getResources().getColor(R.color.feng)));
                navController.navigate(R.id.navigation_dashboard);
                break;
            case R.id.navigation_notifications:
                item.setIcon(R.drawable.src_images_tabiconsactive_category);
                item.setTitle(addColor("分类",getResources().getColor(R.color.feng)));
                navController.navigate(R.id.navigation_notifications);
                break;
            case  R.id.navigation_fl:
                item.setIcon(R.drawable.src_images_tabiconsactive_like);
                item.setTitle(addColor("收藏",getResources().getColor(R.color.feng)));
                navController.navigate(R.id.navigation_fl);
                break;
            case  R.id.navigation_my:
                item.setIcon(R.drawable.src_images_tabiconsactive_my);
                item.setTitle(addColor("我的",getResources().getColor(R.color.feng)));
                navController.navigate(R.id.navigation_my);
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

    @SuppressLint("RestrictedApi")
    public void closeAnimation(BottomNavigationView view) {

        BottomNavigationMenuView mMenuView = (BottomNavigationMenuView) view.getChildAt(0);
        for (int i = 0; i < mMenuView.getChildCount(); i++) {
            BottomNavigationItemView button = (BottomNavigationItemView) mMenuView.getChildAt(i);
            TextView mLargeLabel = getField(button.getClass(), button, "largeLabel");
            TextView mSmallLabel = getField(button.getClass(), button, "smallLabel");
            float mSmallLabelSize = mSmallLabel.getTextSize();
            setField(button.getClass(), button, "shiftAmount", 0F);
            setField(button.getClass(), button, "scaleUpFactor", 1F);
            setField(button.getClass(), button, "scaleDownFactor", 1F);
            mLargeLabel.setTextSize(TypedValue.COMPLEX_UNIT_PX, mSmallLabelSize);
        }
        mMenuView.updateMenuView();
    }


    private <T> T getField(Class targetClass, Object instance, String fieldName) {
        try {
            Field field = targetClass.getDeclaredField(fieldName);

            field.setAccessible(true);
            return (T) field.get(instance);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }


    private void setField(Class targetClass, Object instance, String fieldName, Object value) {
        try {
            Field field = targetClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(instance, value);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
