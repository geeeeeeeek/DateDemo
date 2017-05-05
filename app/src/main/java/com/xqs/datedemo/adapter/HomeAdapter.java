package com.xqs.datedemo.adapter;

import android.content.Context;

import com.xqs.datedemo.model.Person;

/**
 * Created by xiaoqingsong on 2017/5/5.
 */

public class HomeAdapter extends BaseAdapter<Person> {


    public HomeAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, Person data, int position) {

    }

    @Override
    protected int getItemViewLayoutId(int position, Person data) {
        return 0;
    }
}
