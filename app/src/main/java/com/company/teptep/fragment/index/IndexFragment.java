package com.company.teptep.fragment.index;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.company.base.nav.TepBaseBottomItemFragment;
import com.company.teptep.adapter.MyViewPager2Adapter;
import com.company.teptep.data.DataServer;
import com.company.teptep.databinding.FragmentIndexBinding;
import com.company.teptep.entity.Game;
import com.company.teptep.fragment.ViewPager2ContentFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class IndexFragment extends TepBaseBottomItemFragment {
    private FragmentIndexBinding mBinding;
    private List<Fragment> fragments;
    private ArrayList<Game> games;

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = FragmentIndexBinding.inflate(inflater);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected void onBindView(Bundle savedInstanceState, View rootView) {
        loadData();
        initViewPager2();
    }

    private void loadData() {
        games = DataServer.getRecommendationData();
    }


    /**
     * 初始化ViewPager2
     */
    private void initViewPager2() {
        initViewPagerFragments();

        mBinding.indexViewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        mBinding.indexViewPager2.setAdapter(new MyViewPager2Adapter(IndexFragment.this,fragments));
        mBinding.indexViewPager2.setOffscreenPageLimit(2);

        mediateTabLayoutAndViewPager2();
    }


    /**
     * 创建ViewPager2中要加载的fragment列表
     */
    private void initViewPagerFragments() {
        fragments = new ArrayList<>();
        fragments.add(ViewPager2ContentFragment.create(games));
        fragments.add(ViewPager2ContentFragment.create(games));

    }

    /**
     * 联动ViewPager2与TabLayout
     */
    private void mediateTabLayoutAndViewPager2(){
        List<String> tabNameList = new ArrayList<>();
        tabNameList.add("推荐");
        tabNameList.add("即将上线");
        new TabLayoutMediator(mBinding.indexTabLayout, mBinding.indexViewPager2, true, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(TabLayout.Tab tab, int position) {
                tab.setText(tabNameList.get(position));
            }
        }).attach();
    }

    @Override
    protected boolean setDoubleClickExit() {
        return false;
    }

    @Override
    protected Object setLayout() {
        return mBinding.getRoot();
    }
}
