package com.xqs.datedemo.app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by xiaoqingsong on 2017/5/8.
 */

public abstract class BaseFragment extends Fragment {
    protected Activity mActivity;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (Activity)context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container
            , Bundle savedInstanceState) {

        View view = LayoutInflater.from(mActivity)
                .inflate(getLayoutId(), container, false);

        ButterKnife.bind(this,view);
        initView(view, savedInstanceState);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }


    protected abstract int getLayoutId();
    protected abstract void initView(View view, Bundle savedInstanceState);
    protected abstract void initData();
}
