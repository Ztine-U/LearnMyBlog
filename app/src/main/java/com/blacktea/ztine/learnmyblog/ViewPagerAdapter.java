package com.blacktea.ztine.learnmyblog;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ztine on 16/6/1.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragment;
    private List<String> mTitles;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        mFragment = new ArrayList<Fragment>();
        mTitles = new ArrayList<String>();


    }

    public void addFrament(Fragment fragment, String title) {
        mFragment.add(fragment);
        mTitles.add(title);
    }
    @Override
    public Fragment getItem(int position) {
        return mFragment.get(position);
    }

    @Override
    public int getCount() {
        return mFragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}
