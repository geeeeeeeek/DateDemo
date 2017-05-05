package com.xqs.datedemo.adapter;

import android.content.Context;
import android.util.Log;

import com.xqs.datedemo.R;
import com.xqs.datedemo.model.Person;

public class HomeAdapter extends BaseAdapter<Person> {


    public HomeAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, Person data, int position) {
        holder.setText(R.id.tv_name,data.name);
        Log.w("pic","pic "+data.picUrl);
        holder.loadImage(R.id.iv_pic,data.picUrl);
    }

    @Override
    protected int getItemViewLayoutId(int position, Person data) {
        return R.layout.cell_home_item;
    }
}
