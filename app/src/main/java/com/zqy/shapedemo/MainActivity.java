package com.zqy.shapedemo;

import android.content.Intent;
import android.view.View;

import butterknife.OnClick;

public class MainActivity extends BaseActivity  {

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected boolean isHasToolbar() {
        return false;
    }

    @OnClick({R.id.tv_line, R.id.tv_rect, R.id.tv_layer, R.id.tv_round, R.id.tv_gradient,
            R.id.tv_circle, R.id.tv_oval, R.id.tv_ring})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_line: {
                Intent intent = new Intent(this, LineActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.tv_rect: {
                Intent intent = new Intent(this, RectActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.tv_layer: {
                Intent intent = new Intent(this, LayerActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.tv_round: {
                Intent intent = new Intent(this, RoundActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.tv_gradient: {
                Intent intent = new Intent(this, GradientActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.tv_circle: {
                Intent intent = new Intent(this, CircleActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.tv_oval: {
                Intent intent = new Intent(this, OvalActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.tv_ring: {
                Intent intent = new Intent(this, RingActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
