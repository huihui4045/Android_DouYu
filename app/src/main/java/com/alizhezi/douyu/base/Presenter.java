package com.alizhezi.douyu.base;

/**
 * Created by gavin
 * Time 2017/11/29  14:42
 * Email:molu_clown@163.com
 */

public interface Presenter<View,Model> {

    //    绑定View控件
    void attachView(View view);
    //    绑定Model
    void attachModel(Model model);
    //    注销View控件
    void detachView();
    //    注销Model对象
    void detachModel();
}
