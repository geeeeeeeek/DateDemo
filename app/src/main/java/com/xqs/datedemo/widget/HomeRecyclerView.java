package com.xqs.datedemo.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;


public class HomeRecyclerView extends RecyclerView {
    private OnLoadMoreListener mOnLoadMoreListener;
    private static final int VISIBLE_THRESHOLD = 1;

    private boolean isLoadingMore = false;

    public HomeRecyclerView(Context context) {
        this(context, null);
    }

    public HomeRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HomeRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        // Default is linear
        setLayoutManager(new LinearLayoutManager(getContext()));
    }

    public void setLoadMoreListener(final OnLoadMoreListener loadMoreListener) {
        if (loadMoreListener == null) {
            return;
        }
        mOnLoadMoreListener = loadMoreListener;

        addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int lastVisibleItem = ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastVisibleItemPosition();
                int totalItemCount = recyclerView.getLayoutManager().getItemCount();

                // LastVisibleItem >= totalItemCount - VISIBLE_THRESHOLD
                // It will auto load more if left VISIBLE_THRESHOLD items.
                // If dy > 0 --> pull down

                if (lastVisibleItem >= totalItemCount - VISIBLE_THRESHOLD && dy > 0) {
                    if (!isLoadingMore) {
                        isLoadingMore = true;
                        mOnLoadMoreListener.onLoadMore();
                    }
                }
            }
        });
    }

    public void loadMoreComplete() {
        isLoadingMore = false;
    }

    public boolean isLoadingMore() {
        return isLoadingMore;
    }

    public interface OnLoadMoreListener {
        void onLoadMore();
    }
}
