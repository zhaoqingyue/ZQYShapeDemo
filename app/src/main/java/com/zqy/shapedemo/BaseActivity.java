package com.zqy.shapedemo;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.gyf.barlibrary.ImmersionBar;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {

    protected ImmersionBar mImmersionBar;
    private Unbinder unbinder;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResID());
        unbinder = ButterKnife.bind(this);
        /**
         * 初始化沉浸式
         */
        if (isImmersionBarEnabled()) {
            initImmersionBar();
        }

        if (isHasToolbar()) {
            /**
             * 初始化Toolbar(
             */
            initToolbar();
        }

        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        if (mImmersionBar != null) {
            /**
             * 销毁mImmersionBar
             */
            mImmersionBar.destroy();
        }
    }

    protected abstract int getLayoutResID();

    protected abstract void initData();

    /**
     * 初始化mImmersionBar
     */
    protected void initImmersionBar() {
        mImmersionBar = ImmersionBar.with(this);
        if (ImmersionBar.isSupportStatusBarDarkFont()) {
            //状态栏字体颜色为深色(android6.0以上或者miuiv6以上或者flymeOS4+)
            mImmersionBar.statusBarDarkFont(true);
        }
        mImmersionBar.init();
        if (isHasToolbar()) {
            toolbar = (Toolbar) findViewById(R.id.toolbar);
            mImmersionBar.titleBar(toolbar).init();
        }
    }

    /**
     * 是否可以使用沉浸式
     */
    protected boolean isImmersionBarEnabled() {
        return true;
    }

    protected boolean isHasToolbar() {
        return false;
    }

    private void initToolbar() {
        if (toolbar != null) {
            toolbar.setTitle("");
            setSupportActionBar(toolbar);
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setHomeButtonEnabled(true);
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            /**
             * Toolbar导航按钮的按键事件
             */
            case android.R.id.home: {
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
