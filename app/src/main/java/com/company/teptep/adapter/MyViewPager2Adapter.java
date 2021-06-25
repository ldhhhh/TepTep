package com.company.teptep.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MyViewPager2Adapter extends FragmentStateAdapter {
    private final List<Fragment> fragments;

    public MyViewPager2Adapter(Fragment fragment , List<Fragment> fragments) {
        super(fragment);
        this.fragments = fragments;
    }

    @NonNull
    @NotNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }
}
