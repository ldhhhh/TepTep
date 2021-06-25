package com.company.teptep.fragment.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.company.base.nav.TepBaseBottomItemFragment;
import com.company.teptep.databinding.FragmentNewsBinding;

import org.jetbrains.annotations.NotNull;

public class NewsFragment extends TepBaseBottomItemFragment {
    private FragmentNewsBinding mBinding;

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = FragmentNewsBinding.inflate(inflater);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected Object setLayout() {
        return mBinding.getRoot();
    }

    @Override
    protected void onBindView(Bundle savedInstanceState, View rootView) {

    }

    @Override
    protected boolean setDoubleClickExit() {
        return false;
    }
}
