package com.alizhezi.douyu.view.home;

import android.os.Bundle;

import com.alizhezi.douyu.R;
import com.alizhezi.douyu.base.BaseFragment;
import com.alizhezi.douyu.base.BaseView;
import com.alizhezi.douyu.model.logic.home.HomeCateListModelLogic;
import com.alizhezi.douyu.model.logic.home.bean.HomeCateList;
import com.alizhezi.douyu.presenter.HomeCateListContract;
import com.alizhezi.douyu.presenter.home.HomeCateListPresenterImp;

import java.util.List;

/**
 * Created by gavin
 * Time 2017/11/30  16:17
 * Email:molu_clown@163.com
 */

public class HomeFragment extends BaseFragment<HomeCateListModelLogic, HomeCateListPresenterImp> implements HomeCateListContract.View {



    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void onInitView(Bundle bundle) {

    }

    @Override
    protected void onEvent() {

    }

    @Override
    protected BaseView getViewImp() {
        return null;
    }

    @Override
    protected void lazyFetchData() {

    }

    @Override
    public void showErrorWithStatus(String msg) {

    }

    @Override
    public void getHomeAllList(List<HomeCateList> cateLists) {

    }
}
