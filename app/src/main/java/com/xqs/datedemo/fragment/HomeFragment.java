package com.xqs.datedemo.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.xqs.datedemo.R;
import com.xqs.datedemo.activity.MainActivity;
import com.xqs.datedemo.adapter.HomeAdapter;
import com.xqs.datedemo.app.BaseFragment;
import com.xqs.datedemo.model.Person;
import com.xqs.datedemo.widget.HomeRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by xiaoqingsong on 2017/5/8.
 */

public class HomeFragment extends BaseFragment {
    private static final String KEY_TITLE = "title";

    @BindView(R.id.recyclerView)
    HomeRecyclerView mHomeRecyclerView;

    @BindView(R.id.toggle)
    ImageView mToggle;

    private HomeAdapter homeAdapter;

    public HomeFragment(){

    }

    public static HomeFragment newInstance(String title) {
        HomeFragment f = new HomeFragment();

        Bundle args = new Bundle();

        args.putString(KEY_TITLE, title);
        f.setArguments(args);

        return (f);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

        mToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mActivity instanceof MainActivity){
                    ((MainActivity) mActivity).toggle();
                }
            }
        });
    }

    @Override
    protected void initData() {
        homeAdapter = new HomeAdapter(this.getContext());
        mHomeRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false));
        mHomeRecyclerView.setAdapter(homeAdapter);

        loadData();
    }

    private void loadData(){
        List<Person> list = new ArrayList<>();
        list.add(new Person());
        list.add(new Person());
        list.add(new Person());
        list.add(new Person());
        homeAdapter.addFirstDataSet(list);
    }
}
