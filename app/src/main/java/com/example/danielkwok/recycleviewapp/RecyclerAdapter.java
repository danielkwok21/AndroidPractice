package com.example.danielkwok.recycleviewapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

//this subclass of recyclerView.Adapter manages viewHolders
//creates viewHolders as required, based on given input data
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.AndroidNamesViewHolder> {

    private List<String> list;

    public RecyclerAdapter(List<String> l){
        this.list = l;
    }

    //primary method #1
    //to inflate item layout and create holder
    @NonNull
    @Override
    public AndroidNamesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        //inflate layout
        TextView textView = (TextView)layoutInflater.inflate(R.layout.text_view_layout, viewGroup, false);
        AndroidNamesViewHolder androidNamesViewHolder = new AndroidNamesViewHolder(textView);

        return androidNamesViewHolder;
    }

    //primary method #2
    //to set view attr based on data
    @Override
    public void onBindViewHolder(AndroidNamesViewHolder viewHolder, int i) {
        viewHolder.versionName.setText(list.get(i));
    }

    //primary method #3
    //to determine number of items
    @Override
    public int getItemCount() {
        return list.size();
    }

    //any object of this class is a viewHolder, ie the components that the recyclerView is made up of
    public static class AndroidNamesViewHolder extends RecyclerView.ViewHolder{

        //viewHolder member variable
        TextView versionName;

        public AndroidNamesViewHolder(TextView tv) {
            //stores tv in public scope so other ViewHolder instance can access as well
            super(tv);
            versionName = tv;
        }
    }
}
