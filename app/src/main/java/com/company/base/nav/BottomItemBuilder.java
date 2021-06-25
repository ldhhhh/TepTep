package com.company.base.nav;

import java.util.LinkedHashMap;

public class BottomItemBuilder {
    public static BottomItemBuilder builder(){
        return new BottomItemBuilder();
    }

    private final LinkedHashMap<BottomTabBean,TepBaseBottomItemFragment> mItems = new LinkedHashMap<>();

    public BottomItemBuilder addItems(LinkedHashMap<BottomTabBean,TepBaseBottomItemFragment> items){
        mItems.putAll(items);
        return this;
    }

    public LinkedHashMap<BottomTabBean,TepBaseBottomItemFragment> build(){
        return mItems;
    }
}
