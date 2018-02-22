package com.example.willi.homeschool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class AdminInbox extends AppCompatActivity {

    RecyclerView recyclerView;
    String[] items={"Item 0", "Item 1","Item 2","Item 3","Item 4","Item 5","Item 6","Item 7","Item 8","Item 9","Item 10","Item 11", "Item 12", "Item 13","Item 14","Item 15","Item 16","Item 17","Item 18","Item 19","Item 20"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_inbox);

        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new VerticalSpace(20));
        recyclerView.setAdapter(new RecycleViewAdapter(items, this));

    }
}
