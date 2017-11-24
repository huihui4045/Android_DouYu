package com.alizhezi.douyu.view.common;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.alizhezi.douyu.R;
import com.alizhezi.douyu.utils.LogUtil;
import com.alizhezi.douyu.view.base.FullScreenActivity;
import com.alizhezi.douyu.view.common.adapter.GuideAdapter;

import butterknife.BindView;

public class GuideActivity extends FullScreenActivity {


    @BindView(R.id.viewPage)
    ViewPager viewPage;

    int[] guides = new int[]{R.mipmap.guide_bg1, R.mipmap.guide_bg2, R.mipmap.guide_bg3, R.mipmap.guide_bg4};


    private String TAG=this.getClass().getSimpleName();



    @Override
    protected void getFullScreenIntentExtras(Bundle extras) {
        LogUtil.e(TAG,"getFullScreenIntentExtras");
    }

    @Override
    protected int getContentViewLayout() {


        return R.layout.activity_guide;
    }

    @Override
    protected void initViewAndListener() {


        GuideAdapter adapter = new GuideAdapter(guides, this);
        viewPage.setAdapter(adapter);
    }



    //Error:java.lang.RuntimeException: Annotation processors must be explicitly declared now.
    //The following dependencies on the compile classpath are found to contain annotation processor.  Please add them to the annotationProcessor configuration.
}
