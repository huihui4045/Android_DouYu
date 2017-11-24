package com.alizhezi.douyu.view.base;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.alizhezi.douyu.utils.LogUtil;

/**
 * Created by gavin
 * Time 2017/11/24  17:12
 * Email:molu_clown@163.com
 */

public abstract class FullScreenActivity extends BaseAppCompatActivity {

    @Override
    protected void getIntentExtras(Bundle extras) {

        LogUtil.e("FullScreenActivity","getIntentExtras");

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getFullScreenIntentExtras(extras);

    }

    //获取传递参数
    protected abstract void getFullScreenIntentExtras(Bundle extras);

}
