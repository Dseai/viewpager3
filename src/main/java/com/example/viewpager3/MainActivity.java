package com.example.viewpager3;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements OnPageChangeListener{
    private ViewPager pager;
    private List<View> viewList;
    private List<String> titleList;
    private PagerTabStrip tab;
    private List<Fragment> fragList;

    public MainActivity() {
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        //将layout转变为view对象
        View view1 = View.inflate(this, R.layout.view1, null);
        View view2 = View.inflate(this, R.layout.view2, null);
        View view3 = View.inflate(this, R.layout.view3, null);
        View view4 = View.inflate(this, R.layout.view4, null);
        /**
         * 通过view对象创建数据源
         */

        /**
         * 添加标题
         */
        titleList = new ArrayList();
        titleList.add("第一页");
        titleList.add("第二页");
        titleList.add("第三页");
        titleList.add("第四页");
        tab = (PagerTabStrip)this.findViewById(R.id.tab);
        /**
         * 为pager title设置一些属性
         */
        this.tab.setBackgroundColor(Color.WHITE);
        this.tab.setTabIndicatorColor(Color.GRAY);
        this.tab.setDrawFullUnderline(false);//不显示下面的线
        this.tab.setTextColor(Color.BLACK);
        tab.setClickable(true);
        this.pager = (ViewPager)this.findViewById(R.id.pager);
        /**
         * 通过fragment创建数据源
         */
        this.fragList = new ArrayList();
        this.fragList.add(new Fragment1());
        this.fragList.add(new Fragment2());
        this.fragList.add(new Fragment3());
        this.fragList.add(new Fragment4());
        //创建适配器
        MyFragmentPagerAdapter adapter=new MyFragmentPagerAdapter(getSupportFragmentManager(),fragList,titleList);
        this.pager.setAdapter(adapter);
        pager.addOnPageChangeListener(this);

    }

    public void onPageScrollStateChanged(int arg0) {
    }

    public void onPageScrolled(int arg0, float arg1, int arg2) {
    }


    /**
     *
     * @param arg0  =position 表示当前所在位置
     */
   public void onPageSelected(int arg0) {
        Toast.makeText(this, "这是第" + (arg0 + 1) + "个界面", Toast.LENGTH_SHORT).show();
    }

}

