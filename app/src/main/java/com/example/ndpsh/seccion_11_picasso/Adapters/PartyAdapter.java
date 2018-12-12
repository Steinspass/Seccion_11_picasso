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

public class PartyAdapter extends RecyclerView.Adapter<PartyAdapter.ViewHolder> {

    private Context context;
    private int[] parties;
    private int layout;

    public PartyAdapter(Context context, int[] parties, int layout) {
        this.context = context;
        this.parties = parties;
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
        Picasso.get().load(parties[position]).fit().placeholder(R.drawable.spinner).into(viewHolder.image);

    }

    @Override
    public int getItemCount() {
        return parties.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            this.image = itemView.findViewById(R.id.imageViewLayout);
        }

    }
}
