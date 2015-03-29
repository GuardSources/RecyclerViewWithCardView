package com.taobao.recyclerviewwithcardview.ui.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.taobao.recyclerviewwithcardview.R;
import com.taobao.recyclerviewwithcardview.data.DataSource;
import com.taobao.recyclerviewwithcardview.ui.adapter.MainAdapter;


public class MainActivity extends ActionBarActivity
{
    private RecyclerView mRecyclerView;
    private MainAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.main_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new MainAdapter(DataSource.generateData(20));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new MainAdapter.OnItemClickListener()
        {
            @Override
            public void onItemClick(View view, String data)
            {
                Toast.makeText(MainActivity.this,"data:"+data,Toast.LENGTH_SHORT).show();
            }
        });
    }
}

















