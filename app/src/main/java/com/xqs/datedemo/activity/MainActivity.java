package com.xqs.datedemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.xqs.datedemo.R;
import com.xqs.datedemo.adapter.HomeAdapter;
import com.xqs.datedemo.model.Person;
import com.xqs.datedemo.widget.HomeRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity {

    @BindView(R.id.recyclerView)
    HomeRecyclerView mHomeRecyclerView;

    private HomeAdapter homeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initData();

        loadData();

    }

    private void initData() {
        homeAdapter = new HomeAdapter(this);
        mHomeRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mHomeRecyclerView.setAdapter(homeAdapter);
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
