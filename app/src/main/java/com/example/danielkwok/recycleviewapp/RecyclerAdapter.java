package com.example.danielkwok.recycleviewapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

//this class, a child of recyclerView.Adapter manages viewHolders
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private List<String> list;

    public RecyclerAdapter(List<String> l){
        this.list = l;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        TextView textView = (TextView)LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.text_view_layout, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(textView);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int i) {
        viewHolder.versionName.setText(list.get(i));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //any object of this class is a viewHolder, ie the coponents that the recyclerView is made up of
    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView versionName;

        public MyViewHolder(TextView tv) {
            super(tv);
            versionName = tv;
        }
    }
}
