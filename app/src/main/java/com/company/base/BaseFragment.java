package com.company.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.IdRes;

import org.jetbrains.annotations.NotNull;

import me.yokeyword.fragmentation.SupportFragment;

abstract public class BaseFragment extends SupportFragment {
    //根视图
    private View mRootView;

    /**
     * 可以传递一个xml布局id或者View
     */
    protected abstract Object setLayout();

    /**
     * 初始化视图后去执行的方法
     * @param savedInstanceState
     * @param rootView
     */
    protected abstract void onBindView(Bundle savedInstanceState,View rootView);

    protected <T extends View> T findView(@IdRes int viewId){
        return mRootView.findViewById(viewId);
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (setLayout() instanceof Integer){
            mRootView = inflater.inflate((int)setLayout(),container,false);
        }else if (setLayout() instanceof View){
            mRootView = (View)setLayout();
        }else {
            throw new ClassCastException("setLayout必须返回int或者View类型");
        }
        onBindView(savedInstanceState,mRootView);
        return mRootView;
    }

}
