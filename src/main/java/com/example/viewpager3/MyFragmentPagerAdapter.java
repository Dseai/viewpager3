package com.example.viewpager3;

/**
 * Created by Administrator on 2016/5/21.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;
import java.util.List;

public class MyFragmentPagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> fragList;
    private List<String> titleList;

    public MyFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragList, List<String> titleList) {
        super(fm);
        this.fragList = fragList;
        this.titleList = titleList;
    }

    public Fragment getItem(int arg0) {

        return fragList.get(arg0);
    }

    public int getCount() {

        return fragList.size();
    }

    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }

    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    public Object instantiateItem(ViewGroup arg0, int arg1) {
        return super.instantiateItem(arg0, arg1);
    }

}
