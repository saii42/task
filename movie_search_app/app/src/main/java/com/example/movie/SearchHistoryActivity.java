package com.example.movie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class SearchHistoryActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ArrayList<String> searchHistoryList;
    private RecyclerView.LayoutManager mLayoutManager;

    private ArrayList<String> arrayList;
    private SearchHistoryListAdapter searchHistoryListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_history);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_resent_search);

        Intent intent = getIntent();
        searchHistoryList = intent.getStringArrayListExtra("list");
        arrayList = new ArrayList<>(searchHistoryList);

        searchHistoryListAdapter = new SearchHistoryListAdapter(arrayList);
        mRecyclerView.setAdapter(searchHistoryListAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}