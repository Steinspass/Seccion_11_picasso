package com.example.ndpsh.seccion_11_picasso.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ndpsh.seccion_11_picasso.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.ViewHolder> {


    private Context context;
    private String[] animals;
    private int layout;


    public AnimalAdapter(Context context, String[] animals, int layout){
        this.context = context;
        this.animals = animals;
        this.layout = layout;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(layout, viewGroup, false );
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int position) {
        Picasso.get().load(animals[position]).fit().placeholder(R.drawable.spinner).into(viewHolder.image, new Callback() {

            @Override
            public void onSuccess() {
               //viewHolder.image.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onError(Exception e) {
                Toast.makeText(context, "Error!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return animals.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            this.image = itemView.findViewById(R.id.imageViewLayout);
        }

    }


}
