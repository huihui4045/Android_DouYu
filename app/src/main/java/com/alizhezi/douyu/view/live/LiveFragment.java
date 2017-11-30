package com.alizhezi.douyu.view.live;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alizhezi.douyu.R;
import com.alizhezi.douyu.view.home.HomeFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class LiveFragment extends Fragment {


    public LiveFragment() {
        // Required empty public constructor
    }


    public static LiveFragment newInstance() {
        LiveFragment fragment = new LiveFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_live, container, false);
    }

}
