package com.example.russ.refreshLoadView;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      RefreshLoadView loadView=findViewById(R.id.recycler_view);
      loadView.setAdapter(new MyAdapter(true,true));
      loadView.setLayoutManager(new LinearLayoutManager(this));

    }



    static class MyAdapter extends RefreshLoadView.Adapter<MyHolder>{

        MyAdapter(boolean isRefresh, boolean isLoad) {
            super(isRefresh, isLoad);
        }

        @Override
        public int setCount() {
            return 20;
        }



        @Override
        public RecyclerView.ViewHolder createItemViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MyHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false));
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void bindItemViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
                   TextView view= holder.itemView.findViewById(R.id.text);
                   view.setText("第"+position+"项");
        }

        @Override
        public int getViewType(int position) {
            return super.getViewType(position);
        }
    }

    static class MyHolder extends RefreshLoadView.ViewHolder{

        MyHolder(View itemView) {
            super(itemView);
        }
    }



}
