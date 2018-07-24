package com.example.danielkwok.recycleviewapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ImageViewHolder>{

    private int[] images;   //p.s. images are stores as int arrays
    public AlbumAdapter(int[] images){
        this.images = images;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = (View)layoutInflater.inflate(R.layout.album_layout, viewGroup, false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view);

        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder viewHolder, int i) {
        int image_id = images[i];

        //setting attr of viewHolder
        viewHolder.image.setImageResource(image_id);
        viewHolder.imageTitle.setText("Image "+i);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    //creating viewHolder
    public static class ImageViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView imageTitle;

        public ImageViewHolder(View v){
            super(v);
            image = v.findViewById(R.id.image);
            imageTitle = v.findViewById(R.id.imageTitle);

        }
    }
}