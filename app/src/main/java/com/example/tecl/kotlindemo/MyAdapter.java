package com.example.tecl.kotlindemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.example.tecl.kotlindemo.adapter.LiveRecyclerAdapter;
import com.example.tecl.kotlindemo.bean.HomePageLiveData;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends Activity{
    private RecyclerView mRecyclerView ;
    private CommonAdapter commonAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<HomePageLiveData> list = new ArrayList<>();
//        commonAdapter=new LiveRecyclerAdapter(this,R.layout.homepage_info_recycler_adapter,list);
    }
}
