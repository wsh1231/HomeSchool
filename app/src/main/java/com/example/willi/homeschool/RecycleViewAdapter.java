package com.example.willi.homeschool;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by willi on 17/02/2018.
 */

public class RecycleViewAdapter extends RecyclerView.Adapter {
    String[] items;
    Context context;



    public RecycleViewAdapter(String[] items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View row=inflater.inflate(R.layout.custom_row_item, parent, false);
        return new ItemHolder(row);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Picasso.with(context).load(R.drawable.lumia).resize(900,300).into(((ItemHolder)holder).imageViewThumbnail);
    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    private class ItemHolder extends RecyclerView.ViewHolder{
        TextView textViewTitle, textViewDescription;
        ImageView imageViewThumbnail;

        public ItemHolder(View itemView) {
            super(itemView);
            textViewTitle=itemView.findViewById(R.id.textViewTitle);
            textViewDescription=itemView.findViewById(R.id.textViewDescription);
            imageViewThumbnail=itemView.findViewById(R.id.imageViewThumbnail);
        }
    }
}
