package com.example.willi.homeschool;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by willi on 17/02/2018.
 */

public class RecycleViewAdapter extends RecyclerView.Adapter {
    Context context;
    List<ItemDataModel> itemDataModels;

public RecycleViewAdapter(Context context){
    this.context = context;
    itemDataModels=new ArrayList<>();

}
public void addModels(List<ItemDataModel>itemDataModels){
    int pos=this.itemDataModels.size();
    this.itemDataModels.addAll(itemDataModels);
    notifyItemRangeInserted(pos, itemDataModels.size());
}


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View row=inflater.inflate(R.layout.custom_row_item, parent, false);
        return new ItemHolder(row);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ItemDataModel mCurrentItems=itemDataModels.get(position);
        ItemHolder itemHolder= (ItemHolder) holder;
        Picasso.with(context).load(mCurrentItems.imageUrl).resize(900,300).into(itemHolder.imageViewThumbnail);
        itemHolder.textViewTitle.setText(mCurrentItems.title);
        itemHolder.textViewDescription.setText(mCurrentItems.description);
    }

    @Override
    public int getItemCount() {
        return itemDataModels.size();
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
