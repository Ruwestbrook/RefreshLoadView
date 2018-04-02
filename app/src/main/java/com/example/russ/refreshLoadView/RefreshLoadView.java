package com.example.russ.refreshLoadView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by russ on 18-4-2.
 * 可以实现上拉加载更多和下拉刷新的RecyclerView
 */

public class RefreshLoadView extends RecyclerView {
    private boolean isRefresh;
    private boolean isLoad;
    public RefreshLoadView(Context context) {
        this(context,null);
    }

    public RefreshLoadView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public RefreshLoadView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        isRefresh=true;
        isLoad=true;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    abstract static class Adapter<VH extends ViewHolder> extends RecyclerView.Adapter{


    }
}
