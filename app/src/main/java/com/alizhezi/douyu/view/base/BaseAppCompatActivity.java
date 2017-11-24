package com.alizhezi.douyu.view.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.alizhezi.douyu.utils.LogUtil;

import butterknife.ButterKnife;

/**
 * Created by gavin
 * Time 2017/11/24  15:00
 * Email:molu_clown@163.com
 */

public abstract class BaseAppCompatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LogUtil.e("BaseAppCompatActivity","getIntentExtras");

        getIntentExtras(getIntent().getExtras());


        if (getContentViewLayout() != 0) {

            setContentView(getContentViewLayout());
        } else {

            throw new IllegalArgumentException("返回一个正确的ContentView");
        }

    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);

        initViewAndListener();

    }


    //获取传递参数
    protected abstract void getIntentExtras(Bundle extras);

    //获取布局view id  加载布局
    protected abstract int getContentViewLayout();


    protected abstract void initViewAndListener();
}
