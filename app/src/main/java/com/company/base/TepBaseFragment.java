package com.company.base;


import com.blankj.utilcode.util.ToastUtils;

abstract public class TepBaseFragment extends BaseFragment {
    private long mTouchTime = 0;
    private static final long WAIT_TIME = 2000L;

    /**
     * 两秒内按两次返回键退出app（防止误操作）
     *
     * @param flag
     * @return
     */
    private boolean exitWithDoubleClick(boolean flag) {
        if (System.currentTimeMillis() - mTouchTime < WAIT_TIME) {
            _mActivity.finish();
        } else {
            mTouchTime = System.currentTimeMillis();
            ToastUtils.showShort("再按一次退出");
        }
        return flag;
    }

    /**
     * 是否双击退出页面
     *
     * @return
     */
    protected abstract boolean setDoubleClickExit();

    @Override
    public boolean onBackPressedSupport() {
        return exitWithDoubleClick(setDoubleClickExit());
    }

    // TODO: 2021/6/22 其他的Fragment通用设置
}
