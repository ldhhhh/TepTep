package com.company.teptep.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.company.base.TepBaseFragment;
import com.company.teptep.R;
import com.company.teptep.adapter.MyRVAdapter;
import com.company.teptep.databinding.FragmentRvBinding;
import com.company.teptep.entity.Game;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于承载游戏信息列表
 */
public class ViewPager2ContentFragment extends TepBaseFragment {
    private FragmentRvBinding mBinding;
    private List<Game> games;

    public static ViewPager2ContentFragment create(ArrayList<Game> games){
        ViewPager2ContentFragment viewPager2ContentFragment = new ViewPager2ContentFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("games",games);
        viewPager2ContentFragment.setArguments(bundle);
        return viewPager2ContentFragment;
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = FragmentRvBinding.inflate(inflater);
        return mBinding.getRoot();
    }

    /**
     * 初始化RV
     */
    private void initRV(){
        Bundle bundle = getArguments();
        if (bundle !=null) {
            games=bundle.getParcelableArrayList("games");
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mBinding.rv.setLayoutManager(linearLayoutManager);
        MyRVAdapter myRVAdapter = new MyRVAdapter(R.layout.rv_item_layout,games,_mActivity);
        mBinding.rv.setAdapter(myRVAdapter);
        myRVAdapter.notifyDataSetChanged();

    }

    @Override
    protected boolean setDoubleClickExit() {
        return false;
    }

    @Override
    protected Object setLayout() {
        return R.layout.fragment_rv;
    }

    @Override
    protected void onBindView(Bundle savedInstanceState, View rootView) {
        //initRV();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        initRV();
    }
}
