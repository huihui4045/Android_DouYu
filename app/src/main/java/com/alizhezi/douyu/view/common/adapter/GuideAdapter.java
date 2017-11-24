package com.alizhezi.douyu.view.common.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.alizhezi.douyu.MainActivity;
import com.alizhezi.douyu.R;
import com.alizhezi.douyu.view.common.GuideActivity;

/**
 * Created by gavin
 * Time 2017/11/24  15:06
 * Email:molu_clown@163.com
 */

public class GuideAdapter  extends PagerAdapter {

    private int [] guides;
    private Context context;

    public GuideAdapter(int[] guides, Context context) {
        this.guides = guides;
        this.context = context;
    }

    @Override
    public int getCount() {
        return guides==null?0:guides.length;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view = View.inflate(context, R.layout.item_guide, null);

        ImageView iv_guide = (ImageView) view.findViewById(R.id.iv_guide);
        Button btn_guide = (Button) view.findViewById(R.id.btn_guide);
        if (position == 3)
            btn_guide.setVisibility(View.VISIBLE);
        btn_guide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, MainActivity.class));
                ((GuideActivity) context).finish();
            }
        });
        iv_guide.setBackgroundResource(guides[position]);
        container.addView(view, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);


        return view;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       container.removeView((View) object);
    }
}
