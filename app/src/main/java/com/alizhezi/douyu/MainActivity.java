package com.alizhezi.douyu;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.alizhezi.douyu.utils.LogUtil;
import com.alizhezi.douyu.view.base.BaseAppCompatActivity;
import com.alizhezi.douyu.view.follow.FollowFragment;
import com.alizhezi.douyu.view.home.HomeFragment;
import com.alizhezi.douyu.view.live.LiveFragment;
import com.alizhezi.douyu.view.user.UserFragment;
import com.alizhezi.douyu.view.video.VideoFragment;

import butterknife.BindView;

public class MainActivity extends BaseAppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    @BindView(R.id.content_layout)
    FrameLayout contentLayout;
    @BindView(R.id.bottomNavigationView)
    BottomNavigationView bottomNavigationView;

    private FragmentManager mManager;
    private FragmentTransaction transaction;

    private HomeFragment mHomeFragment;

    private LiveFragment mLiveFragment;

    private VideoFragment mVideoFragment;

    private FollowFragment mFollowFragment;

    private UserFragment mUserFragment;

    private String TAG = this.getClass().getSimpleName();


    @Override
    protected void getIntentExtras(Bundle extras) {

        mManager = getSupportFragmentManager();


    }

    @Override
    protected int getContentViewLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViewAndListener() {

        bottomNavigationView.setOnNavigationItemSelectedListener(this);


        mHomeFragment = HomeFragment.newInstance();
        transaction = mManager.beginTransaction();

        transaction.add(R.id.content_layout, mHomeFragment);

        transaction.commitAllowingStateLoss();

        index = R.id.home_navigation_home;
    }


    private int index;

    boolean flag = false;

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


        LogUtil.e(TAG, "onNavigationItemSelected：" + item.getTitle());


        if (index != item.getItemId()) {

            transaction = mManager.beginTransaction();


            switch (item.getItemId()) {

                case R.id.home_navigation_home:

                    if (mHomeFragment == null)
                        mHomeFragment = HomeFragment.newInstance();


                    transaction.replace(R.id.content_layout, mHomeFragment);


                    flag = true;
                    break;

                case R.id.home_navigation_live:


                    if (mLiveFragment == null)
                        mLiveFragment = LiveFragment.newInstance();

                    transaction.replace(R.id.content_layout, mLiveFragment);


                    flag = true;
                    break;

                case R.id.home_navigation_video:

                    if (mVideoFragment == null)
                        mVideoFragment = VideoFragment.newInstance();

                    transaction.replace(R.id.content_layout, mVideoFragment);

                    flag = true;
                    break;

                case R.id.home_navigation_follow:

                    if (mFollowFragment == null)
                        mFollowFragment = FollowFragment.newInstance();

                    transaction.replace(R.id.content_layout, mFollowFragment);

                    flag = true;
                    break;

                case R.id.home_navigation_user:

                    if (mUserFragment == null)
                        mUserFragment = UserFragment.newInstance();

                    transaction.replace(R.id.content_layout, mUserFragment);


                    flag = true;
                    break;
            }

            transaction.commitAllowingStateLoss();

        }else {

            LogUtil.e(TAG,"没有切换");

            flag=false;
        }

        index = item.getItemId();



        return flag;
    }
}
