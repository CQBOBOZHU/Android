package com.imageviewdemo.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.imageviewdemo.R;

import java.util.List;

/**
 * Created by Administrator on 2016/11/5.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    List<String> list;
    View view;
    public RecyclerAdapter(List<String> list, Context context, int viewId){
        this.list=list;
        this.view= LayoutInflater.from(context).inflate(viewId,null);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(list.get(position)+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends ViewHolder {
        TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView= (TextView) view.findViewById(R.id.item_textview);
        }
    }
}
