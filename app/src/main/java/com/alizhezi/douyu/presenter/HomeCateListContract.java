package com.alizhezi.douyu.presenter;

import android.content.Context;

import com.alizhezi.douyu.base.BaseModel;
import com.alizhezi.douyu.base.BasePresenter;
import com.alizhezi.douyu.base.BaseView;
import com.alizhezi.douyu.model.logic.home.bean.HomeCateList;

import java.util.List;

import rx.Observable;

/**
 * Created by gavin
 * Time 2017/11/30  16:07
 * Email:molu_clown@163.com
 */

public interface HomeCateListContract {

    interface View extends BaseView{

        void getHomeAllList(List<HomeCateList> cateLists);
    }

    interface Model extends BaseModel{

        Observable getHomeCateList(Context context);
    }

    abstract class Presenter extends BasePresenter<View,Model>{

        public abstract void  getHomeCateList();
    }
}
