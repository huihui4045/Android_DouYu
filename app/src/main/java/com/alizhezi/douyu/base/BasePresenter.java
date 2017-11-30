package com.alizhezi.douyu.base;

import android.content.Context;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by gavin
 * Time 2017/11/29  15:28
 * Email:molu_clown@163.com
 * 类描述：
 *         1.获取绑定View实例传递到子类中进行调用!
 *
 *         2.注销View实例
 *
 *         3.创建 Model 实例
 *
 *         4.注销Model实例
 *
 *         5.通过RxJava进行绑定activity和fragment生命周期绑定
 */

public class BasePresenter<V extends BaseView,M extends BaseModel> implements Presenter<V,M> {

    protected Context mContext;

    protected V mView;

    protected M mMode;


    protected CompositeSubscription mCompositeSubscription;


    protected void addSubscribe(Subscription subscription){
        if (mCompositeSubscription==null)
            mCompositeSubscription=new CompositeSubscription();

        mCompositeSubscription.add(subscription);
    }

    protected void unSubscribe(){
        if (mCompositeSubscription!=null)
            mCompositeSubscription.unsubscribe();
    }

    @Override
    public void attachView(V v) {

        this.mView=v;
    }

    @Override
    public void attachModel(M m) {

        this.mMode=m;
    }

    @Override
    public void detachView() {

        this.mView=null;
        unSubscribe();
    }

    @Override
    public void detachModel() {

        this.mMode=null;
    }

    public M getModel() {
        return mMode;
    }

    public V getView() {
        return mView;
    }

    public boolean isViewBind()
    {
        return mView!=null;
    }
}
