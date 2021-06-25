package com.company.base;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.company.teptep.R;

import me.yokeyword.fragmentation.ISupportFragment;
import me.yokeyword.fragmentation.SupportActivity;
import me.yokeyword.fragmentation.SupportActivityDelegate;

public abstract class ProxyActivity extends SupportActivity{
    private SupportActivityDelegate mDelegate = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDelegate = new SupportActivityDelegate(this);
        mDelegate.onCreate(savedInstanceState);
        initContainer(savedInstanceState);
    }

    /**
     * 初始化容器控件
     * @param savedInstanceState
     */
    private void initContainer(Bundle savedInstanceState) {
        FrameLayout container = new FrameLayout(this);
        container.setId(R.id.fragment_container);
        setContentView(container);
        if (savedInstanceState == null) {
            mDelegate.loadRootFragment(R.id.fragment_container, setRootFragment());
        }
    }

    /**
     * 设置Activity的根Fragment
     * @return
     */
    abstract protected ISupportFragment setRootFragment();


    @Override
    public SupportActivityDelegate getSupportDelegate() {
        return mDelegate;
    }

    @Override
    protected void onDestroy() {
        mDelegate.onDestroy();
        super.onDestroy();
    }
}
