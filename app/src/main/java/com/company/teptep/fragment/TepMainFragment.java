package com.company.teptep.fragment;

import com.company.base.nav.BaseBottomFragment;
import com.company.base.nav.BottomItemBuilder;
import com.company.base.nav.BottomTabBean;
import com.company.base.nav.TepBaseBottomItemFragment;
import com.company.teptep.R;
import com.company.teptep.fragment.index.IndexFragment;
import com.company.teptep.fragment.me.MeFragment;
import com.company.teptep.fragment.news.NewsFragment;
import com.company.teptep.fragment.rank.RankFragment;

import java.util.LinkedHashMap;

public class TepMainFragment extends BaseBottomFragment {

    @Override
    protected LinkedHashMap<BottomTabBean, TepBaseBottomItemFragment> setBottomItems(BottomItemBuilder builder) {
        LinkedHashMap<BottomTabBean, TepBaseBottomItemFragment> items = new LinkedHashMap<>();
        items.put(
                new BottomTabBean().setIcon(R.drawable.ic_home).setTitle("首页"),
                new IndexFragment());
        items.put(
                new BottomTabBean().setIcon(R.drawable.ic_trophy).setTitle("排行"),
                new RankFragment());
        items.put(
                new BottomTabBean().setIcon(R.drawable.ic_news).setTitle("动态"),
                new NewsFragment());
        items.put(
                new BottomTabBean().setIcon(R.drawable.ic_me).setTitle("我的"),
                new MeFragment());
        return builder.addItems(items).build();
    }

    @Override
    protected int setIndexFragment() {
        return 0;
    }

    @Override
    protected boolean setDoubleClickExit() {
        return true;
    }
}
