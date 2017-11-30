package com.alizhezi.douyu.view.common;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.alizhezi.douyu.MainActivity;
import com.alizhezi.douyu.R;
import com.alizhezi.douyu.utils.SharedPreferenceUtils;
import com.alizhezi.douyu.view.base.FullScreenActivity;

public class SplashActivity extends FullScreenActivity {


    private boolean isFirst;
    private Handler mHandler = new Handler();
    private Intent intent;

    @Override
    protected int getContentViewLayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initViewAndListener() {
        isFirst = SharedPreferenceUtils.getBooleanData("isFirst", true);

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (isFinishing()) return;

                if (isFirst) {

                    intent = new Intent(SplashActivity.this, GuideActivity.class);

                    SharedPreferenceUtils.setBooleanData("isFirst", false);
                } else {

                    intent = new Intent(SplashActivity.this, MainActivity.class);
                }

                startActivity(intent);


                finish();

            }
        }, 3000);
    }

    @Override
    protected void getFullScreenIntentExtras(Bundle extras) {

    }
}
