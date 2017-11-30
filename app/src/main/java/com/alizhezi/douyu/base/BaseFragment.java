package com.alizhezi.douyu.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alizhezi.douyu.model.ContractProxy;
import com.trello.rxlifecycle.components.support.RxFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by gavin
 * Time 2017/11/29  16:09
 * Email:molu_clown@163.com
 */

public abstract class BaseFragment<M extends BaseModel,P extends BasePresenter> extends RxFragment {

    protected View mRootView;

    protected Context mContext;

    private boolean isViewPrepared; //视图已经加载完毕

    private  boolean hasFetchData;//标志已经触发过懒加载数据

    private P mPresenter;
    private Unbinder bind;

    protected abstract int getLayoutId();

    protected abstract void onInitView(Bundle bundle);

    protected abstract void onEvent();

    //获取抽象View对象
    protected abstract BaseView  getViewImp();

    //获取抽象接口Model对象
    protected Class getModelClazz(){


        return ContractProxy.getModelClazz(getClass(),0);
    }

    protected Class getPresenterClazz(){

        return ContractProxy.getPresnterClazz(getClass(),1);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext=getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        if (mRootView!=null){

          ViewGroup parent= (ViewGroup) mRootView.getParent();

          if (parent!=null)
              parent.removeView(mRootView);

          return mRootView;
        }


        if (getLayoutId()!=0){

            mRootView=inflater.inflate(getLayoutId(),container,false);
        }else {
            mRootView=super.onCreateView(inflater,container,savedInstanceState);
        }


        bind = ButterKnife.bind(this, mRootView);

        bindMVP();

        onInitView(savedInstanceState);


        return mRootView;
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (isVisibleToUser){

            lazyFetchDataIfPrepared();
        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        isViewPrepared=true;

        lazyFetchDataIfPrepared();

        if (mPresenter==null){

            bindMVP();
        }


    }

    /**
     *  进行懒加载
     */
    private void lazyFetchDataIfPrepared() {
        // 用户可见fragment && 没有加载过数据 && 视图已经准备完毕
        if (getUserVisibleHint() && !hasFetchData && isViewPrepared) {
            hasFetchData = true;
            lazyFetchData();
        }

    }

    /**
     * 懒加载的方式获取数据，仅在满足fragment可见和视图已经准备好的时候调用一次
     */
    protected abstract void lazyFetchData() ;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        onEvent();
    }

    @Override
    public void onStart() {
        if (mPresenter==null){

            bindMVP();
        }
        super.onStart();
    }

    private void bindMVP() {

        if (getPresenterClazz()!=null){

            mPresenter=getPresenterImpl();
            
            mPresenter.mContext=getActivity();
            
            bindVM();


        }
    }

    private void bindVM() {

        if (mPresenter!=null &&!mPresenter.isViewBind()&&getModelClazz()!=null&&getViewImp()!=null){

            ContractProxy.getInstance().bindModel(getModelClazz(),mPresenter);
            ContractProxy.getInstance().bindView(getViewImp(),mPresenter);

            mPresenter.mContext=getActivity();
        }
    }

    private <T> T getPresenterImpl()
    {
        return ContractProxy.getInstance().presenter(getPresenterClazz());
    }
}
