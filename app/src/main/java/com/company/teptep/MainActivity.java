package com.company.teptep;

import com.company.base.ProxyActivity;
import com.company.teptep.fragment.TepMainFragment;

import me.yokeyword.fragmentation.ISupportFragment;

public class MainActivity extends ProxyActivity {
    @Override
    protected ISupportFragment setRootFragment() {
        return new TepMainFragment();
    }
}
