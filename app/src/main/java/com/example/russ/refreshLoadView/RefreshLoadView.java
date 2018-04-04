package com.example.russ.refreshLoadView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by russ on 18-4-2.
 * 可以实现上拉加载更多和下拉刷新的RecyclerView
 */

public class RefreshLoadView extends RecyclerView {
    private static final String TAG = "RefreshLoadView";
    private RefreshLoadView.Adapter mAdapter;

    public RefreshLoadView(Context context) {
        this(context,null);
    }

    public RefreshLoadView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public RefreshLoadView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }

    @Override
    public void setLayoutManager(LayoutManager layout) {
        super.setLayoutManager(layout);
        if(mAdapter.isRefresh){
            this.scrollToPosition(1);
        }
    }

    @Override
    public void setAdapter(RecyclerView.Adapter adapter) {
        super.setAdapter(adapter);
        mAdapter= (Adapter) adapter;

    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        ViewHolder(View itemView) {
            super(itemView);
        }
    }

     static class Adapter<VH extends ViewHolder> extends RecyclerView.Adapter{
         public boolean isRefresh;
         private boolean isLoad;
         private int itemNumber;

         Adapter(boolean isRefresh, boolean isLoad) {
             this.isRefresh = isRefresh;
             this.isLoad = isLoad;
         }

         @NonNull
         @Override
         public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
             if(viewType==-1){
                 return  new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.refresh,parent,false));
             }
             if(viewType==-2){
                 return  new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.load,parent,false));
             }
             return createItemViewHolder(parent, viewType);
         }


         public RecyclerView.ViewHolder createItemViewHolder(@NonNull ViewGroup parent, int viewType) {
             return null;
         }


         @Override
         public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
             if(position==0){
                 if(!isRefresh){
                     this.bindItemViewHolder(holder,position);
                 }
                 return;
             }
             if(isLoad && position==(itemNumber-1)){
                 RefreshView view=holder.itemView.findViewById(R.id.pic);
                 view.setRotation(180);
                    return;
             }
            this.bindItemViewHolder(holder,position);
         }
         public void bindItemViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

         }
         @Override
         public int getItemCount() {
             itemNumber=setCount();
             if(isRefresh){
                 itemNumber+=1;
             }
             if(isLoad){
                 itemNumber+=1;
             }
             Log.d(TAG, "getItemCount: "+isRefresh);
             Log.d(TAG, "getItemCount: "+isLoad);
             Log.d(TAG, "getItemCount: "+itemNumber);
             return itemNumber;
         }
         public int setCount(){
             return  0;
         }

         @Override
         public int getItemViewType(int position) {
             if(isRefresh && position==0){
                 return -1;
             }
             if(isLoad && position==(itemNumber-1)){
                 return -2;
             }
             return getViewType(position);
         }

         public int getViewType(int position) {
             return 0;
         }
     }
}
