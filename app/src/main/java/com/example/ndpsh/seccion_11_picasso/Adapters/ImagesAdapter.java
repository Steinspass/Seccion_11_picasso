package com.example.ndpsh.seccion_11_picasso.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.ndpsh.seccion_11_picasso.R;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.List;

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ViewHolder> {


    private Context context;
    private List<String> images;
    private int layout;

    public ImagesAdapter(Context context, List<String> images, int layout){
        this.context = context;
        this.images = images;
        this.layout = layout;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(layout, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Picasso.get().load(new File(images.get(position))).fit().placeholder(R.drawable.spinner).into(viewHolder.image);

    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            this.image = itemView.findViewById(R.id.imageViewLayout);
        }

    }
}
