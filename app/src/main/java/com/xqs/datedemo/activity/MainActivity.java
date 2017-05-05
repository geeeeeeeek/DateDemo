package com.xqs.datedemo.activity;

import android.app.Activity;
import android.os.Bundle;

import com.xqs.datedemo.R;
import com.xqs.datedemo.widget.HomeRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity {

    @BindView(R.id.recyclerView) HomeRecyclerView mHomeRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}
