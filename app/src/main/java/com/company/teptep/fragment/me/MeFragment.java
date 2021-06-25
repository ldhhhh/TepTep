package com.company.teptep.fragment.me;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.company.base.nav.TepBaseBottomItemFragment;
import com.company.teptep.databinding.FragmentMeBinding;

import org.jetbrains.annotations.NotNull;

public class MeFragment extends TepBaseBottomItemFragment {

    private FragmentMeBinding mBinding;
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = FragmentMeBinding.inflate(inflater);
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
