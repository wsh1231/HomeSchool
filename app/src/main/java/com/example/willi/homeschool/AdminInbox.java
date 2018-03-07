package com.example.willi.homeschool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdminInbox extends AppCompatActivity {

    RecyclerView recyclerView;
    RecycleViewAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_inbox);

        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new VerticalSpace(20));
        mAdapter = new RecycleViewAdapter(this);
        recyclerView.setAdapter(mAdapter);
        feedData();
    }

    private void feedData() {
        String[] imageUrls = {"https://cdn.vox-cdn.com/thumbor/PGy7ZvBUHVPW-G1o5_DHuRHANTQ=/0x0:2500x1667/920x613/filters:focal(1050x634:1450x1034):format(webp)/cdn.vox-cdn.com/uploads/chorus_image/image/58862917/iphone-6s-plus-2-7.0.0.jpg"};
        String[] titles = {"I got my iPhone’s battery replaced, and I’m angry Apple didn’t tell me to sooner"};
        String[] description = {"Two weeks ago, I went to an Apple Store and had a new battery put in my iPhone 6S. The very next day, I realized how unusable my old battery had been making my phone."};

        List<ItemDataModel> itemDataModels = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            for(int j = 0; j < titles.length; j++){
                ItemDataModel itemDataModel = new ItemDataModel(imageUrls[j],titles[j], description[j]);
                itemDataModels.add(itemDataModel);
            }
        }

        mAdapter.addModels(itemDataModels);
    }
}
