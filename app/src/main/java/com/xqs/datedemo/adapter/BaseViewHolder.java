package com.xqs.datedemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.xqs.datedemo.R;


public class BaseViewHolder extends RecyclerView.ViewHolder {
    private final SparseArray<View> mViews;
    private Context mContext;

    public BaseViewHolder(View itemView, Context context) {
        super(itemView);
        mViews = new SparseArray<>();
        mContext = context;
    }

    @SuppressWarnings("unchecked")
    public <TView extends View> TView getView(int id) {
        View view = mViews.get(id);
        if (view == null) {
            view = itemView.findViewById(id);
            mViews.put(id, view);
        }
        return (TView) view;
    }

    public BaseViewHolder setText(int viewId, CharSequence value) {
        TextView view = getView(viewId);
        view.setText(value);
        return this;
    }

    public BaseViewHolder setTextSize(int viewId, int textSizeDP) {
        TextView view = getView(viewId);
        view.setTextSize(TypedValue.COMPLEX_UNIT_DIP, textSizeDP);
        return this;
    }

    public BaseViewHolder loadImage(int viewId, String URL) {
        ImageView view = getView(viewId);
        Glide.with(mContext)
                .load(URL)
                .placeholder(R.mipmap.work_item_default)
                .dontAnimate()
                .into(view);
        return this;
    }

    public BaseViewHolder loadImage(int viewId, int resId) {
        ImageView view = getView(viewId);
        Glide.with(mContext)
                .load(resId)
                .into(view);
        return this;
    }

    public BaseViewHolder loadImage(int viewId, String URL, Drawable placeholder) {
        ImageView view = getView(viewId);
        Glide.with(mContext)
                .load(URL)
                .placeholder(placeholder)
                .dontAnimate()
                .into(view);
        return this;
    }

    public BaseViewHolder loadAvatar(int viewId, String URL) {
        ImageView view = getView(viewId);
        Glide.with(mContext)
                .load(URL)
//                .bitmapTransform(new CropCircleTransformation(mContext))
//                .placeholder(App.sAvatarPlaceholder)
                .dontAnimate()
                .into(view);
        return this;
    }

    public BaseViewHolder setTextColor(int viewId, int textColor) {
        TextView view = getView(viewId);
        view.setTextColor(textColor);
        return this;
    }

    public BaseViewHolder setTextColorRes(int viewId, int textColorRes) {
        TextView view = getView(viewId);
        view.setTextColor(mContext.getResources().getColor(textColorRes));
        return this;
    }

    public BaseViewHolder setImageResource(int viewId, int imageResId) {
        ImageView view = getView(viewId);
        view.setImageResource(imageResId);
        return this;
    }

    public BaseViewHolder setBackgroundColor(int viewId, int color) {
        View view = getView(viewId);
        view.setBackgroundColor(color);
        return this;
    }

    public BaseViewHolder setBackgroundResource(int viewId, int backgroundRes) {
        View view = getView(viewId);
        view.setBackgroundResource(backgroundRes);
        return this;
    }

    public BaseViewHolder setVisible(int viewId, boolean visible) {
        View view = getView(viewId);
        view.setVisibility(visible ? View.VISIBLE : View.GONE);
        return this;
    }

    public BaseViewHolder setTypeface(Typeface typeface, int... viewIds) {
        for (int viewId : viewIds) {
            TextView view = getView(viewId);
            view.setTypeface(typeface);
            view.setPaintFlags(view.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
        }
        return this;
    }

    public BaseViewHolder setOnClickListener(int viewId, View.OnClickListener listener) {
        View view = getView(viewId);
        view.setOnClickListener(listener);
        return this;
    }

    public BaseViewHolder setOnTouchListener(int viewId, View.OnTouchListener listener) {
        View view = getView(viewId);
        view.setOnTouchListener(listener);
        return this;
    }

    public BaseViewHolder setOnLongClickListener(int viewId, View.OnLongClickListener listener) {
        View view = getView(viewId);
        view.setOnLongClickListener(listener);
        return this;
    }

    public BaseViewHolder setTag(int viewId, Object tag) {
        View view = getView(viewId);
        view.setTag(tag);
        return this;
    }

    public BaseViewHolder startActivity(Class activity, Bundle bundle) {
        Intent intent = new Intent(mContext, activity);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        mContext.startActivity(intent);
        return this;
    }

    public BaseViewHolder startActivity(Class activity) {
        startActivity(activity, null);
        return this;
    }
}
