package com.company.base.nav;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.core.graphics.drawable.DrawableCompat;

import com.company.base.TepBaseFragment;
import com.company.teptep.R;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * 底部导航条Fragment基类
 */
abstract public class BaseBottomFragment extends TepBaseFragment implements View.OnClickListener {

    private final ArrayList<BottomTabBean> mTabBeans = new ArrayList<>();
    private final ArrayList<TepBaseBottomItemFragment> mItemFragments = new ArrayList<>();
    private final LinkedHashMap<BottomTabBean, TepBaseBottomItemFragment> mItems = new LinkedHashMap<>();

    private int mCurrentFragment = 0;
    private int mIndexFragment = 0;
    private int mClickedColor = Color.WHITE;

    //用一个LinearLayout去承载底部各个Item
    private LinearLayout mBottomBar;

    @Override
    protected Object setLayout() {
        return R.layout.fragment_bottom;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIndexFragment = setIndexFragment();
        LinkedHashMap<BottomTabBean, TepBaseBottomItemFragment> items = setBottomItems(new BottomItemBuilder());
        mItems.putAll(items);
        mItems.forEach((key, value) -> {
            mTabBeans.add(key);
            mItemFragments.add(value);
        });

    }

    @Override
    protected void onBindView(Bundle savedInstanceState, View rootView) {
        mBottomBar = findView(R.id.bottom_bar);
        for (int i = 0; i < mItems.size(); i++) {
            LayoutInflater.from(getContext()).inflate(R.layout.bottom_item_icon_title, mBottomBar);
            RelativeLayout item = (RelativeLayout) mBottomBar.getChildAt(i);
            //tag用于辨认点击事件
            item.setTag(i);
            item.setOnClickListener(this);

            ImageView itemIcon = (ImageView) item.getChildAt(0);
            TextView itemTitle = (TextView) item.getChildAt(1);

            BottomTabBean tabBean = mTabBeans.get(i);
            itemIcon.setImageResource(tabBean.getIcon());
            itemTitle.setText(tabBean.getTitle());

        }

        int size = mItemFragments.size();
        getSupportDelegate().loadMultipleRootFragment(R.id.bottom_bar_fragment_container,
                mIndexFragment,
                mItemFragments.toArray(new TepBaseBottomItemFragment[size]));

        changStyle(mIndexFragment);
    }

    /**
     * 设置底部各个Tab
     *
     * @return
     */
    protected abstract LinkedHashMap<BottomTabBean, TepBaseBottomItemFragment> setBottomItems(BottomItemBuilder builder);

    /**
     * 设置默认展示第几个Fragment
     *
     * @return
     */
    protected abstract int setIndexFragment();

    @Override
    public void onClick(View v) {
        int tabIndex = (int) v.getTag();
        switchPage(tabIndex, mCurrentFragment);
        mCurrentFragment = tabIndex;

        changStyle(tabIndex);
    }

    private void resetStyle(){
        for (int i = 0; i < mBottomBar.getChildCount(); i++) {
            RelativeLayout item = (RelativeLayout) mBottomBar.getChildAt(i);
            ImageView icon = (ImageView) item.getChildAt(0);
            TextView title = (TextView) item.getChildAt(1);
            DrawableCompat.setTint(icon.getDrawable(),Color.parseColor("#89000000"));
            title.setTextColor(Color.parseColor("#89000000"));
        }
    }

    private void changStyle(int tabIndex){
        resetStyle();
        RelativeLayout item = (RelativeLayout) mBottomBar.getChildAt(tabIndex);
        ImageView icon = (ImageView) item.getChildAt(0);
        TextView title = (TextView) item.getChildAt(1);
        DrawableCompat.setTint(icon.getDrawable(),Color.parseColor("#89FFFFFF"));
        title.setTextColor(Color.parseColor("#89FFFFFF"));
    }



    /**
     * 切换页面
     *
     * @param desIndex
     * @param currentIndex
     */
    private void switchPage(int desIndex, int currentIndex) {
        getSupportDelegate().showHideFragment(mItemFragments.get(desIndex), mItemFragments.get(currentIndex));
    }
}
