package tv.av6;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {
  private   BottomNavigationView navView;
  private   AppBarConfiguration appBarConfiguration;
  private   MenuItem  backItem;
  private   MenuItem  thisItem;
  boolean backdesktop=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         this.getSupportActionBar().hide();
         navView = findViewById(R.id.nav_view);

         navView.setItemIconTintList(null);
         navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
         closeAnimation(navView);

         backItem=   navView.getMenu().findItem(R.id.navigation_home);
         thisItem= navView.getMenu().findItem(R.id.navigation_home);

    }

    @Override
    protected void onStart() {
        super.onStart();
        View v=findViewById(R.id.nav_view);
        v.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getApplication(),"123",Toast.LENGTH_LONG).show();
                return true;
            }
        });

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
