package com.example.danielkwok.recycleviewapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ImageViewHolder>{

    private int[] images;
    private Context context;
    public AlbumAdapter(int[] images, Context context){
        this.images = images;
        this.context = context;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = (View)layoutInflater.inflate(R.layout.album_layout, viewGroup, false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view, context, images);

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
    public static class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView image;
        TextView imageTitle;
        Context context;
        int[] images;

        private ImageViewHolder(View v, Context context, int[] images){
            super(v);
            this.image = v.findViewById(R.id.image);
            this.imageTitle = v.findViewById(R.id.imageTitle);
            this.context = context;
            this.images = images;
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, DisplayActivity.class);
            intent.putExtra("image_id", images[getAdapterPosition()]);
            context.startActivity(intent);
        }
    }
}