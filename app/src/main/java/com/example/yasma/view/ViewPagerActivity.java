package com.example.yasma.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.yasma.R;
import com.example.yasma.view.adapters.ViewPagerAdapter;
import com.example.yasma.view.fragments.AlbumsFragment;
import com.example.yasma.view.fragments.PostsFragment;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity {

    private List<Fragment> mFragments;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_viewpager);

        mFragments = new ArrayList<>();
        mFragments.add(new PostsFragment());
        mFragments.add(new AlbumsFragment());

        mViewPager = (ViewPager) findViewById(R.id.vp_fragments_container);
        mViewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), mFragments));

        mTabLayout = (TabLayout) findViewById(R.id.htab_tabs);
        mTabLayout.setupWithViewPager(mViewPager);



    }
}
