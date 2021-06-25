package com.company.base.nav;

import androidx.annotation.DrawableRes;

/**
 * 底部导航项实体类
 */
public class BottomTabBean {
    private @DrawableRes int icon;
    private String title;

    public int getIcon() {
        return icon;
    }

    public BottomTabBean setIcon(int icon) {
        this.icon = icon;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public BottomTabBean setTitle(String title) {
        this.title = title;
        return this;
    }
}
