package com.example.yasma.view.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.yasma.view.fragments.AlbumsFragment;
import com.example.yasma.view.fragments.PostsFragment;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter
{
    private List<Fragment> mFragments;

    public ViewPagerAdapter (FragmentManager fm)
    {
        super(fm);
        mFragments = new ArrayList<>();
    }

    public ViewPagerAdapter (FragmentManager fm, List<Fragment> fragments)
    {
        super(fm);
        mFragments = fragments;
    }

    @Override
    public Fragment getItem (int position)
    {
        switch (position){
            case 0:
                return new PostsFragment();
            case 1:
                return new AlbumsFragment();
            default:
                return null;
        }
    }


    @Override
    public int getCount ()
    {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle (int position)
    {
        // TODO: implement your own page title.
        return mFragments.get(position).getClass().getSimpleName();
    }
}
