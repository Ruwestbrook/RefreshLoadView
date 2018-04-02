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
      loadView.setAdapter(new MyAdapter());
      loadView.setLayoutManager(new LinearLayoutManager(this));

    }



    static class MyAdapter extends RefreshLoadView.Adapter<MyHolder>{

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MyHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false));

        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
                   TextView view= holder.itemView.findViewById(R.id.text);
                   view.setText("第"+position+"项");
                   RefreshView refreshView=holder.itemView.findViewById(R.id.pic);
                   if(position%2==0){
                       refreshView.setRotation(180);
                   }

        }

        @Override
        public int getItemCount() {
            return 10;
        }
    }

    static class MyHolder extends RefreshLoadView.ViewHolder{

        public MyHolder(View itemView) {
            super(itemView);
        }
    }



}
